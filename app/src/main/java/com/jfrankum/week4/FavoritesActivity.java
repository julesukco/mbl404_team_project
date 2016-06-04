package com.jfrankum.week4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        populateFavorites();

        ListView resultsList = (ListView) findViewById(R.id.listView);

        resultsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), Results.class);

                TextView tvSearchType = (TextView) findViewById(R.id.txtSearchType);
                String searchType = tvSearchType.getText().toString();
                intent.putExtra("type", searchType);

                TextView tvSearchParam = (TextView) findViewById(R.id.txtSearchParam);
                String searchParam = tvSearchParam.getText().toString();
                intent.putExtra("name", searchParam);

                startActivity(intent);
            }
        });
    }

    private void populateFavorites() {

        FavoritesDBHelper favoritesDBHelper = new FavoritesDBHelper(getApplicationContext());
        ArrayList<Search> favorites = favoritesDBHelper.getSearches();

        long[] searchIds = new long[favorites.size()];
        String[] names = new String[favorites.size()];
        String[] statuses = new String[favorites.size()];
        String[] locations = new String[favorites.size()];

        Search search;

        for (int i = 0; i < favorites.size(); i++) {
            search = favorites.get(i);
            searchIds[i] = search.getId();
            names[i] = search.getName();
            locations[i] = search.getLocation();
            statuses[i] = search.getStatus();
        }

        ArrayAdapter<String> adapter = new FavoritesAdapter(getApplicationContext(), searchIds,
                names, locations, statuses);

        ListView resultsList = (ListView) findViewById(R.id.listView);
        resultsList.setAdapter(adapter);
    }
}
