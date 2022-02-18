package com.nikita.sqlitedatastorage;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnAdd, btnDelete, btnRead;
    TextView tvDate, tvTime;
    EditText etName;
    DBHelper dbHelper;
    Spinner spCategory;
    Calendar dateAndTime=Calendar.getInstance();


    final String[] category = new String[] {"", "Домашние", "Служебные", "Специальные"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnRead = findViewById(R.id.btnRead);
        etName = findViewById(R.id.etName);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        spCategory= findViewById(R.id.spCategory);

        dbHelper = new DBHelper(this);

        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        tvDate.setOnClickListener(this);
        tvTime.setOnClickListener(this);



        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,
                        R.layout.spinner_layout,R.id.weekofday, category);
        spCategory.setAdapter(adapter);

        setInitialTime();
        setInitialDate();




    }





    private void insertValues() {
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String todo = etName.getText().toString();
        String date = tvDate.getText().toString().substring(6);
        String time = tvTime.getText().toString().substring(7);
        String category = spCategory.getSelectedItem().toString();
        if (!todo.isEmpty()) {
            if (category.isEmpty()) {
                category = null;
            }
            ContentValues cv = new ContentValues();
            cv.put("todo", todo);
            cv.put("date", date);
            cv.put("time", time);
            cv.put("category", category);

            getContentResolver().insert(DatabaseProvider.CONTENT_URI, cv);

//            db.insert("mytable", null, cv);
        }
//        db.close();


    }

    private void deleteValues() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("mytable", null, null);
    }


    private void readValues(){

        ArrayList<String[]> val = dbHelper.getValues();
        for (int i = 0; i < val.size(); i++)
            Log.d("LOG_TAG",
                "ID = " + val.get(i)[0] +
                        ", todo = " + val.get(i)[1] +
                        ", date = " + val.get(i)[2] +
                        ", time = " + val.get(i)[3] +
                        ", category = " + val.get(i)[4]);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnAdd:
                insertValues();
                break;
            case R.id.btnDelete:
                deleteValues();
                break;
            case R.id.btnRead:
                readValues();
                break;
            case R.id.tvDate:
                setDate(v);
                break;
            case R.id.tvTime:
                setTime(v);
                break;
            default:
                break;
        }
    }


    // отображаем диалоговое окно для выбора даты
    public void setDate(View v) {
        new DatePickerDialog(MainActivity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    // отображаем диалоговое окно для выбора времени
    public void setTime(View v) {
        new TimePickerDialog(MainActivity.this, t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }
    // установка начальных даты и времени
    private void setInitialDate() {

        tvDate.setText("Дата: " +
                DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
    }
    private void setInitialTime() {

        tvTime.setText("Время: " +
                DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(), DateUtils.FORMAT_SHOW_TIME));
//
    }

    // установка обработчика выбора времени
    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialTime();
        }
    };


    // установка обработчика выбора даты
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDate();
        }
    };

//    https://metanit.com/java/android/18.1.php
}