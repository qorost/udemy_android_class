package com.qoros.videodemo;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class AudioActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private SeekBar mVolumeControlSeekBar;
    private AudioManager audioManager;

    public void playAudio(View view){
        Log.i("Audio","Clicked PlayAudio");
        mPlayer.start();
    }

    public void pauseAudio(View view){
        Log.i("Audio","Clicked PauseAudio");
        mPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        mPlayer = MediaPlayer.create(this,R.raw.laugh);
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);//E/MediaPlayer: Should have subtitle controller already set

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        mVolumeControlSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mVolumeControlSeekBar.setMax(maxVolume);
        mVolumeControlSeekBar.setProgress(curVolume);

        mVolumeControlSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Log.i("SeekBar",Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button startButton = (Button) findViewById(R.id.btn_play);
        Button pauseButton = (Button) findViewById(R.id.btn_pause);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAudio(view);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseAudio(view);
            }
        });
    }
}
