package com.nikita.tictactoe;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView[][] iv = new ImageView[3][3];
    Integer[][] field = new Integer[3][3];
    Integer whoseTurn = 1;
    TextView tvMove;
    Button btnRestart;

    protected void clear_field() {
        tvMove.setText("Ход крестика");
        whoseTurn = 1;
        for (int i = 0; i <= 2; i++)
            for (int j = 0; j<=2; j++) {
                field[i][j] = 0;
                iv[i][j].setImageDrawable(null);
                iv[i][j].setOnClickListener(this);
            }
    }

    protected Boolean set_value(ImageView iview) {
        for (int i = 0; i <= 2; i++)
            for (int j = 0; j<=2; j++) {
                if (iview == iv[i][j])
                    if (field[i][j] == 0) {
                        field[i][j] = whoseTurn;
                        return Boolean.TRUE;
                    } else {
                        return Boolean.FALSE;
                    }
            }
        return null;
    }

    protected Boolean gameOver(){
        if (((field[0][0] == field[1][1] && field[1][1] == field[2][2]) ||
                (field[0][2] == field[1][1] && field[1][1] == field[2][0])) && field[1][1] != 0) {
            return Boolean.TRUE;
        } else {
            for (int i = 0; i <= 2; i++){
                if (((field[i][0] == field[i][1] && field[i][1] == field[i][2]) ||
                        (field[0][i] == field[1][i] && field[1][i] == field[2][i])) && field[i][i] != 0)
                    return Boolean.TRUE;
            }
        }
        for (int i = 0; i <= 2; i++){
            for (int j = 0; j<=2; j++) {
                if (field[i][j] == 0) {
                    return Boolean.FALSE;
                }
            }
        }
        tvMove.setText("Ничья!");
        whoseTurn = 0;
        return Boolean.FALSE;
    }

    private void saveInstanceState() {
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = pref.edit();

        for (int i = 0; i <= 2; i++){
            for (int j = 0; j<=2; j++) {
                String s1 = Integer.toString(i);
                String s2 = Integer.toString(j);
                ed.putInt("field"+s1+s2, field[i][j]);
            }
        }
        ed.putString("tvMove", tvMove.getText().toString());
        ed.putInt("whoseTurn", whoseTurn);
        ed.commit();
    }

    private void readInstanceState() {
        SharedPreferences pref = getPreferences(MODE_PRIVATE);

        for (int i = 0; i <= 2; i++){
            for (int j = 0; j<=2; j++) {
                String s1 = Integer.toString(i);
                String s2 = Integer.toString(j);
                Integer fldVal = pref.getInt("field"+s1+s2, 0);
                field[i][j] = fldVal;
            }
        }
        String tvmv = pref.getString("tvMove", "Ход крестика");
        tvMove.setText(tvmv);
        whoseTurn = pref.getInt("whoseTurn", 1);


    }

    private void load_field() {
        for (int i = 0; i <= 2; i++){
            for (int j = 0; j<=2; j++) {
                switch (field[i][j]) {
                    case 1:
                        iv[i][j].setImageResource(R.mipmap.krest_foreground);
                        break;
                    case -1:
                        iv[i][j].setImageResource(R.mipmap.nolik_foreground);
                        break;
                    default:
                        iv[i][j].setImageDrawable(null);
                        break;
                }
                iv[i][j].setOnClickListener(this);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv[0][0] = findViewById(R.id.iv11);
        iv[0][1] = findViewById(R.id.iv12);
        iv[0][2] = findViewById(R.id.iv13);
        iv[1][0] = findViewById(R.id.iv21);
        iv[1][1] = findViewById(R.id.iv22);
        iv[1][2] = findViewById(R.id.iv23);
        iv[2][0] = findViewById(R.id.iv31);
        iv[2][1] = findViewById(R.id.iv32);
        iv[2][2] = findViewById(R.id.iv33);
        tvMove = findViewById(R.id.tvMove);
        btnRestart = findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(this);
        readInstanceState();
        load_field();


//        imageView.setImageDrawable(null)
//        setImageResource(int resId)
//        tools:srcCompat="@mipmap/krest_foreground"
//        app:srcCompat="@mipmap/nolik_foreground"
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRestart:
                clear_field();
                break;
            default:
                if (set_value((ImageView) view)) {
                    switch (whoseTurn) {
                        case 1:
                            ((ImageView) view).setImageResource(R.mipmap.krest_foreground);
                            tvMove.setText("Ход нолика");
                            break;
                        case -1:
                            ((ImageView) view).setImageResource(R.mipmap.nolik_foreground);
                            tvMove.setText("Ход крестика");
                            break;
                    }
                    whoseTurn *= -1;

                    if (gameOver()){
                        switch (whoseTurn) {
                            case 1:
                                tvMove.setText("В этой игре победу одержал нолик!");
                                break;
                            case -1:
                                tvMove.setText("В этой игре победу одержал крестик!");
                                break;
                            default:
                                break;
                        }
                        whoseTurn = 0;
                    }
                }

                break;
        }
    }

    @Override
    public void onPause() {
        saveInstanceState();
        super.onPause();
    }
}