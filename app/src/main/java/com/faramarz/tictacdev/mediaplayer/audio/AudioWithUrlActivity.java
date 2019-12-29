package com.faramarz.tictacdev.mediaplayer.audio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.faramarz.tictacdev.mediaplayer.R;

import java.io.IOException;

public class AudioWithUrlActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPlayUrl, btnPauseUrl;
    MediaPlayer mediaPlayer;
    private static final String URL = "https://file-examples.com/wp-content/uploads/2017/11/file_example_MP3_1MG.mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_with_url);
        bind();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnPlayUrl:
                initPlayer();
                mediaPlayer.start();
                break;

            case R.id.btnPauseUrl:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
                break;
        }
    }

    private void bind() {
        btnPlayUrl = findViewById(R.id.btnPlayUrl);
        btnPauseUrl = findViewById(R.id.btnPauseUrl);
        btnPlayUrl.setOnClickListener(this);
        btnPauseUrl.setOnClickListener(this);

    }

    private void initPlayer() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(URL);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

