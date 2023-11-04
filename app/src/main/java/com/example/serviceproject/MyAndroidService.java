package com.example.serviceproject;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyAndroidService extends Service {

    // declaring object of MediaPlayer
    private MediaPlayer player;

    @Override

    // execution of service will start
    // on calling this method
    public int onStartCommand(Intent intent, int flags, int startId) {

        // creating a media player which
        // will play the audio from our external storage or Default
        // ringtone in android device
//        or from storage song want play then this is path for flow data code which shown below
        Log.e("Path = ",""+Environment.getExternalStorageDirectory().getPath());
       player = MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/VidMate/Vasanth.mp3"));

        //this below code for default ringtone in  our android device play ringtone
//        player = MediaPlayer.create( this, Settings.System.DEFAULT_RINGTONE_URI );

// providing the boolean
        // value as true to play
        // the audio on loop
        player.setLooping(false);

        // starting the process
        player.start();

        // returns the status
        // of the program
        return START_STICKY;
    }

    @Override

    // execution of the service will
    // stop on calling this method
    public void onDestroy() {
        super.onDestroy();

        // stopping the process
        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}



