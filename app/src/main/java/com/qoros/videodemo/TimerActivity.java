package com.qoros.videodemo;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private SeekBar timerseekbar;
    private TextView timerTextView;
    private boolean istarted = false;
    private Button btn_start;
    CountDownTimer countDownTimer = null;


    public void updateTimer(int secondsLeft){
        //if(istarted) return;
        int minutes = (int) secondsLeft/60;
        int seconds = secondsLeft - minutes*60;

        String secondString = Integer.toString(seconds);
        if(seconds <= 9){
            secondString = "0" + secondString;
        }

        timerTextView.setText(Integer.toString(minutes) + ':' +secondString);

    }

    public void controlTimer(View view){
        Log.i("Timer","Button Clicked");

        if(!istarted)
        {
            istarted = true;
            btn_start.setText("STOP");
            //btn_start.setEnabled(false);
            timerseekbar.setEnabled(false);
            countDownTimer = new CountDownTimer(timerseekbar.getProgress()*1000,1000){

                @Override
                public void onTick(long milisecondsTillEnd) {
                    Log.i("Timer","onTick");
                    updateTimer((int) milisecondsTillEnd/1000);
                }

                @Override
                public void onFinish() {
                    Log.i("Timer","Timer Finished");
                    timerTextView.setText("0:00");
                    MediaPlayer mPlayer = MediaPlayer.create(getApplicationContext(),R.raw.airhorn);//not this
                    mPlayer.start();
                    //btn_start.setEnabled(true);
                    timerseekbar.setEnabled(true);
                    istarted = false;
                }
            }.start();
        }
        else
        {
            timerTextView.setText("0:30");
            timerseekbar.setProgress(30);
            if(countDownTimer != null) countDownTimer.cancel();
            btn_start.setText("GO!");
            timerseekbar.setEnabled(true);
            istarted = false;
        }



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timerseekbar = (SeekBar) findViewById(R.id.timerSeekBar);
        btn_start = (Button) findViewById(R.id.timerStartButton);
        if(btn_start != null)   Log.i("Timer","btn_start set");

        timerseekbar.setMax(600);
        timerseekbar.setProgress(30);

        timerTextView = (TextView) findViewById(R.id.timertextView);

        timerseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controlTimer(view);
            }
        });

//        new CountDownTimer(10000,1000){
//            public void onTick(long millisecondsUntilDone){
//                //counter down every second
//                Log.i("Seconds left ",String.valueOf(millisecondsUntilDone/1000));
//            }
//
//            @Override
//            public void onFinish() {
//                Log.i("Timer","Counterdown Timer finished");
//
//            }
//
//        }.start();


//        final Handler handler = new Handler();
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//                Log.i("Runnalbe has run!","wait a second");
//                handler.postDelayed(this,1000);
//            }
//        };
//        handler.post(run);
    }
}
