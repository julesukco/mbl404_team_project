package com.jfrankum.week4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        // Insert a couple of rows of test data
        createDummyData();

        Button btnNameSearch = (Button) findViewById(R.id.btnNameSearch);
        btnNameSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Results.class);
                intent.putExtra("type", "name");
                TextView tvName = (TextView) findViewById(R.id.txtName);
                intent.putExtra("name", tvName.getText().toString());
                startActivity(intent);

            }
        });

        Button btnZipSearch = (Button) findViewById(R.id.btnZipSearch);
        btnZipSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Results.class);
                intent.putExtra("type", "zip");
                TextView tvZip = (TextView) findViewById(R.id.txtZip);
                intent.putExtra("zip", tvZip.getText().toString());
                startActivity(intent);

            }
        });

        Button btnStatusSearch = (Button) findViewById(R.id.btnStatusSearch);
        btnStatusSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Results.class);
                intent.putExtra("type", "status");
                TextView tvStatus = (TextView) findViewById(R.id.txtStatus);
                intent.putExtra("status", tvStatus.getText().toString());
                startActivity(intent);

            }
        });

        Button btnSavedSearches = (Button) findViewById(R.id.btnSavedSearches);
        btnSavedSearches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Saved.class);
                startActivity(intent);

            }
        });
    }

    private void createDummyData() {
        // Dummy code to insert a few clinics to get us started
        ClinicDBHelper clinicDBHelper = new ClinicDBHelper(getApplicationContext());
        Clinic clinic = new Clinic(1, "The Clinic", "1 Main St.", "Anytown", "IA", "30303",
                "Center Director", "Dr. Jones", "202-555-1212",
                "http://phoenix.edu","Open","34.00","100.00");
        clinicDBHelper.insertClinic(clinic);

        clinic = new Clinic(2, "The New Clinic", "123 West Ave.", "Sometown", "IA", "40404",
                "Lead Physician", "Dr. Smith", "101-555-1212",
                "http://developer.android.com","Closed","33.00","105.00");
        clinicDBHelper.insertClinic(clinic);
    }

}
