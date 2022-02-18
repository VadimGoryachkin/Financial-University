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


public class MainActivity3 extends AppCompatActivity implements View.OnClickListener{
    Button btn31, btn32, btn34;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn31 = findViewById(R.id.btn31);
        btn32 = findViewById(R.id.btn32);
        btn34 = findViewById(R.id.btn34);
        btn31.setOnClickListener(this);
        btn32.setOnClickListener(this);
        btn34.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn31:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn32:
                Intent intent2 = new Intent(this, MainActivity2.class);
                startActivity(intent2);
                break;
            case R.id.btn34:
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
}
