package com.example.gobuy2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    ArrayList<HashMap<String, String>> List = new ArrayList<>();
    Activity activity;

    //歸0
    public ListAdapter(ArrayList listAdapter, Activity activity) {
        this.List = listAdapter;
        this.activity = activity;
        }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_listad,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.tx1.setText(List.get(position).get("store"));
        holder.tx2.setText(List.get(position).get("day"));
        holder.tx3.setText(List.get(position).get("time"));
        holder.tx4.setText(List.get(position).get("point"));
        holder.mView.setOnClickListener((v)->{
            Intent intent=new Intent(activity,ResultActivity.class);
            intent.putExtra("store",List.get(position).get("store"));
            intent.putExtra("day",List.get(position).get("day"));
            intent.putExtra("time",List.get(position).get("time"));
            intent.putExtra("point",List.get(position).get("point"));
            activity.startActivity(intent);
        });


        if (position%2==0){
            holder.linearLayout.setBackgroundColor(activity.getColor(R.color.pink));

        }
        else {
            holder.linearLayout.setBackgroundColor(activity.getColor(R.color.white));
        }
    }
    @Override
    public int getItemCount() {


        return List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tx1,tx2,tx3,tx4,sum;
        private LinearLayout linearLayout;
        private View mView;
        public ViewHolder( View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.linear);
            tx1=itemView.findViewById(R.id.list_l1_tv);
            tx2=itemView.findViewById(R.id.list_l2_tv);
            tx3=itemView.findViewById(R.id.list_l3_tv);
            tx4=itemView.findViewById(R.id.list_l4_tv);
            mView  = itemView;
        }
    }
}