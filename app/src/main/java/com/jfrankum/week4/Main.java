package com.jfrankum.week4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button btnNameSearch = (Button) findViewById(R.id.btnNameSearch);
        btnNameSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Results.class);
                startActivity(intent);

            }
        });

        Button btnZipSearch = (Button) findViewById(R.id.btnZipSearch);
        btnZipSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Results.class);
                startActivity(intent);

            }
        });

        Button btnStatusSearch = (Button) findViewById(R.id.btnStatusSearch);
        btnStatusSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Results.class);
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

}
