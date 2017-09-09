package com.example.hp.hotelbooking;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by kunai on 25/8/17.
 */

public class favouriteAdapter extends RecyclerView.Adapter<favouriteAdapter.MyViewHolder> {
    private List<Info> list;
    Context context;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favelement, parent, false);

        favouriteAdapter.MyViewHolder holder = new MyViewHolder(itemView,list);
        context = itemView.getContext();
        return holder;

    }

    favouriteAdapter(List<Info> list){
        this.list = list;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Info info = list.get(position);
        holder.name.setText(info.getName());
        holder.openStatus.setText(info.getId());
        if (info.getRef()!=null) {
            Picasso.with(context).load(
                    "https://maps.googleapis.com/maps/api/place/photo?photoreference=" +  info.getRef() + "&maxwidth="
                            + "200" + "&maxheight=" + "200" + "&key=AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8").resize(690, 450).into(holder.image);
        } else {
            Picasso.with(context).load("https://maps.googleapis.com/maps/api/place/photo?maxwidth=100&photoreference=CnRtAAAATLZNl354RwP_9UKbQ_5Psy40texXePv4oAlgP4qNEkdIrkyse7rPXYGd9D_Uj1rVsQdWT4oRz4QrYAJNpFX7rzqqMlZw2h2E2y5IKMUZ7ouD_SlcHxYq1yL4KbKUv3qtWgTK0A6QbGh87GB3sscrHRIQiG2RrmU_jF4tENr9wGS_YxoUSSDrYjWmrNfeEHSGSc3FyhNLlBU&key=AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8")
                    .resize(650, 450)
                    .into(holder.image);
        }

    }

    @Override
    public int getItemCount() {
    if (list!=null)
        return list.size();
    return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,openStatus;
        ImageView image;
        List<Info> list;
        public MyViewHolder(View itemView, List list) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
            openStatus = (TextView) itemView.findViewById(R.id.status);
            this.list=list;
        }
    }
}
