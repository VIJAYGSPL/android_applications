package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.MultiFormatWriter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.Toast;
//import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {
    EditText edCname,edCnumber,edTdata,edScode;
    Button generate;
    boolean isAllFieldsChecked = false;

    // ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        edCname = findViewById(R.id.cname);
        edCnumber = findViewById(R.id.cnum);
        edTdata = findViewById(R.id.tdata);
        edScode = findViewById(R.id.seccode);
        generate = findViewById(R.id.btnGenerate);
        //imageView = findViewById(R.id.imageView);


        generate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                isAllFieldsChecked = CheckAllFields();

                QRCodeWriter qrCodeWriter = new QRCodeWriter();
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                if (isAllFieldsChecked) {
                    String cname = edCname.getText().toString();
                    String cnumber = edCnumber.getText().toString();
                    String tdata = edTdata.getText().toString();
                    String seccode = edScode.getText().toString();
                    try {
                        BitMatrix bitMatrix = multiFormatWriter.encode("Card holder name :"+cname+"\n"+
                                "Card holder number :"+cnumber+"\n"+
                                "Track Data :"+tdata+"\n"+
                                "Security code :"+seccode, BarcodeFormat.QR_CODE, 200, 200);
                        Bitmap bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565);
                        for (int x = 0; x < 200; x++) {
                            for (int y = 0; y < 200; y++) {
                                bitmap.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                            }
                        }
                        Intent qrd = new Intent(MainActivity.this, QRDisplay.class);
                        qrd.putExtra("qrcode", bitmap);
                        startActivity(qrd);
                        //imageView.setImageBitmap(bitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }
    private boolean CheckAllFields() {
        int a1 = edCnumber.length();
        int a2 = edTdata.length();

        if (edCname.length() == 0) {
            edCname.setError("Enter CardHolder Name");
            return false;
        }

        if (a1 == 0 && a2 == 0)
        {
            edCnumber.setError("Provide Track Data or Card Number");
            return false;
        }

        if (edScode.length() == 0) {
            edScode.setError("Enter CVV");
            return false;
        }
        return true;
    }
}
