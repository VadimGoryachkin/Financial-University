package com.nikita.datastorage;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{


    Button btnSave, btnLoad, btnImage;
    EditText etName, etDate;
    Spinner spGroup;
    SeekBar sbAge;
    TextView tvAge;
    ImageButton ibDecrease, ibIncrease;
    ImageView ivPicture;
    ArrayList<String> groups = new ArrayList<String>();
    String[] groupNames = new String[] {"ПИ", "ПМ", "ИБ", "БИ"};

    private void savePicture(ImageView iv, String folderToSave, int id)
    {
        OutputStream fOut;

        try {
            File file = new File(folderToSave, "my_image.jpg");

            fOut = new FileOutputStream(file);
            Bitmap bitmap = (Bitmap) ((BitmapDrawable) iv.getDrawable()).getBitmap();
            bitmap.compress(Bitmap.CompressFormat.JPEG, id, fOut);
            fOut.flush();
            fOut.close();

//            MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(),  file.getName());
        }
        catch (Exception e){

        }

    }

    private void setInstanceState() {
        int age,group;
        String name, date;
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = pref.edit();
        name = etName.getText().toString();
        group =  spGroup.getSelectedItemPosition();
        age = sbAge.getProgress();
        date = etDate.getText().toString();

        ed.putString("your name", name);
        ed.putInt("your group", group);
        ed.putInt("your age", age);
        ed.putString("date of born", date);

        ed.commit();


        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
        savePicture(ivPicture, path, 100);
    }

    private void getInstanceState() {
        int age,group;
        String name, date;
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        name = pref.getString("your name", "Vadim");
        Log.i("SPREF", name);
        group = pref.getInt("your group", 16);
        Log.i("SPREF", Integer.toString(group));
        age = pref.getInt("your age", 19);
        Log.i("SPREF", Integer.toString(age));
        date = pref.getString("date of born", "03.12.2002");
        Log.i("SPREF", date);

        etName.setText(name);
        spGroup.setSelection( group);
        sbAge.setProgress(age);
        etDate.setText(date);


        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + "/my_image.jpg";
        File imgFile = new File(path);
        if(imgFile.exists())
        {
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            ImageView imageView=(ImageView)findViewById(R.id.ivPicture);
            imageView.setImageBitmap(myBitmap);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (String gr: groupNames)
            for (int i = 18; i<=21; i++)
                for (int j = 1; j<=6; j++)
                    groups.add(gr + Integer.toString(i) + "-" + Integer.toString(j));
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        etName = findViewById(R.id.etName);
        etDate = findViewById(R.id.etDate);
        spGroup = findViewById(R.id.spGroup);
        tvAge = findViewById(R.id.tvAge);
        sbAge = findViewById(R.id.sbAge);
        ibDecrease = findViewById(R.id.ibDecrease);
        ibIncrease = findViewById(R.id.ibIncrease);
        ivPicture = findViewById(R.id.ivPicture);
        btnImage = findViewById(R.id.btnImage);


        tvAge.setText("Ваш возраст: " + String.valueOf(sbAge.getProgress()));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                groups);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGroup.setAdapter(adapter);

        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);
        btnImage.setOnClickListener(this);
        ibDecrease.setOnClickListener(this);
        ibIncrease.setOnClickListener(this);
        sbAge.setOnSeekBarChangeListener(this);

        getInstanceState();
    }



    @Override
    public void onClick(View v) {



        switch (v.getId()){
            case R.id.btnSave:
                setInstanceState();
                break;
            case R.id.btnLoad:
                getInstanceState();
                break;
            case R.id.btnImage:
                Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try{
                    startActivityForResult(takePhotoIntent, 1);
                }catch (ActivityNotFoundException e){
                    e.printStackTrace();
                };
                break;
            case R.id.ibDecrease:
                sbAge.incrementProgressBy(-1);
                break;
            case R.id.ibIncrease:
                sbAge.incrementProgressBy(1);
                break;
            default:
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        tvAge.setText("Ваш возраст: " + String.valueOf(sbAge.getProgress()));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    protected void onPause()
    {
        setInstanceState();
        super.onPause();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap thumbnailBitmap = (Bitmap) extras.get("data");
            ivPicture.setImageBitmap(thumbnailBitmap);
        }
    }
}