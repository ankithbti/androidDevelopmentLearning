package com.example.ankithbti.testme;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

/**
 * Created by ankithbti on 14/04/16.
 */
public class DbHelper extends SQLiteOpenHelper {


    private final String TAG = " Ankit - DbHelper - ";
    public static final String DATABASE_NAME = "mydatabase1";
    public static final String TABLE_NAME = "employee_helper1";
    public static final String COL_UID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_EMAIL = "email";

    private final String createTable = "create table if not exists " + TABLE_NAME
            + "("
            + COL_UID + " integer primary key autoincrement,"
            + COL_NAME + " VARCHAR,"
            + COL_EMAIL + " VARCHAR"
            + ");";

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.beginTransaction();
        try {
            Log.i(TAG, " created table: " + TABLE_NAME);
            db.execSQL(createTable);
            db.setTransactionSuccessful();
        }catch(SQLException err){
            Log.i(TAG, " SQLException - " + err.toString());
        }
        db.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
//        db.beginTransaction();
//        try {
//            Log.i(TAG, " Database is upgraded to new version. ");
//            //db.execSQL("drop table " + TABLE_NAME);
//            //onCreate(db);
//            db.setTransactionSuccessful();
//        }catch(SQLException err){
//            Log.i(TAG, " SQLException - " + err.toString());
//        }
//        db.endTransaction();
    }
}
