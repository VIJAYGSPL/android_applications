package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button register, viewAll;
    TextView username,password;
//    VALIDATION
    boolean isAllFieldsChecked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = (Button) findViewById(R.id.btnRegister);
        viewAll = (Button) findViewById(R.id.viewAll);

        username=(TextView) findViewById(R.id.username);
        password=(TextView) findViewById(R.id.password);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                validation
                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    UsersDatabase db = UsersDatabase.getDatabase(username.getContext());
                    UsersDatabase db1 = UsersDatabase.getDatabase(password.getContext());
                    UserEntity user = new UserEntity();
                    user.userName = username.getText().toString();
                    user.password = password.getText().toString();
                    db.dao().insert(user);
                    Toast.makeText(getApplicationContext(), "Record Inserted Succcessfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewUsers = new Intent(MainActivity.this,ViewUsers.class);
                startActivity(viewUsers);
            }
        });
    }
//    validation
    private boolean CheckAllFields() {
        if (username.length() == 0){
            username.setError("User Name");
            return false;
        }
        if (password.length() == 0){
            password.setError("Password");
            return false;
        }
        return true;
    }

}