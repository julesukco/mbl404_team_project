package com.jfrankum.week4;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * This class performs the IO operations required to perform a search against the remote
 * MongoDB database. Database sits behind a REST web service that returns a JSON response
 * with the clinic information.
 */
public class SearchTask extends AsyncTask<String, Void, ArrayList<Clinic>> {

    private ListView resultsList;
    private Context context;

    public SearchTask(Context context, ListView resultsList) {
        this.context = context;
        this.resultsList = resultsList;
    }

    /**
     * Background operation that performs the network call and converts the response to a list
     * of Clinic objects.
     *
     * @param params URL to call, including the search parameters.
     * @return
     */
    @Override
    protected ArrayList<Clinic> doInBackground(String... params) {

        // Search for the clinics based on the search parameter passed in
        ClinicDBHelper clinicDBHelper = new ClinicDBHelper(context);
        ArrayList<Clinic> clinics = new ArrayList<Clinic>();
        switch (params[0]) {
            case "name":
                clinics = clinicDBHelper.findClinicByName(params[1]);
                break;
            case "zip":
                clinics = clinicDBHelper.findClinicByZip(params[1]);
                break;
            case "status":
                clinics = clinicDBHelper.findClinicByStatus(params[1]);
                break;
        }

        return clinics;
    }

    /**
     * Once background processing is complete a list of clinics will be passed in.
     * Build the adapter and populate the data into the ListView
     *
     * @param clinicList
     */
    @Override
    protected void onPostExecute(ArrayList<Clinic> clinicList) {
        Log.i("ClinicSearch", "Found " + clinicList.size() + " clinics");

        if (clinicList.size() == 0) {
            Toast.makeText(context, "No clinics found", Toast.LENGTH_LONG).show();
            return;
        }

        long[] clinicIds = new long[clinicList.size()];
        String[] clinicTitles = new String[clinicList.size()];
        String[] clinicNames = new String[clinicList.size()];
        String[] clinicStatus = new String[clinicList.size()];
        String[] clinicLat = new String[clinicList.size()];
        String[] clinicLon = new String[clinicList.size()];

        Clinic clinic;

        for (int i = 0; i < clinicList.size(); i++) {
            clinic = clinicList.get(i);
            clinicIds[i] = clinic.getId();
            clinicTitles[i] = clinic.getTitle();
            clinicNames[i] = clinic.getAddress() + ", " + clinic.getCity() + "," + clinic.getState();
            clinicStatus[i] = clinic.getStatus();
            clinicLat[i] = clinic.getLat();
            clinicLon[i] = clinic.getLon();
        }

        ArrayAdapter<String> adapter = new ClinicAdapter(context, clinicIds, clinicTitles,
                clinicNames, clinicStatus, clinicLat, clinicLon);
        resultsList.setAdapter(adapter);
    }
}
