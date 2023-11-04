package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ViewUsers extends AppCompatActivity {
    RecyclerView rcv;
    ImageButton editUser,delUser;
    List<String> list1=new ArrayList<String>();
    String str1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        editUser = (ImageButton)findViewById(R.id.btnupdate);
        delUser = (ImageButton) findViewById(R.id.btndelete);

        rcv = (RecyclerView) findViewById(R.id.rclView);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        UsersDatabase db = UsersDatabase.getDatabase(getApplicationContext());
        List<UserEntity> users = db.dao().getAll();

        UserListAdapter adapter = new UserListAdapter(users);
        rcv.setAdapter(adapter);

        //DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        //rcv.addItemDecoration(dividerItemDecoration);
        //rcv.setAdapter(new UserListAdapter(str1,this));

    }
}