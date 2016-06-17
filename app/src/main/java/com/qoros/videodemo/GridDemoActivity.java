package com.qoros.videodemo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class GridDemoActivity extends AppCompatActivity {


    public void buttonTapped(View view){
        Log.i("but tapped","true");

        int id = view.getId();
        String ourId = "";
        ourId = view.getResources().getResourceEntryName(id);

        int resourceId = getResources().getIdentifier(ourId,"raw",getPackageName());

        MediaPlayer mplayer = MediaPlayer.create(this,resourceId);
        mplayer.start();

        switch(view.getId()){
            case R.id.hello:

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_demo);
    }
}
