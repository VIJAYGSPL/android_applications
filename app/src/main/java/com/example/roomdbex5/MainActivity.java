package com.example.roomdbex5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;


public class MainActivity extends AppCompatActivity
{

    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        myAppDatabase= Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userdb").allowMainThreadQueries().build();

            if(findViewById(R.id.fragment_container)!=null)
            {
                if (savedInstanceState != null) {
                    return;
                }
                fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).addToBackStack(null).commit();     //add fragmentmanager to the home activity

            }
           // MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new AddUserFragment()).addToBackStack(null).commit();

    }
}