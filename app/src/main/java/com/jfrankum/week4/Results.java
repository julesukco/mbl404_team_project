package com.jfrankum.week4;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Results extends AppCompatActivity {

    private Search mSearch;

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
        performSearch(extras, type);

        ListView resultsList = (ListView) findViewById(R.id.listView);

        resultsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Details.class);

                TextView tvId = (TextView) view.findViewById(R.id.itemId);
                intent.putExtra("id", tvId.getText().toString());
                startActivity(intent);
            }
        });

        Button btnSaveSearch = (Button) findViewById(R.id.btnSaveSearch);
        btnSaveSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FavoritesDBHelper favoritesDBHelper = new FavoritesDBHelper(getApplicationContext());
                favoritesDBHelper.addSearchEntry(mSearch);
            }
        });
    }

    private void performSearch(Bundle extras, String type) {

        ListView resultsList = (ListView) findViewById(R.id.listView);
        SearchTask searchTask = new SearchTask(getApplicationContext(), resultsList);
        searchTask.execute(type, extras.getString(type));

        mSearch = new Search (type, extras.getString(type));
    }

}
