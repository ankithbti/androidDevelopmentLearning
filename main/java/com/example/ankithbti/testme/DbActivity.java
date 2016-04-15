package com.example.ankithbti.testme;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.EditText;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.app.Activity;

/**
 * Created by ankithbti on 14/04/16.
 */
public class DbActivity extends Base_Activity {



    private final String TAG = "Ankit - DbActivity";
    EditText _nameTextField;
    EditText _emailTextField;
    EditText _dobTextField;
    DbHelper _dbHelper;
    SQLiteDatabase _db;
    ListView _listView;
    SimpleCursorAdapter _cursorAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, " On Create.");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_activity);

        /////
        // To Get DB
        /////
        //_dbHelper = new DbHelper(this);
        try {
            // Creating using Helper
            _dbHelper = new DbHelper(this);

            // For Direct Creation
            //_db = openOrCreateDatabase(DbHelper.DATABASE_NAME, MODE_PRIVATE, null);
            //_db.execSQL("CREATE TABLE IF NOT EXISTS " + DbHelper.TABLE_NAME + "(" + DbHelper.COL_NAME + " VARCHAR, " + DbHelper.COL_EMAIL + " VARCHAR);");
            //_db.execSQL("INSERT INTO " + DbHelper.TABLE_NAME + " VALUES('admin','admin');");
        }catch(SQLException err){
            Log.i(TAG, " Error: " + err.toString());
        }
        /////

        _nameTextField = (EditText) findViewById(R.id.dbName);
        _emailTextField = (EditText) findViewById(R.id.dbEmail);
        _dobTextField = (EditText) findViewById(R.id.dbDob);
        _listView = (ListView) findViewById(R.id.employeeList);

        String[] from = {DbHelper.COL_NAME, DbHelper.COL_EMAIL};
        String[] columns = {DbHelper.COL_UID, DbHelper.COL_NAME, DbHelper.COL_EMAIL};
        _db = _dbHelper.getWritableDatabase();
        Cursor cursor = _db.query(DbHelper.TABLE_NAME, columns, null, null, null, null, null);
        int[] to = {R.id.listName, R.id.listEmail};
        _cursorAdaptor = new SimpleCursorAdapter(this, R.layout.list_row, cursor, from, to);

        //Attach the cursor adaptor to the list
        _listView.setAdapter(_cursorAdaptor);
    }

    public void addToDB(View v){

        // This function will be called when button pressed
        Log.i(TAG, " inside addToDB() ");

        String name = _nameTextField.getText().toString();
        String email = _emailTextField.getText().toString();
        String dob = _dobTextField.getText().toString();

        try {
            ContentValues cv = new ContentValues();
            cv.put(DbHelper.COL_NAME, name);
            cv.put(DbHelper.COL_EMAIL, email);
            //cv.put(DbHelper.COL_DOB, dob);
            _db = _dbHelper.getWritableDatabase();
            _db.insert(DbHelper.TABLE_NAME, null, cv);
            Log.i(TAG, " Record inserted - Name: " + name + " , Email: " + email + " , Dob: " + dob);
        }catch(SQLException err){
            Log.w(TAG, " Error - " + err.toString());
        }

    }

    public void getData(View v){
        Log.i(TAG, " inside getData() ");
        try {
            String[] columns = {DbHelper.COL_UID, DbHelper.COL_NAME, DbHelper.COL_EMAIL};
            Cursor cursor = _db.query(DbHelper.TABLE_NAME, columns, null, null, null, null, null);
            _db = _dbHelper.getReadableDatabase();
            cursor.moveToFirst();
            while (cursor.moveToNext()) {
                int duration = Toast.LENGTH_SHORT;
                String msg = " Name: " + cursor.getString(cursor.getColumnIndex(DbHelper.COL_NAME))
                        + " Email: " + cursor.getString(cursor.getColumnIndex(DbHelper.COL_EMAIL));
                Toast toastMsg = Toast.makeText(getApplicationContext(), msg, duration);
                toastMsg.show();
            }
        }catch(SQLException err){
            Log.w(TAG, " Error: " + err.toString());
        }
    }

    @Override
    public void onBackPressed ()
    {
        Log.i(TAG, " BackButton Pressed.");
        super.onBackPressed();
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i(TAG, "On Start.");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(TAG, "On Pause.");
    }


    @Override
    public void onResume(){
        super.onResume();
        Log.i(TAG, "On Resume.");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i(TAG, "On Stop.");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "On Destroy.");
    }




}
