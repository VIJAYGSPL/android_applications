package com.example.navigation.navigationfrag;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigation.R;
import com.example.navigation.databinding.FragmentFirstFragmentBinding;

public class First_fragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFirstFragmentBinding binding= DataBindingUtil.inflate(inflater,R.layout.fragment_first_fragment,container,false);
        View view=binding.getRoot();
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.fragment1to2);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}