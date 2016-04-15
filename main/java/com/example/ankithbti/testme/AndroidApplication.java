package com.example.ankithbti.testme;

import android.app.Application;
import android.os.Bundle;
import android.widget.Toast;
import android.util.Log;

/**
 * Created by ankithbti on 15/04/16.
 */
public class AndroidApplication extends Application {

    public static final String TAG = " Ankit - Application ";
    @Override
    public void onCreate(){
        super.onCreate();
        Log.i(TAG, " Android Application created. ");
        Toast.makeText(getApplicationContext(), "Application onCreate", Toast.LENGTH_LONG);
    }

}
