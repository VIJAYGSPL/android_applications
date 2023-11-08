package com.example.vijay.java_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vijay.java_practice.databinding.ActivityMainBinding;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public ActivityMainBinding binding;
    MyService myService;
    boolean isbound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        binding.nextButton.setOnClickListener(this);
        binding.startButton.setOnClickListener(this);
        binding.stopButton.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            Intent intent = new Intent(MainActivity.this, MyService.class);
            bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onButtonPressed(View view){
        EditText editText = (EditText) findViewById(R.id.ed_text);
        editText.setText(myService.getSystemTime());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Random number: "+String.valueOf(myService.getRandomNumber()), Toast.LENGTH_LONG).show();
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(runnable, 5000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isbound) {
            unbindService(serviceConnection);
        }
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

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            MyService.MyBinder binderBridge = (MyService.MyBinder) service;
            myService = binderBridge.getService();
            isbound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isbound = false;
            myService = null;
        }
    };
}