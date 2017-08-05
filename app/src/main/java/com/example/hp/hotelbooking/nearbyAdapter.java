package com.example.hp.hotelbooking;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kunai on 3/8/17.
 */

public class nearbyAdapter extends RecyclerView.Adapter<nearbyAdapter.MyViewHolder> {
    private List<content> list;

    public nearbyAdapter(List<content> list)
    {
        this.list = list;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView name_f,status_f,rating_f;
        public MyViewHolder(View itemView) {
            super(itemView);
            name_f = (TextView) itemView.findViewById(R.id.name);
            status_f = (TextView) itemView.findViewById(R.id.status);
            rating_f = (TextView) itemView.findViewById(R.id.rating);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content, parent, false);

        MyViewHolder holder = new MyViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder  holder, int position) {
        content c = list.get(position);
        holder.name_f.setText(c.getName());
        holder.status_f.setText(c.getOpenStatus());
        holder.rating_f.setText(c.getRating());
        Log.d("", "onBindViewHolder: binding happened");
    }

    @Override
    public int getItemCount() {
       return list.size();
    }




}
