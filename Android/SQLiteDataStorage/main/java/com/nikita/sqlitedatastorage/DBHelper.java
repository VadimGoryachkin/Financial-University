package com.nikita.sqlitedatastorage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper{

    public DBHelper(Context context) {
        super(context, "MyDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table mytable ("
                + "id integer primary key autoincrement,"
                + "todo text not null,"
                + "date text not null,"
                + "time text not null,"
                + "category text"
                + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<String[]> getValues() {

        ArrayList<String[]> val = new ArrayList<String[]>();
        SQLiteDatabase db = getWritableDatabase();

//        db.execSQL("Drop table mytable");
//        db.execSQL("create table mytable ("
//                + "id integer primary key autoincrement,"
//                + "todo text not null,"
//                + "date text not null,"
//                + "time text not null,"
//                + "category text"
//                + ");");
        Cursor c = db.query("mytable", null, null, null, null, null, null);

        if (c.moveToFirst()) {
            Integer[] row = new Integer[5];

            row[0] = c.getColumnIndex("id");
            row[1]= c.getColumnIndex("todo");
            row[2] = c.getColumnIndex("date");
            row[3] = c.getColumnIndex("time");
            row[4] = c.getColumnIndex("category");
            do {
                String[] rowStr = new String[5];
                rowStr[0] = Integer.toString(c.getInt(row[0]));
                rowStr[1] = c.getString(row[1]);
                rowStr[2] = c.getString(row[2]);
                rowStr[3] = c.getString(row[3]);
                rowStr[4] = c.getString(row[4]);
                val.add(rowStr);
            } while (c.moveToNext());
        } else
            Log.d("LOG_TAG", "0 rows");
        c.close();
        db.close();
        return val;
    }
}
