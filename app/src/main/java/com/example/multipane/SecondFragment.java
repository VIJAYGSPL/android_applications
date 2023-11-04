package com.example.multipane;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.from(getContext()).inflate(R.layout.fragment_second,container,false);
        TextView customerName = view.findViewById(R.id.customerName);
        if (getArguments()!=null && getArguments().getString("customerName")!=null){
            customerName.setText(getArguments().getString("customerName"));
        }
        return view;
    }
}
