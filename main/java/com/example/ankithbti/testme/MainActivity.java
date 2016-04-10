package com.example.ankithbti.testme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {


    static int NUM = 100;
    private final String TAG = "Ankit - Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, " On Create.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button  hitMeBtn = (Button)findViewById(R.id.btn1);
        hitMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CharSequence text = "Hello There!!";
                int duration = Toast.LENGTH_SHORT;
                Toast msg = Toast.makeText(getApplicationContext(), text, duration);
                msg.show();
                Log.i(TAG, " Button Clicked.");



            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // Call new Activity
            Intent intent = new Intent(getApplicationContext(), NewActivity.class);
            intent.putExtra("myname", "Ankit Gupta");
            intent.putExtra("myage", "31");
            intent.putExtra("mydob", "09/07/1986");
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
