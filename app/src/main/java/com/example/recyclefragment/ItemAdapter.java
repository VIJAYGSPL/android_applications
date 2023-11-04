package com.example.recyclefragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> implements View.OnClickListener{

    Context context;
    List<Model> paymentListList;

    public ItemAdapter(Context context, List<Model> paymentList) {
        this.context = context;
        this.paymentListList = paymentList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout. rowltem, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.status.setText(paymentListList.get(position).getStatus());
        holder.rightmark.setImageResource(paymentListList.get(position).getPhoto());
        holder.dt.setText(paymentListList.get(position).getDt());
        holder.meeza.setText(paymentListList.get(position).getMeeza());
        holder.txn.setText(paymentListList.get(position).getTxn());
        holder.egp.setText(paymentListList.get(position).getEgp());
        holder.iv_arrow.setImageResource(paymentListList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return paymentListList.size();
    }

    @Override
    public void onClick(View view) {

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements Onclicklistener {

        TextView status;
        ImageView rightmark;
        TextView dt;
        TextView meeza;
        TextView txn;
        TextView egp;
        ImageView iv_arrow;


        @Override
        public void onClick(View view) {
            if (status.getId() == ((TextView) view).getId()) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "model status",
                        Toast.LENGTH_LONG);
                t.show();
            } else if (dt.getId() == ((TextView) view).getId()) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "model status",
                        Toast.LENGTH_LONG);
                t.show();
            } else if (meeza.getId() == ((TextView) view).getId()) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "model status",
                        Toast.LENGTH_LONG);
                t.show();
            } else if (txn.getId() == ((TextView) view).getId()) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "model status",
                        Toast.LENGTH_LONG);
                t.show();
            } else if (egp.getId() == ((TextView) view).getId()) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "model status",
                        Toast.LENGTH_LONG);
                t.show();
            } else if (rightmark.getId() == ((ImageView) view).getId()) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "model status",
                        Toast.LENGTH_LONG);
                t.show();
            }else if (iv_arrow.getId()==((ImageView)view).getId()){
                Toast t = Toast.makeText(getApplicationContext(),
                        "model status",
                        Toast.LENGTH_LONG);
                t.show();
            }

        }

        private Context getApplicationContext() {
            return null;
        }


        public MyViewHolder(View itemView) {
            super(itemView);
            status = (TextView) itemView.findViewById(R.id.status);
            rightmark = (ImageView) itemView.findViewById(R.id.rightmark);
            dt = (TextView) itemView.findViewById(R.id.date_time);
            meeza = (TextView) itemView.findViewById(R.id.meeza);
            txn = (TextView) itemView.findViewById(R.id.txn);
            egp = (TextView) itemView.findViewById(R.id.egp);
            iv_arrow=(ImageView) itemView.findViewById(R.id.iv_arrow);

        }
    }
}
