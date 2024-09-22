package com.mk.madpractical;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UserData.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "UserDetails";

    private static final String COLUMN_UID = "uid";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_YOB = "yob";
    private static final String COLUMN_GNAME = "gname";
    private static final String COLUMN_STREET = "street";
    private static final String COLUMN_LOC = "loc";
    private static final String COLUMN_VTC = "vtc";
    private static final String COLUMN_PO = "po";
    private static final String COLUMN_DIST = "dist";
    private static final String COLUMN_SUBDIST = "subdist";
    private static final String COLUMN_STATE = "state";
    private static final String COLUMN_PC = "pc";
    private static final String COLUMN_DOB = "dob";
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COLUMN_UID + " TEXT PRIMARY KEY," +
                COLUMN_NAME + " TEXT," +
                COLUMN_GENDER + " TEXT," +
                COLUMN_YOB + " TEXT," +
                COLUMN_GNAME + " TEXT DEFAULT '-'," +  // Set default value to '-'
                COLUMN_STREET + " TEXT DEFAULT '-'," + // Set default value to '-'
                COLUMN_LOC + " TEXT DEFAULT '-'," +    // Set default value to '-'
                COLUMN_VTC + " TEXT DEFAULT '-'," +    // Set default value to '-'
                COLUMN_PO + " TEXT DEFAULT '-'," +     // Set default value to '-'
                COLUMN_DIST + " TEXT," +
                COLUMN_SUBDIST + " TEXT," +
                COLUMN_STATE + " TEXT," +
                COLUMN_PC + " TEXT," +
                COLUMN_DOB + " TEXT" +
                ")";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertData(String uid, String name, String gender, String yob, String gname, String street,
                           String loc, String vtc, String po, String dist, String subdist, String state,
                           String pc, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_UID, uid);
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_GENDER, gender);
        contentValues.put(COLUMN_YOB, yob);
        contentValues.put(COLUMN_GNAME, gname);
        contentValues.put(COLUMN_STREET, street);
        contentValues.put(COLUMN_LOC, loc);
        contentValues.put(COLUMN_VTC, vtc);
        contentValues.put(COLUMN_PO, po);
        contentValues.put(COLUMN_DIST, dist);
        contentValues.put(COLUMN_SUBDIST, subdist);
        contentValues.put(COLUMN_STATE, state);
        contentValues.put(COLUMN_PC, pc);
        contentValues.put(COLUMN_DOB, dob);

        db.insertWithOnConflict(TABLE_NAME, null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);
    }
    public ArrayList<String[]> getData() {
        ArrayList<String[]> dataList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query to get all the data from the table
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Iterating through all the rows and adding them to the list
        if (cursor.moveToFirst()) {
            do {
                String[] row = new String[]{
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_UID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_GENDER)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_YOB)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_GNAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_STREET)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LOC)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_VTC)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DIST)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SUBDIST)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_STATE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PC)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DOB))
                };
                dataList.add(row);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return dataList;
    }
    public ArrayAdapter<String[]> getAdapter(){
        return new DataAdapter(context,getData());
    }

    // Method to convert all data to JSON array
    public JSONArray getDataAsJsonArray() {
        JSONArray jsonArray = new JSONArray();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query to get all the data from the table
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Iterating through all the rows and converting them to JSON objects
        if (cursor.moveToFirst()) {
            do {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put(COLUMN_UID, getCursorValue(cursor, COLUMN_UID));
                    jsonObject.put(COLUMN_NAME, getCursorValue(cursor, COLUMN_NAME));
                    jsonObject.put(COLUMN_GENDER, getCursorValue(cursor, COLUMN_GENDER));
                    jsonObject.put(COLUMN_YOB, getCursorValue(cursor, COLUMN_YOB));
                    jsonObject.put(COLUMN_GNAME, getCursorValue(cursor, COLUMN_GNAME));
                    jsonObject.put(COLUMN_STREET, getCursorValue(cursor, COLUMN_STREET));
                    jsonObject.put(COLUMN_LOC, getCursorValue(cursor, COLUMN_LOC));
                    jsonObject.put(COLUMN_VTC, getCursorValue(cursor, COLUMN_VTC));
                    jsonObject.put(COLUMN_PO, getCursorValue(cursor, COLUMN_PO));
                    jsonObject.put(COLUMN_DIST, getCursorValue(cursor, COLUMN_DIST));
                    jsonObject.put(COLUMN_SUBDIST, getCursorValue(cursor, COLUMN_SUBDIST));
                    jsonObject.put(COLUMN_STATE, getCursorValue(cursor, COLUMN_STATE));
                    jsonObject.put(COLUMN_PC, getCursorValue(cursor, COLUMN_PC));
                    jsonObject.put(COLUMN_DOB, getCursorValue(cursor, COLUMN_DOB));

                    jsonArray.put(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return jsonArray;
    }


    private String getCursorValue(Cursor cursor, String columnName) {
        String value = cursor.getString(cursor.getColumnIndexOrThrow(columnName));
        return value != null ? value : "none"; // Return "none" if the value is null
    }


}

