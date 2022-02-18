package com.nikita.messagereceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MessageReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {


        Toast.makeText(context, "Обнаружено сообщение: " +
                        intent.getStringExtra("com.nikita.messagereceivers.broadcast.Message"),
                Toast.LENGTH_LONG).show();
    }

}