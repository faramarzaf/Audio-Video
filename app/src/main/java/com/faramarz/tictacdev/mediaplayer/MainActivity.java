package com.faramarz.tictacdev.mediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.faramarz.tictacdev.mediaplayer.audio.AudioActivity;
import com.faramarz.tictacdev.mediaplayer.audio.AudioWithServiceActivity;
import com.faramarz.tictacdev.mediaplayer.audio.AudioWithUrlActivity;
import com.faramarz.tictacdev.mediaplayer.video.VideoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAudioPage, btnVideoPage, btnAudioPageUrl, btnAudioService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();
        clickEvents();
    }

    private void bind() {
        btnAudioPage = findViewById(R.id.btnAudioPage);
        btnVideoPage = findViewById(R.id.btnVideoPage);
        btnAudioPageUrl = findViewById(R.id.btnAudioPageUrl);
        btnAudioService = findViewById(R.id.btnAudioService);
    }

    private void clickEvents() {
        btnAudioPage.setOnClickListener(this);
        btnVideoPage.setOnClickListener(this);
        btnAudioPageUrl.setOnClickListener(this);
        btnAudioService.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnAudioPage:
                startActivity(new Intent(this, AudioActivity.class));
                break;

            case R.id.btnVideoPage:
                startActivity(new Intent(this, VideoActivity.class));
                break;

            case R.id.btnAudioPageUrl:
                startActivity(new Intent(this, AudioWithUrlActivity.class));
                break;

            case R.id.btnAudioService:
                startActivity(new Intent(this, AudioWithServiceActivity.class));
                break;
        }

    }

}
