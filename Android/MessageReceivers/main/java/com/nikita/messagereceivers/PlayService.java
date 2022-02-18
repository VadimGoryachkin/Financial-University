package com.nikita.messagereceivers;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayService extends Service {
    private Integer currentTrack;
    private MediaPlayer mPlayer;
    private String[] playlist = new String[] {"composition", "track2", "track3"};

    public void make_toast(Context context, String message) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.toast_layout,
                null);
        ImageView image = (ImageView) layout.findViewById(R.id.image);
        image.setImageResource(R.mipmap.toast_image);
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(message);

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        make_toast(getApplicationContext(), "Служба создана");


    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        currentTrack = intent.getIntExtra("id_", 0);
        Integer res = getResources().getIdentifier(playlist[currentTrack],"raw",getPackageName());
        mPlayer = MediaPlayer.create(this, res);
        mPlayer.setLooping(false);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                currentTrack = (currentTrack+1)%3;
//                String filename = "android.resource://" + PlayService.this.getPackageName() + "/raw/"+playlist[currentTrack]+".mp3";
                Integer res = getResources().getIdentifier(playlist[currentTrack],"raw",getPackageName());
                mediaPlayer = MediaPlayer.create(PlayService.this, res);
                mediaPlayer.start();

            }
        });
        make_toast(getApplicationContext(), "Служба запущена");

//        Toast.makeText(this, "Служба запущена",
//                Toast.LENGTH_SHORT).show();
        mPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        make_toast(getApplicationContext(), "Служба остановлена");
//        Toast.makeText(this, "Служба остановлена",
//                Toast.LENGTH_SHORT).show();
        mPlayer.stop();
    }
}
