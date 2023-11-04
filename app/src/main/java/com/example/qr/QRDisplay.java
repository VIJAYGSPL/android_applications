package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.graphics.Bitmap;

public class QRDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrdisplay);

        ImageView i1 = findViewById(R.id.imageView11);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        i1.setImageBitmap((Bitmap) bundle.get("qrcode"));
    }
}