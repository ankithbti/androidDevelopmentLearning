package com.example.ankithbti.testme;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
//import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by ankithbti on 11/04/16.
 */
public class Base_Activity extends ActionBarActivity {

    static int NUM = 100;
    private final String TAG = "Ankit - Base Activity";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.i(TAG, " Item clicked - " + id);

        switch(id){
            case R.id.twitter:
                Log.i(TAG, " Twitter clicked. ");
                return true;
            case R.id.facebook:
                Log.i(TAG, " Facebook clicked. ");
                return true;
            case R.id.back:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.myinfo:
                Intent intent1 = new Intent(getApplicationContext(), NewActivity.class);
                intent1.putExtra("myname", "Ankit Gupta");
                intent1.putExtra("myage", "31");
                intent1.putExtra("mydob", "09/07/1986");
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
