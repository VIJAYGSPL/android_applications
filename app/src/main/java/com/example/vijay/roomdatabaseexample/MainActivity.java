package com.example.vijay.roomdatabaseexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.vijay.roomdatabaseexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DatabaseHandler db = new DatabaseHandler(this);
    EmpDetails empDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View src) {

                int id = binding.idEdtEmpId.getId();
                String name = binding.idEdtEmpName.getText().toString();
                String role = binding.idEdtEmpRole.getText().toString();
                String org = binding.idEdtEmpOrg.getText().toString();

                empDetails = new EmpDetails(id, name, role, org);
                if (empDetails != null) {
                    db.addEmployee(empDetails);
                } else {
                    Toast.makeText(MainActivity.this, "please check enter proper employee details ", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

}

