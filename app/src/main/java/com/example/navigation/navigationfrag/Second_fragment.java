package com.example.navigation.navigationfrag;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigation.R;
import com.example.navigation.databinding.FragmentFirstFragmentBinding;
import com.example.navigation.databinding.FragmentSecondFragmentBinding;


public class Second_fragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSecondFragmentBinding binding= DataBindingUtil.inflate(inflater,R.layout.fragment_second_fragment,container,false);
        View view=binding.getRoot();

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.fragment2to3);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}