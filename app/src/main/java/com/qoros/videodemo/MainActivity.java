package com.qoros.videodemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private Button audiobtn, videobtn,gridbtn,listviewbtn,timerbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audiobtn = (Button) findViewById(R.id.audioButton);
        videobtn = (Button) findViewById(R.id.videoButton);
        gridbtn = (Button) findViewById(R.id.gridButton);
        listviewbtn = (Button) findViewById(R.id.listviewButton);
        timerbtn = (Button) findViewById(R.id.timerButton);

        audiobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAudioDemo(view);
            }
        });

        videobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startVideoDemo(view);
            }
        });

        gridbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGridDemo(view);
            }
        });

        listviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startListViewDemo(view);
            }
        });

        timerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimeDemo(view);
            }
        });

//

    }
    public void startGridDemo(View view){
        Intent intent = new Intent(this,GridDemoActivity.class);
        startActivity(intent);
    }

    public void startAudioDemo(View view){
        Intent intent = new Intent(this,AudioActivity.class);
        startActivity(intent);

    }

    public void startVideoDemo(View view){
        Intent intent = new Intent(this,VideoActivity.class);
        startActivity(intent);
    }

    public void startListViewDemo(View view){
        Intent intent = new Intent(this,ListViewActivity.class);
        startActivity(intent);
    }

    public void startTimeDemo(View view){
        Intent intent = new Intent(this,TimerActivity.class);
        startActivity(intent);
    }

    public void startJsonDemo(View view){
        Intent intent = new Intent(this,JSONActivity.class);
        startActivity(intent);
    }

    public void startMapsDemo(View view){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }


    protected void onResume(){
        super.onResume();

    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onStop(){
        super.onStop();
    }
}
