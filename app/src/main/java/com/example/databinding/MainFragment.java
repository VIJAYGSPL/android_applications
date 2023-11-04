package com.example.databinding;



import android.os.Bundle;


import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.databinding.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    // Initialize variable
    private FragmentMainBinding binding;
    private View view;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Assign variable
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false);
        view=binding.getRoot();

        binding.btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get text from edit text
                String sText=binding.etInput.getText().toString().trim();

                // Check condition
                if(!sText.equals(""))
                {
                    // When text is not empty
                    // Set text on text view
                    binding.tvOutput.setText(sText);
                }
                else
                {
                    // When text is empty
                    // Display Toast
                    Toast.makeText(view.getContext(),
                            "Please enter text",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Return view
        return view;
    }
}
