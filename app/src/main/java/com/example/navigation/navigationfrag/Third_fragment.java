package com.example.navigation.navigationfrag;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigation.R;
import com.example.navigation.databinding.FragmentSecondFragmentBinding;
import com.example.navigation.databinding.FragmentThirdFragmentBinding;


public class Third_fragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentThirdFragmentBinding binding= DataBindingUtil.inflate(inflater,R.layout.fragment_third_fragment,container,false);
        View view=binding.getRoot();

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.fragment3to4);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}