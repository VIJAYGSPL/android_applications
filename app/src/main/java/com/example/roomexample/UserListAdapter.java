package com.example.roomexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    List<UserEntity> users;

    public UserListAdapter(List<UserEntity> users){ this.users = users; }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tv.setText(String.valueOf(users.get(position).getUserName()));
        holder.tv2.setText(String.valueOf(users.get(position).getPassword()));

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv,tv2;
        public MyViewHolder(View view){
            super(view);
            tv = (TextView) view.findViewById(R.id.t1);
            tv2 = (TextView) view.findViewById(R.id.t2);
            view.findViewById(R.id.btnupdate).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                }
            });

        }
    }

}

