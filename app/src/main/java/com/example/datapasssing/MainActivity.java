package com.example.datapasssing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // define the variable
    Button button;
    EditText editText;
    boolean isAllFieldsChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.send);
       editText = (EditText)findViewById(R.id.textview);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    String str = editText.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                        intent.putExtra("message_key", str);
                        startActivity(intent);
                }
            }
        });
    }
    private boolean CheckAllFields() {
        if (editText.length() == 0){
            editText.setError("Enter Input");
        return false;
    }
    return true;
    }

}