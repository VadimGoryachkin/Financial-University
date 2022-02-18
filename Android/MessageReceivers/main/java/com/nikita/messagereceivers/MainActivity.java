package com.nikita.messagereceivers;

import android.content.ComponentName;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] playlist = new String[] {"TRACK1", "TRACK2", "TRACK3"};
    ListView lvPlaylist;
    ArrayAdapter<String> adapter;

    public void start(int position) {
        Intent intent = new Intent(MainActivity.this, PlayService.class);
        MainActivity.this.stopService(intent);
        intent.putExtra("id_", position);
        MainActivity.this.startService(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnStart = findViewById(R.id.button_start);
        final Button btnStop = findViewById(R.id.button_stop);
        lvPlaylist = findViewById(R.id.playlist);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, playlist);
        lvPlaylist.setAdapter(adapter);
        lvPlaylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                start(position);
                }
            });


        // запуск службы
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // используем явный вызов службы
                start(0);
            }
        });

        // остановка службы
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.stopService(
                        new Intent(MainActivity.this, PlayService.class));
            }
        });
    }

    public static final String MY_MESSAGE_ACTION = "com.nikita.messagereceivers.action.MESSAGE";
    public static final String ALARM_MESSAGE = "А я что сам с собой разговариваю?";

    public void sendMessage(View view) {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName(this, MessageReceiver.class);
        intent.setAction(MY_MESSAGE_ACTION);
        intent.putExtra("com.nikita.messagereceivers.broadcast.Message", ALARM_MESSAGE);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.setComponent(componentName);
        sendBroadcast(intent);
    }
}