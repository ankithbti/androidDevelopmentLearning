package com.example.ankithbti.testme;


import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends Base_Activity {


    static int NUM = 100;
    private final String TAG = "Ankit - Main Activity";
    Fragment sideFrag = new SideFragment();
    Fragment picFrag = new PicFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, " On Create.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        //setContentView(R.layout.new_frame_activity);

        // For adding fragment
        FragmentManager fragMgr = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragMgr.beginTransaction();
//
//        // Replace the frame
        fragTrans.replace(R.id.fragFrame, sideFrag, "SIDE");
//
        fragTrans.addToBackStack(null);
        fragTrans.commit();

//        final Button  hitMeBtn = (Button)findViewById(R.id.btn1);
//        hitMeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                CharSequence text = "Hello There!!";
//                int duration = Toast.LENGTH_SHORT;
//                Toast msg = Toast.makeText(getApplicationContext(), text, duration);
//                msg.show();
//                Log.i(TAG, " Button Clicked.");
//            }
//        });
    }

    public void swapFrag(View v){
        // For adding fragment
        FragmentManager fragMgr = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragMgr.beginTransaction();

        Fragment curr = fragMgr.findFragmentByTag("SIDE");
        if(curr.isVisible()){
            fragTrans.replace(R.id.fragFrame, picFrag, "PIC");
        }else{
            fragTrans.replace(R.id.fragFrame, sideFrag, "SIDE");
        }

        fragTrans.addToBackStack(null);
        fragTrans.commit();
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
