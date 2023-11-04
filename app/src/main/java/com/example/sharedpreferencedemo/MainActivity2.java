package com.example.sharedpreferencedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    SharedPreferences newPreference;
    Intent newIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView result = findViewById(R.id.res_text);
        Button LogOut_btn = findViewById(R.id.LogOut);
        newPreference = getSharedPreferences("user_details", MODE_PRIVATE);
        newIntent = new Intent(MainActivity2.this, MainActivity.class);
        result.setText("welcome,mainu");
        LogOut_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = newPreference.edit();
                edit.clear();
                edit.commit();
                finish();
                //startActivity(newIntent);
            }
        });



    }
}



