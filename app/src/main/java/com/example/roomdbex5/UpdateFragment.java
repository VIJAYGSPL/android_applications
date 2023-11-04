package com.example.roomdbex5;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateFragment extends Fragment
{
    private EditText UserId,UserName,UserEmail;
    private Button BnUpdate;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update, container, false);
       //Initialisation of all variables
        UserId=view.findViewById(R.id.txt_update_id);
        UserName=view.findViewById(R.id.txt_name);
        UserEmail=view.findViewById(R.id.txt_email);
        BnUpdate=view.findViewById(R.id.bn_update_user);
        BnUpdate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {                                           //Get information from the user
                int id = Integer.parseInt(UserId.getText().toString());
                String name= UserName.getText().toString();
                String email=UserEmail.getText().toString();

                User user=new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myAppDatabase.myDao().updateUser(user);
                Toast.makeText(getActivity(),"User updated...",Toast.LENGTH_SHORT).show();
                UserId.setText("");
                UserName.setText("");
                UserEmail.setText("");
            }
        });
        return view;
    }
}