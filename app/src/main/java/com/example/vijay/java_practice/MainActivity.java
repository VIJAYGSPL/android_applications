package com.example.vijay.java_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.view.View;
import android.content.Intent;
import android.os.Bundle;

import com.example.vijay.java_practice.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        binding.nextButton.setOnClickListener(this);
        binding.startButton.setOnClickListener(this);
        binding.stopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View src) {

        if (src == binding.startButton)
            startService(new Intent(MainActivity.this, MyService.class));
        else if (src == binding.stopButton)
            stopService(new Intent(MainActivity.this, MyService.class));
        else
            startActivity(new Intent(MainActivity.this, NextActivity.class));
    }
}