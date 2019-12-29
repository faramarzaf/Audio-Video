package com.faramarz.tictacdev.mediaplayer.video;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.faramarz.tictacdev.mediaplayer.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class VideoActivity extends AppCompatActivity {

    VideoView myVideo;
    String url = "https://hw16.cdn.asset.aparat.com/aparat-video/cdc7c0ac2c50e5fd2080688629d4496e13372275-144p__68086.mp4";
    BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        getPermission();
        myVideo = findViewById(R.id.myVideo);
        myVideo.setVideoURI(Uri.parse(url));
        myVideo.start();
        myVideo.setMediaController(new MediaController(this));
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (myVideo.isPlaying())
                    myVideo.pause();
            }
        };

        IntentFilter filter = new IntentFilter("android.intent.action.PHONE_STATE");
        registerReceiver(receiver, filter);
    }


    void getPermission() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.READ_PHONE_STATE
                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

            }
        }).check();
    }

}
