package com.ahiralabata.ahirafiledir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button internal, external;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        internal = findViewById(R.id.btnInternal);
        external = findViewById(R.id.btnExternal);

        internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(MainActivity.this, InternalStorageActivity.class);
                startActivity(inten);
            }
        });

        external.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(MainActivity.this, ExternalStorageActivity.class);
                startActivity(inten);
            }
        });
    }
}