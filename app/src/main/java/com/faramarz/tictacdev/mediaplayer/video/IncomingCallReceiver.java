package com.faramarz.tictacdev.mediaplayer.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class IncomingCallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Incoming call", Toast.LENGTH_SHORT).show();
    }
}
