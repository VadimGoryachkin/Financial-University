package com.nikita.fatigueindicator;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Spinner date, month, year, sex;
    String[] dates = new String[31], months = new String[12],
            years = new String[52], sexs = new String[] {"муж", "жен"};
    Button btnDone;

    EditText etDown, etUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etDown = findViewById(R.id.etDown);
        etUp = findViewById(R.id.etUp);
        date = findViewById(R.id.sDate);
        month = findViewById(R.id.sMonth);
        year = findViewById(R.id.sYear);
        sex = findViewById(R.id.sSex);
        btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);

        for (int i = 0; i<=30; i++){
            dates[i] = String.valueOf(i + 1);
        }
        for (int i = 0; i<=11; i++){
            months[i] = String.valueOf(i + 1);
        }
        for (int i = 0; i<=51; i++){
            years[i] = String.valueOf(i + 1970);
        }


        ArrayAdapter<String> dateAdapter = new ArrayAdapter <String>(this,
                R.layout.my_spinner_item,
                dates);
        date.setAdapter(dateAdapter);

        ArrayAdapter<String> monthAdapter = new ArrayAdapter <String>(this,
                R.layout.my_spinner_item,
                months);
        month.setAdapter(monthAdapter);

        ArrayAdapter<String> yearAdapter = new ArrayAdapter <String>(this,
                R.layout.my_spinner_item,
                years);
        year.setAdapter(yearAdapter);

        ArrayAdapter<String> sexAdapter = new ArrayAdapter <String>(this,
                R.layout.my_spinner_item,
                sexs);
        sex.setAdapter(sexAdapter);
    }

    @Override
    public void onClick(View view) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int fatigue = -1;
                String day = date.getSelectedItem().toString();
                String mon = month.getSelectedItem().toString();
                String yearr = year.getSelectedItem().toString();
                String sexx = sex.getSelectedItem().toString();
                if (sexx == "муж"){
                    sexx = "1";
                } else {
                    sexx = "2";
                }
                String m1 = etDown.getText().toString();
                String m2 = etUp.getText().toString();
                String[] params = new String[] {day, mon, yearr, sexx, m1, m2};
                try  {
                    fatigue = sendPost(params);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent results = new Intent("com.nikita.fatigueindicator.action.results");
                results.putExtra("indicator", fatigue);
                startActivity(results);

            }
        });
        thread.start();
    }
    private int sendPost(String[] params) throws Exception {

        String url = "http://abashin.ru/cgi-bin/ru/tests/burnout";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "day="+params[0]+"&month="+params[1]+"&year="+params[2] +
                "&sex="+params[3]+"&m1="+params[4]+"&m2="+params[5];

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String strResponse = response.toString();

        // Распечатываем результат
        int retValue = -1;
        if (strResponse.contains("отсутствию переутомления")) {
            retValue = (int) (Math.random() * (100-66) +67);
        } else if (strResponse.contains("небольшому переутомлению")) {
            retValue = (int) (Math.random() * (67-33) +34);
        } else if (strResponse.contains("высокому уровню переутомления")) {
            retValue = (int) (Math.random() * 34);
        } else {}
        System.out.println(response.toString());
        return retValue;

    }
}