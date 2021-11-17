package com.vadimcodes.guessthenumber;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo, tvAttempts;
    EditText etInput;
    Button bControl, bDifficult;
    int guess_number, current_value, attempts, difficult = 10;
    boolean game_over = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView)findViewById(R.id.textView);
        etInput = (EditText)findViewById(R.id.editTextNumber);
        bControl = (Button)findViewById(R.id.button);
        bDifficult = (Button)findViewById(R.id.button3);
        tvAttempts = (TextView)findViewById(R.id.textView2);
        attempts = 0;
        guess_number = (int) (Math.random() * (10 * difficult + 1));
        tvAttempts.setText(getResources().getString(R.string.attempts) + attempts);
        tvInfo.setText(getResources().getString(R.string.try_to_guess) + 10 * difficult + ")");
    }
    public void onClick(View v) {
        if (game_over) {
            guess_number = (int) (Math.random() * (10 * difficult + 1));
            attempts = 0;
            game_over = false;
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess) + 10 * difficult + ")");
        } else {
            if (!etInput.getText().toString().isEmpty()) {
                current_value = Integer.parseInt(etInput.getText().toString());
                if ((0 <= current_value) && (10 * difficult >= current_value)) {
                    ++attempts;
                    if (current_value == guess_number) {
                        tvInfo.setText(getResources().getString(R.string.hit));
                        game_over = true;
                        bControl.setText(getResources().getString(R.string.play_more));
                        etInput.getText().clear();
                    } else {
                        if (current_value > guess_number) {
                            tvInfo.setText(getResources().getString(R.string.ahead));
                        } else {
                            tvInfo.setText(getResources().getString(R.string.behind));
                        }
                    }
                } else {
                    tvInfo.setText(getResources().getString(R.string.error));
                }
            } else {
                tvInfo.setText(getResources().getString(R.string.try_to_guess) + 10 * difficult + ")");
            }

        }
        tvAttempts.setText(getResources().getString(R.string.attempts) + attempts);
    }
    public void onExit(View v) {
        finish();
    }
    public void onDifficult(View v) {
        if (difficult == 10) {
            difficult = 100;
            bDifficult.setText(getResources().getString(R.string.hard));
        } else if (difficult == 100) {
            difficult = 1;
            bDifficult.setText(getResources().getString(R.string.the_lightest));
        } else {
            difficult = 10;
            bDifficult.setText(getResources().getString(R.string.medium));
        }
        tvInfo.setText(getResources().getString(R.string.try_to_guess) + 10 * difficult + ")");
        guess_number = (int) (Math.random() * (10 * difficult+1));
        attempts = 0;
        game_over = false;
        bControl.setText(getResources().getString(R.string.input_value));
        tvAttempts.setText(getResources().getString(R.string.attempts) + attempts);
        etInput.getText().clear();
    }
}
