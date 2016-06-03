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

}
