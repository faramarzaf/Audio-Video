package com.faramarz.tictacdev.mediaplayer.audio;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.faramarz.tictacdev.mediaplayer.R;

public class AudioActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPlayAudio, btnPauseAudio;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        bind();
        mp = MediaPlayer.create(this, R.raw.sound1);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnPlayAudio:
                mp.start();
                break;

            case R.id.btnPauseAudio:
                mp.pause();
                break;

        }

    }

    private void bind() {
        btnPlayAudio = findViewById(R.id.btnPlayAudio);
        btnPauseAudio = findViewById(R.id.btnPauseAudio);
        btnPlayAudio.setOnClickListener(this);
        btnPauseAudio.setOnClickListener(this);

    }

}
