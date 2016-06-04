package com.jfrankum.week4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {

    // Create variables for the static map
    public static String mapPartOne = "https://maps.googleapis.com/maps/api/staticmap?";
    public static String mapKey = "";
    public String lat = "";
    public String lon = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);


        // Make sure required parameters are passed in
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Toast.makeText(getApplicationContext(), "Clinic Info Not Passed", Toast.LENGTH_LONG).show();
            return;
        }

        // Determine search type to perform
        String id = extras.getString("id");
        if (id == null) {
            Toast.makeText(getApplicationContext(), "Clinic Id Not Passed", Toast.LENGTH_LONG).show();
            return;
        }

        showClinic(Long.parseLong(id));


        Button btnViewMap = (Button) findViewById(R.id.btnViewMap);
        btnViewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                asyncMap();
            }
        });

        Button btnCall = (Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Invoke the call intent to call the phone number
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                TextView tvPhone = (TextView) findViewById(R.id.txtContactPhone);

                // remove any dashes in the phone number as this breaks the dialer
                callIntent.setData(Uri.parse("tel:" + tvPhone.getText().toString().replace("-", "")));
                startActivity(callIntent);

            }
        });

        Button btnWebsite = (Button) findViewById(R.id.btnWebsite);
        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView tvWebSite = (TextView) findViewById(R.id.txtContactWebsite);
                final String url = tvWebSite.getText().toString();

                Runnable runnable = new Runnable() {
                    public void run() {

                        Uri uri = Uri.parse(url);
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);

                    }
                };
                Thread myThread = new Thread(runnable);
                myThread.start();

            }
        });

        Button btnSaveContact = (Button) findViewById(R.id.btnSaveContact);
        btnSaveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Contact Saved", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void asyncMap() {
        Runnable runnable = new Runnable() {
            public void run() {

                Uri uri = Uri.parse(mapPartOne + "center=" + lat + ", " + lon + "&zoom=14&size=600x300&maptype=roadmap&key=" + mapKey);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        };
        Thread myThread = new Thread(runnable);
        myThread.start();
    }

    private void showClinic(long id) {
        ClinicDBHelper clinicDBHelper = new ClinicDBHelper(getApplicationContext());
        Clinic clinic = clinicDBHelper.findClinicById(id);

        if (clinic == null) {
            Toast.makeText(getApplicationContext(), "Clinic id " + Long.toString(id) +
                    " Not Found", Toast.LENGTH_SHORT).show();
            return;
        }

        TextView tvTitle = (TextView) findViewById(R.id.txtTitle);
        tvTitle.setText(clinic.getTitle());
        TextView tvContactTitle = (TextView) findViewById(R.id.txtContactTitle);
        tvContactTitle.setText(clinic.getPosition());
        TextView tvContactsName = (TextView) findViewById(R.id.txtContactsName);
        tvContactsName.setText(clinic.getName());
        TextView tvContactPhone = (TextView) findViewById(R.id.txtContactPhone);
        tvContactPhone.setText(clinic.getPhone());
        TextView tvContactWebsite = (TextView) findViewById(R.id.txtContactWebsite);
        tvContactWebsite.setText(clinic.getWebsite());
        lat = clinic.getLat();
        lon = clinic.getLon();

    }
}
