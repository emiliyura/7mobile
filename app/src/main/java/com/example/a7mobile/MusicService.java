package com.example.a7mobile;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    private static final String TAG = "MusicService";
    private MediaPlayer mediaPlayer;


    @Override
    public void onCreate(){
        super.onCreate();
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.musicmusic);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100, 100);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            Log.d(TAG, "Музыка начала играть");
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            Log.d(TAG, "Mузфка остановлена и ресурсы освобождены");
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}