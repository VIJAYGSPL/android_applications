package com.example.roomdbex5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class DeleteUserFragment extends Fragment {

    private EditText TxtUserid;
    private Button DeleteButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_delete_user, container, false);
        TxtUserid=view.findViewById(R.id.txt_delete_id);
        DeleteButton=view.findViewById(R.id.delete);
        DeleteButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                int id= Integer.parseInt(TxtUserid.getText().toString());
                User user=new User();
                user.setId(id);
                MainActivity.myAppDatabase.myDao().deleteUser(user);
                Toast.makeText(getActivity(),"User successfully removed:",Toast.LENGTH_SHORT).show();
                TxtUserid.setText("");
            }
        });
        return view;
    }
}