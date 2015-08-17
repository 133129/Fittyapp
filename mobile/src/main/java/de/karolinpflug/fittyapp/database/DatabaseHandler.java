package de.karolinpflug.fittyapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class DatabaseHandler {
    private static final String TAG = "DatabaseHandler";

    /** DatabaseHandler instance */
    private static DatabaseHandler mInstance = null;

    private Context mContext;
    private SQLiteDatabase mAppDatabase;

    /**
     * returns an instance of the handler
     * @param pContext context to open new handler
     * @return instance
     */
    public static DatabaseHandler getInstance(Context pContext){
        Log.d(TAG, "getDatabaseHandler instance!");
        if(mInstance == null){
            mInstance = new DatabaseHandler(pContext.getApplicationContext());
        }
        return mInstance;
    }

    /**
     * create a new DatabaseHandler
     * @param pContext context
     */
    private DatabaseHandler(Context pContext) {
        Log.d(TAG, "new DatabaseHandler!");
        mContext = pContext;
        mAppDatabase = new AppDB(pContext).getWritableDatabase();
        insertWorkoutplans();
    }

    public Cursor workoutPlanTableCursor(String andWhere) {
        //only show news that aren't deleted or hidden and order them by DATE descending
        return mAppDatabase.query(AppDB.WORKOUT_PLAN_TABLE, null, andWhere, null,
                null, null, null);
    }

    public void insertWorkoutplans() {
        ContentValues values = new ContentValues();
        values.put(AppDB.WORKOUT_PLAN_NAME, "Plan 1");
        values.put(AppDB.WORKOUT_PLAN_NAME, "Supertoller Plan");
        //insert created entry into table
        mAppDatabase.insert(AppDB.WORKOUT_PLAN_TABLE, null, values);
    }

    public void insertExercises() {
        ContentValues values = new ContentValues();
        values.put(AppDB.EXERCISES_NAME, "Uebung 1");
        values.put(AppDB.EXERCISES_NAME, "Supertolle UEbung");
        //insert created entry into table
        mAppDatabase.insert(AppDB.EXERCISES_TABLE, null, values);
    }

    /**
     *function to get the value of a field, the row is given by the id
     * @param pCursor cursor
     * @param pKey key
     * @return String Returns the result
     */
    public static String getCursorStringField(Cursor pCursor, String pKey) {
        return pCursor.getString(pCursor.getColumnIndex(pKey));
    }
}
