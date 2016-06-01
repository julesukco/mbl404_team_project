package com.jfrankum.week4;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_layout);

        // Make sure required parameters are passed in
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Toast.makeText(getApplicationContext(), "Search Info Not Passed", Toast.LENGTH_LONG).show();
            return;
        }

        // Determine search type to perform
        String type = extras.getString("type");
        if (type == null) {
            Toast.makeText(getApplicationContext(), "Search Type Not Passed", Toast.LENGTH_LONG).show();
            return;
        }

        // Search for the clinics based on the search parameter passed in
        ClinicDBHelper clinicDBHelper = new ClinicDBHelper(getApplicationContext());
        ArrayList<Clinic> clinics = new ArrayList<Clinic>();
        switch (type) {
            case "name":
                clinics = clinicDBHelper.findClinicByName(extras.getString(type));
                break;
            case "zip":
                clinics = clinicDBHelper.findClinicByZip(extras.getString(type));
                break;
            case "status":
                clinics = clinicDBHelper.findClinicByStatus(extras.getString(type));
                break;
        }

        Toast.makeText(getApplicationContext(), "Found " + clinics.size() + " clinics", Toast.LENGTH_LONG).show();


        Button btnSaveSearch = (Button) findViewById(R.id.btnSaveSearch);
        btnSaveSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Search Saved", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnDetail = (Button) findViewById(R.id.btnDetail);
        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Details.class);
                startActivity(intent);
            }
        });


    }

}
