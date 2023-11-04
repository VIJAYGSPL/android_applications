package com.example.multipane;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Customers {
    FrameLayout l1;
    FragmentManager fragmentManager;
    private String customerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1 = findViewById(R.id.activityContainer);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FirstFragment fragment = new FirstFragment();
        fragmentTransaction.add(l1.getId(),fragment);
        fragmentTransaction.commit();
    }
    @Override
    public void onCustomerClick(String customerName) {
//        Toast.makeText(this,"Cliked "+customerName,Toast.LENGTH_SHORT).show();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("customerName",customerName);
        SecondFragment secondFragment = new SecondFragment();
        ThridFragment thridFragment = new ThridFragment();
        secondFragment.setArguments(bundle);
        thridFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.customerDetailContainer,secondFragment);
        fragmentTransaction.replace(R.id.customerDetailContainer1,thridFragment);
        fragmentTransaction.commit();
    }
}