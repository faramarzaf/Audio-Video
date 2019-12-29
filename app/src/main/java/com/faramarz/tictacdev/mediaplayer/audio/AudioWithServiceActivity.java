package com.faramarz.tictacdev.mediaplayer.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.faramarz.tictacdev.mediaplayer.R;

import java.util.Timer;
import java.util.TimerTask;


public class AudioWithServiceActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPlay, btnPause;
    MediaPlayer mediaPlayer;
    SeekBar volumeBar, scrubBar;
    TextView tv;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_with_service);
        bind();
        initPlayer();
        initVolumeSeekBar();

        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        scrubBar.setMax(mediaPlayer.getDuration());
        scrubBar.setProgress(0);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 100);

        scrubBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (mediaPlayer != null && fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    private void bind() {
        btnPlay = findViewById(R.id.btn_play);
        btnPause = findViewById(R.id.btn_pause);
        volumeBar = findViewById(R.id.volumeBar);
        scrubBar = findViewById(R.id.scrubBar);
        tv = findViewById(R.id.tv);
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);

    }

    private void initPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.sound1);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    }

    private void initVolumeSeekBar() {
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        volumeBar.setMax(maxVolume);
        volumeBar.setProgress(curVolume);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.btn_play:
                mediaPlayer.start();
                break;

            case R.id.btn_pause:
                mediaPlayer.pause();
                break;

            default:
                break;
        }

    }


}
