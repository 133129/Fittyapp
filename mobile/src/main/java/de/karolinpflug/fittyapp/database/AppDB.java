package de.karolinpflug.fittyapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class AppDB extends SQLiteOpenHelper {
    public static final String TAG = "AppDB";

    public static final String UID = "uid";
    public static final String WORKOUT_PLAN_NAME = "workout_plan_name";
    public static final String EXERCISES_NAME = "exercise_name";

    /** name of the database */
    private static final String APP_DB = "appDB";
    /** version of the database */
    private static final int DB_VERSION = 1;

    /** name of the Date table */
    public static final String WORKOUT_PLAN_TABLE = "workout_plans";
    /** string to create Date table */
    private static final String WORKOUT_PLAN_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + WORKOUT_PLAN_TABLE + " (" +
            UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            WORKOUT_PLAN_NAME + " TEXT NOT NULL);";

    /** name of the Date table */
    public static final String EXERCISES_TABLE = "exercises";
    /** string to create Date table */
    private static final String EXERCISES_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + EXERCISES_TABLE + " (" +
            UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            EXERCISES_NAME + " TEXT NOT NULL);";


    /**
     * constructor of this class
     * @param pContext context
     */
    public AppDB(Context pContext) {
        super(pContext, APP_DB, null, DB_VERSION);
        Log.d(TAG, APP_DB + "constructor");
    }

    /**
     * called when the database doesn't exist
     * creates all tables
     * @param db database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WORKOUT_PLAN_TABLE_CREATE);
        db.execSQL(EXERCISES_TABLE_CREATE);
    }

    /**
     * called when the database version rises
     * @param db database
     * @param oldVersion old DB-Version
     * @param newVersion new DB-Version
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
