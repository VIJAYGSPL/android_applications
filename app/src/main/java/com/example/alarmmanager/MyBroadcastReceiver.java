package com.example.alarmmanager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        mp=MediaPlayer.create(context,Settings.System.DEFAULT_ALARM_ALERT_URI);
//        player = MediaPlayer.create( this, Settings.System.DEFAULT_RINGTONE_URI );
        mp.start();
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();



    }

}

