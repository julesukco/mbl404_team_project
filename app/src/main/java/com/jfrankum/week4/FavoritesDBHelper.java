package com.jfrankum.week4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * General purpose class for performing all DB operations.
 */
public class FavoritesDBHelper extends SQLiteOpenHelper {

    private static final String TABLE_SEARCH = "tblFavorites";
    private static final String SEARCH_ID = "search_id";
    private static final String SEARCH_NAME = "name";
    private static final String SEARCH_LOCATION = "location";
    private static final String SEARCH_STATUS = "status";
    Context myContext;

    private static final String DATABASE_NAME = "schools.db";
    private static final int DATABASE_VERSION = 1;
    private final String createSearchSQL = "CREATE TABLE " + TABLE_SEARCH + " (" +
            SEARCH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            SEARCH_NAME + " TEXT, " +
            SEARCH_LOCATION + " TEXT, " +
            SEARCH_STATUS + " TEXT);";

    FavoritesDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createSearchSQL);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        myContext.deleteDatabase(DATABASE_NAME);
    }

    /**
     * Add a new entry into the db
     *
     * @param
     */
    public long addSearchEntry(Search search) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SEARCH_NAME, search.getName());
        values.put(SEARCH_LOCATION, search.getLocation());
        values.put(SEARCH_STATUS, search.getStatus());

        long searchId = db.insert(TABLE_SEARCH, null, values);
        db.close();

        Toast.makeText(myContext, "Search Added to Favorites", Toast.LENGTH_LONG).show();
        return searchId;
    }

    /**
     * Return a list of all searches from the db
     *
     * @return
     */
    public ArrayList<Search> getSearches() {

        ArrayList<Search> searches = new ArrayList<Search>();
        SQLiteDatabase db = this.getReadableDatabase();
        Search search;

        Cursor cursor = db.rawQuery("SELECT " + SEARCH_ID + ", " + SEARCH_NAME + ", " +
                SEARCH_LOCATION + ", " + SEARCH_STATUS +
                " FROM " + TABLE_SEARCH, new String[]{});

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            search = new Search(cursor.getLong(0), cursor.getString(1),
                    cursor.getString(2), cursor.getString(3));

            searches.add(search);
            cursor.moveToNext();
        }

        cursor.close();
        db.close();
        return searches;
    }
}
