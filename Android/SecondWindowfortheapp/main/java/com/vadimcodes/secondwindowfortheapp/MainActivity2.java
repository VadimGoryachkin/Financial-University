package com.vadimcodes.secondwindowfortheapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    final String TAG = "States";
    Button btn21, btn23, btn24;
    TextView tvGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn21 = findViewById(R.id.btn21);
        btn23 = findViewById(R.id.btn23);
        btn24 = findViewById(R.id.btn24);
        tvGet = findViewById(R.id.textView5);

        btn21.setOnClickListener(this);
        btn23.setOnClickListener(this);
        btn24.setOnClickListener(this);

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            String name = arguments.get("name").toString();
            tvGet.setText(name);
        }

        Log.d(TAG, "SecondActivity: onCreate()");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn21:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn23:
                Intent intent2 = new Intent(this, MainActivity3.class);
                startActivity(intent2);
                break;
            case R.id.btn24:
                Intent intent3 = new Intent(this, MainActivity4.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.act1:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.act2:
                Intent intent2 = new Intent(this, MainActivity2.class);
                startActivity(intent2);
                break;
            case R.id.act3:
                Intent intent3 = new Intent(this, MainActivity3.class);
                startActivity(intent3);
                break;
            case R.id.act4:
                Intent intent4 = new Intent(this, MainActivity4.class);
                startActivity(intent4);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SecondActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SecondActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SecondActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SecondActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "SecondActivity: onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "SecondActivity: onRestart()");
    }
}