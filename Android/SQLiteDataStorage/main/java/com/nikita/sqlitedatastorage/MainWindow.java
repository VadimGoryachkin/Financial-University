package com.nikita.sqlitedatastorage;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainWindow extends AppCompatActivity implements View.OnClickListener{
    RecyclerView rvDB;
    ArrayList<String[]> valuesDB;
    MyRecyclerViewAdapter adapterRV;
    Button btnJump;
    MainActivity mainAct = new MainActivity();
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
        btnJump = findViewById(R.id.btnJump);
        btnJump.setOnClickListener(this);
        rvDB = findViewById(R.id.rvDB);
        dbHelper = new DBHelper(this);
        valuesDB = dbHelper.getValues();
        RecyclerView recyclerView = findViewById(R.id.rvDB);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterRV = new MyRecyclerViewAdapter(this, valuesDB);
        recyclerView.setAdapter(adapterRV);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent("com.nikita.sqlitedatastorage.action.addrow");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        valuesDB.clear();
        valuesDB.addAll(dbHelper.getValues());
        adapterRV.notifyDataSetChanged();
    }
//    valuesDB.clear();
//                valuesDB.addAll(getValues());
//                adapterRV.notifyDataSetChanged();
//
//                valuesDB.clear();
//                valuesDB.addAll(getValues());
//                adapterRV.notifyDataSetChanged();
}