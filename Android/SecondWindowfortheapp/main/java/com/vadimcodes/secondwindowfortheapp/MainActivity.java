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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final String TAG = "States";
    Button btn12, btn13, btn14, button;
    EditText etName;

    View.OnClickListener send_name = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("name", etName.getText().toString());
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn12 = findViewById(R.id.btn12);
        btn13 = findViewById(R.id.btn13);
        btn14 = findViewById(R.id.btn14);
        button = findViewById(R.id.button);
        etName = findViewById(R.id.editText);

        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        button.setOnClickListener(send_name);


        Log.d(TAG, "MainActivity: onCreate()");
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn12:
                Intent intent1 = new Intent(this, MainActivity2.class);
                startActivity(intent1);
                break;
            case R.id.btn13:
                Intent intent2 = new Intent(this, MainActivity3.class);
                startActivity(intent2);
                break;
            case R.id.btn14:
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
        Log.d(TAG, "MainActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity: onRestart()");
    }


}
