package com.example.recyclefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class NewFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    List<Model> listCont;

    public NewFragment () {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_new,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.contact_recycleView);
        ItemAdapter viewAdapter = new ItemAdapter(getContext(), listCont);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(viewAdapter);
        return v;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        listCont = new ArrayList<>();
        listCont.add(new Model("SUCCESS",R.drawable.ic_launcher_background,"29/03/22               15:44 ","Meeza digital receive(p)","Txn Id:6538754","EGP:10.00",R.drawable.ic_launcher_background));
        listCont.add(new Model("SUCCESS",R.drawable.ic_launcher_background,"29/03/22               15:44 ","Meeza digital receive(p)","Txn Id:6538754","EGP:10.00",R.drawable.ic_launcher_background));
        listCont.add(new Model("SUCCESS",R.drawable.ic_launcher_background,"29/03/22               15:44 ","Meeza digital receive(p)","Txn Id:6538754","EGP:10.00",R.drawable.ic_launcher_background));
        listCont.add(new Model("SUCCESS",R.drawable.ic_launcher_background,"29/03/22               15:44 ","Meeza digital receive(p)","Txn Id:6538754","EGP:10.00",R.drawable.ic_launcher_background));
        listCont.add(new Model("SUCCESS",R.drawable.ic_launcher_background,"29/03/22               15:44 ","Meeza digital receive(p)","Txn Id:6538754","EGP:10.00",R.drawable.ic_launcher_background));
        listCont.add(new Model("SUCCESS",R.drawable.ic_launcher_background,"29/03/22               15:44 ","Meeza digital receive(p)","Txn Id:6538754","EGP:10.00",R.drawable.ic_launcher_background));
        listCont.add(new Model("SUCCESS",R.drawable.ic_launcher_background,"29/03/22               15:44 ","Meeza digital receive(p)","Txn Id:6538754","EGP:10.00",R.drawable.ic_launcher_background));
        listCont.add(new Model("SUCCESS",R.drawable.ic_launcher_background,"29/03/22               15:44 ","Meeza digital receive(p)","Txn Id:6538754","EGP:10.00",R.drawable.ic_launcher_background));




    }

}

