package com.jfrankum.week4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashActivity.this, Main.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();

        // Insert a couple of rows of test data
        createDummyData();

    }

    private void createDummyData() {
        // Dummy code to insert a few clinics to get us started
        ClinicDBHelper clinicDBHelper = new ClinicDBHelper(getApplicationContext());
        Clinic clinic = new Clinic(1, "The Clinic", "1 Main St.", "Anytown", "IA", "30303",
                "Center Director", "Dr. Jones", "202-555-1212",
                "http://phoenix.edu", "Open", "34.00", "100.00");
        try {
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }

        clinic = new Clinic(2, "The New Clinic", "123 West Ave.", "Sometown", "IA", "40404",
                "Lead Physician", "Dr. Smith", "101-555-1212",
                "http://google.com", "Closed", "33.00", "104.00");
        try {
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }

        clinic = new Clinic(3, "Little Clinic", "123 West Ave.", "Morristown", "NJ", "08134",
                "Owner", "Dr. Weather", "555-123-4567",
                "http://cnn.com", "Closed", "34.00", "102.00");
        try {
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }

        clinic = new Clinic(4, "Main St Urgent Care", "123 West Ave.", "Chester", "NJ", "08732",
                "Head Physician", "Dr. South", "666-555-1874",
                "http://yahoo.com", "Closed", "35.00", "106.00");
        try {
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }

        clinic = new Clinic(5, "24hr Emergency", "123 West Ave.", "Madison", "WI", "60123",
                "Physician", "Dr. North", "777-555-1212",
                "http://lynda.com", "Open", "36.00", "101.00");
        try {
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }

        clinic = new Clinic(6, "Family Clinic", "123 West Ave.", "Chicago", "IL", "50962",
                "Lead Doctor", "Dr. East", "888-555-1212",
                "http://pocket.com", "Closed", "37.00", "103.00");
        try {
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }

        clinic = new Clinic(7, "Immediate Care", "123 West Ave.", "New York", "NY", "01021",
                "Partner", "Dr. West", "234-555-1212",
                "http://gmail.google.com", "Open", "38.00", "102.00");
        try {
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }

    }
}