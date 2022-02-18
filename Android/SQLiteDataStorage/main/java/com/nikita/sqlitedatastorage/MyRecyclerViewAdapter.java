package com.nikita.sqlitedatastorage;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String[]> mData;
    private LayoutInflater mInflater;

    // Передача данных в конструктор
    MyRecyclerViewAdapter(Context context, ArrayList<String[]> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // Формирует макет строки из xml, когда это необходимо
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // Привязывает данные к TextView в каждой строке
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String[] rows = mData.get(position);
        holder.idDB.setText(rows[0]);
        holder.todoDB.setText(rows[1]);
        holder.dateDB.setText(rows[2]);
        holder.timeDB.setText(rows[3]);
        holder.categoryDB.setText(rows[4]);
    }

    // Общее количество строк
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // Сохраняет и перерабатывает изображения при их прокрутке за пределы экрана
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView idDB,todoDB,dateDB,timeDB,categoryDB;

        ViewHolder(View itemView) {
            super(itemView);
            idDB = itemView.findViewById(R.id.idDB);
            todoDB = itemView.findViewById(R.id.todoDB);
            dateDB = itemView.findViewById(R.id.dateDB);
            timeDB = itemView.findViewById(R.id.timeDB);
            categoryDB = itemView.findViewById(R.id.categoryDB);
        }

    }



}
