package com.example.ankithbti.testme;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ankithbti on 10/04/16.
 */
public class NewActivity extends Activity{

    private final String TAG = "Ankit - New Activity";

    public String myName;
    public String myAge;
    public String myDob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, " On Create.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        myName = getIntent().getStringExtra("myname");
        myAge = getIntent().getStringExtra("myage");
        myDob = getIntent().getStringExtra("mydob");
    }

    public void saveData(View view){
        EditText name = (EditText)findViewById(R.id.nameField);
        name.setText(myName);
        EditText age = (EditText)findViewById(R.id.ageField);
        age.setText(myAge);
        EditText dob = (EditText)findViewById(R.id.dobField);
        dob.setText(myDob);

        Log.i(TAG, "Name: " + name.getText().toString() + " , Age: " + age.getText().toString() + " , DOB: " + dob.getText().toString());
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
