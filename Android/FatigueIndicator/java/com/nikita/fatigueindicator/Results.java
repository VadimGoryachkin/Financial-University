package com.nikita.fatigueindicator;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Results extends AppCompatActivity {
    ProgressBar pBar;
    ImageView ivIndicator;
    TextView tvIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        pBar = findViewById(R.id.pBar);
        ivIndicator = findViewById(R.id.ivIndicator);
        tvIndicator = findViewById(R.id.tvIndicator);
        int indicator = getIntent().getIntExtra("indicator",0);
        pBar.setProgress(indicator);
        if (indicator > 100*2/3) {
            tvIndicator.setText(R.string.good);
            ivIndicator.setImageResource(R.mipmap.goodvibes_foreground);

        } else if (indicator > 100/3) {
            tvIndicator.setText(R.string.medium);
            ivIndicator.setImageResource(R.mipmap.okvibes_foreground);
        } else if (indicator >=0) {
            tvIndicator.setText(R.string.bad);
            ivIndicator.setImageResource(R.mipmap.badvibes_foreground);
        } else{
            tvIndicator.setText(R.string.error);
            ivIndicator.setImageResource(R.mipmap.errorim_foreground);
        }

    }
}