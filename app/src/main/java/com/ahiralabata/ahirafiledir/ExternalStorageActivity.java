package com.ahiralabata.ahirafiledir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ExternalStorageActivity extends AppCompatActivity implements View.OnClickListener {
    Button buat, ubah, baca, hapus;
    TextView txtBaca;
    public static final String namaFile = "latihanExternal.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);

        buat = findViewById(R.id.btnBuat);
        ubah = findViewById(R.id.btnUbah);
        baca = findViewById(R.id.btnBaca);
        hapus = findViewById(R.id.btnHapus);
        txtBaca = findViewById(R.id.textBaca);

        buat.setOnClickListener(this);
        ubah.setOnClickListener(this);
        baca.setOnClickListener(this);
        hapus.setOnClickListener(this);
    }

    void buatFile(){
        String isiFile = "Nama Saya Ahira Labata";
        String state = Environment.getExternalStorageState();

        if (!Environment.MEDIA_MOUNTED.equals(state)){
            return;
        }

        File file = new File(Environment.getExternalStorageDirectory(), namaFile);
        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void ubahFile(){
        String isiFile = "Nama Saya Ahira Labata dan data ini telah dirubah";
        String state = Environment.getExternalStorageState();

        if (!Environment.MEDIA_MOUNTED.equals(state)){
            return;
        }

        File file = new File(Environment.getExternalStorageDirectory(), namaFile);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file);
            OutputStreamWriter out = new OutputStreamWriter(outputStream);
            out.write(isiFile);
            out.flush();
            out.close();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void bacaFile(){
        File sdcard = new File(Environment.getExternalStorageDirectory(), namaFile);
        if(sdcard.exists()){
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(sdcard));
                String line = br.readLine();
                while (line != null){
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e){
                System.out.println("Error" + e.getMessage());
            }
            txtBaca.setText(text.toString());
        }
    }

    void hapusFile(){
        File file = new File(Environment.getExternalStorageDirectory(), namaFile);
        if(file.exists()){
            file.delete();
        }
    }

    public void onClick(View v) { jalankanPerintah(v.getId()); }
    public void jalankanPerintah(int id){
        switch (id){
            case R.id.btnBuat:
                buatFile();
                break;
            case R.id.btnBaca:
                bacaFile();
                break;
            case R.id.btnUbah:
                ubahFile();
                break;
            case R.id.btnHapus:
                hapusFile();
                break;
        }
    }
}