package com.jfrankum.week4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ClinicDBHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "tblClinics";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_STATE = "state";
    private static final String COLUMN_ZIP = "zip";
    private static final String COLUMN_CONTACT_POS = "position";
    private static final String COLUMN_CONTACT_NAME = "name";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_WEBSITE = "website";
    private static final String COLUMN_STATUS = "status";
    private static final String COLUMN_LAT = "lat";
    private static final String COLUMN_LONG = "lon";

    private Context myContext;

    // TYPICAL CREATE STATEMENTS
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                    COLUMN_ADDRESS + TEXT_TYPE + COMMA_SEP +
                    COLUMN_CITY + TEXT_TYPE + COMMA_SEP +
                    COLUMN_STATE + TEXT_TYPE + COMMA_SEP +
                    COLUMN_ZIP + TEXT_TYPE + COMMA_SEP +
                    COLUMN_CONTACT_POS + TEXT_TYPE + COMMA_SEP +
                    COLUMN_CONTACT_NAME + TEXT_TYPE + COMMA_SEP +
                    COLUMN_PHONE + TEXT_TYPE + COMMA_SEP +
                    COLUMN_WEBSITE + TEXT_TYPE + COMMA_SEP +
                    COLUMN_STATUS + TEXT_TYPE + COMMA_SEP +
                    COLUMN_LAT + TEXT_TYPE + COMMA_SEP +
                    COLUMN_LONG + TEXT_TYPE +
                    " )";

    // TYPICAL DELETE
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public ClinicDBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.myContext = context;
        }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public long insertClinic(Clinic clinic) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, clinic.getId());
        values.put(COLUMN_TITLE, clinic.getTitle());
        values.put(COLUMN_ADDRESS, clinic.getAddress());
        values.put(COLUMN_CITY, clinic.getCity());
        values.put(COLUMN_STATE, clinic.getState());
        values.put(COLUMN_ZIP, clinic.getZip());
        values.put(COLUMN_CONTACT_POS, clinic.getPosition());
        values.put(COLUMN_CONTACT_NAME, clinic.getName());
        values.put(COLUMN_PHONE, clinic.getPhone());
        values.put(COLUMN_WEBSITE, clinic.getWebsite());
        values.put(COLUMN_STATUS, clinic.getStatus());
        values.put(COLUMN_LAT, clinic.getLat());
        values.put(COLUMN_LONG, clinic.getLon());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_NAME, null, values);

        return newRowId;
    }

    /**
     * Retrieve the clinic that match to the id parameter
     * @param queryParam
     * @return
     */
    public Clinic findClinicById(long id) {
        String sqlQuery = "WHERE " + COLUMN_ID + " = " + id + "";
        ArrayList<Clinic> clinics = getClinics(sqlQuery);

        // search by id should return a single row if found
        if (clinics.size() == 1) {
            return clinics.get(0);
        } else {
            return null;
        }
    }

    /**
     * Retrieve all clinics that match to the name parameter
     * @param queryParam
     * @return
     */
    public ArrayList<Clinic> findClinicByName(String queryParam) {
        String sqlQuery = "WHERE " + COLUMN_TITLE + " LIKE '%" + queryParam + "%'";
        return getClinics(sqlQuery);
    }

    /**
     * Retrieve all clinics that match to the name parameter
     * @param queryParam
     * @return
     */
    public ArrayList<Clinic> findClinicByZip(String queryParam) {
        String sqlQuery = "WHERE " + COLUMN_ZIP + " LIKE '%" + queryParam + "%'";
        return getClinics(sqlQuery);
    }

    /**
     * Retrieve all clinics that match to the name parameter
     * @param queryParam
     * @return
     */
    public ArrayList<Clinic> findClinicByStatus(String queryParam) {
        String sqlQuery = "WHERE " + COLUMN_STATUS + " LIKE '%" + queryParam + "%'";
        return getClinics(sqlQuery);
    }

    /**
     * Retrieve all clinics in the db
     * @return
     */
    public ArrayList<Clinic> getAllClinics() {
        return getClinics("");
    }


    /**
     * Retrieve all clinics for a given, optional, where clause passed in
     * @return
     */
    private ArrayList<Clinic> getClinics(String sqlQuery) {

        ArrayList<Clinic> clinicEntries = new ArrayList<Clinic>();
        SQLiteDatabase db = this.getReadableDatabase();
        Clinic clinic;

        Cursor cursor = db.rawQuery("SELECT " + COLUMN_ID + ", " + COLUMN_TITLE + ", " +
                COLUMN_ADDRESS + ", " + COLUMN_CITY + ", " +
                COLUMN_STATE + ", " + COLUMN_ZIP + ", " + COLUMN_CONTACT_POS + ", " +
                COLUMN_CONTACT_NAME + ", " + COLUMN_PHONE + ", " +
                COLUMN_WEBSITE + ", " + COLUMN_STATUS + ", " +
                COLUMN_LAT + ", " +
                COLUMN_LONG + " FROM " + TABLE_NAME + " " + sqlQuery, new String[]{});

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            clinic = new Clinic();
            clinic.setId(cursor.getLong(0));
            clinic.setTitle(cursor.getString(1));
            clinic.setAddress(cursor.getString(2));
            clinic.setCity(cursor.getString(3));
            clinic.setState(cursor.getString(4));
            clinic.setZip(cursor.getString(5));
            clinic.setPosition(cursor.getString(6));
            clinic.setName(cursor.getString(7));
            clinic.setPhone(cursor.getString(8));
            clinic.setWebsite(cursor.getString(9));
            clinic.setStatus(cursor.getString(10));
            clinic.setLat(cursor.getString(11));
            clinic.setLon(cursor.getString(12));

            clinicEntries.add(clinic);
            cursor.moveToNext();
        }

        cursor.close();
        db.close();
        return clinicEntries;
    }
}