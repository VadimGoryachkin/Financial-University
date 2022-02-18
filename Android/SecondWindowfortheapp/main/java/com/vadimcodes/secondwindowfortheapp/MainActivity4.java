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


public class MainActivity4 extends AppCompatActivity implements View.OnClickListener{
    Button btn41, btn42, btn43;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btn41 = findViewById(R.id.btn41);
        btn42 = findViewById(R.id.btn42);
        btn43 = findViewById(R.id.btn43);
        btn41.setOnClickListener(this);
        btn42.setOnClickListener(this);
        btn43.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn41:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn42:
                Intent intent2 = new Intent(this, MainActivity2.class);
                startActivity(intent2);
                break;
            case R.id.btn43:
                Intent intent3 = new Intent(this, MainActivity3.class);
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