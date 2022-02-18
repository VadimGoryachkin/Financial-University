package com.vadimcodes.basicelements;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener{
    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();
    Button ok_btn, cnc_btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = findViewById(R.id.main_textview);
        ok_btn = findViewById(R.id.ok_btn);
        cnc_btn = findViewById(R.id.cnc_btn);

        mainButton = findViewById(R.id.main_button);
        mainEditText = (EditText) findViewById(R.id.main_edittext);
        mainListView = findViewById(R.id.main_listview);

        mainTextView.setText("Set in Java!");
        mainButton.setOnClickListener(this);

        ok_btn.setOnClickListener(oclBtn);
        cnc_btn.setOnClickListener(oclBtn);

        mainListView.setOnItemClickListener(this);
        mainListView.setOnItemLongClickListener(this);
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);
        mainListView.setAdapter(mArrayAdapter);
    }

    @Override
    public void onClick(View v) {
        mainTextView.setText(mainEditText.getText().toString()
                + " is learning Android development!");
        mNameList.add(mainEditText.getText().toString());
        Set<String> set = new HashSet<>(mNameList);
        mNameList.clear();
        mNameList.addAll(set);
        Collections.sort(mNameList);
        mArrayAdapter.notifyDataSetChanged();
        mainEditText.getText().clear();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Log.d("omg android", position + ": " + mNameList.get(position));
        mainTextView.setText(mNameList.get(position).toString()
                + " is learning Android development!");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        String item_text = (String) mNameList.get(i);

        mNameList.remove(i);
        mArrayAdapter.notifyDataSetChanged();
        mainTextView.setText("Удален элемент " + item_text);
        Toast.makeText(getApplicationContext(), item_text + " удален", Toast.LENGTH_LONG).show();

        return false;
    }



    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // по id определеяем кнопку, вызвавшую этот обработчик
            switch (v.getId()) {
                case R.id.ok_btn:
                    // кнопка ОК
                    mainTextView.setText("Нажата кнопка ОК");
                    Toast.makeText(getApplicationContext(), "Нажата кнопка ОК", Toast.LENGTH_LONG).show();
                    break;
                case R.id.cnc_btn:
                    // кнопка Cancel
                    mainTextView.setText("Нажата кнопка Cancel");
                    Toast.makeText(getApplicationContext(), "Нажата кнопка CANCEL", Toast.LENGTH_LONG).show();
                    break;

//                mNameList.getCheckedItemPosition()
            }

        }
    };


}