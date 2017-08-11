package com.example.hp.hotelbooking;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.hotelbooking.data.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kunai on 3/8/17.
 */

public class nearbyAdapter extends RecyclerView.Adapter<nearbyAdapter.MyViewHolder> {
    private List<Result> list;
    final String API_KEY = "AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8";
    public ImageView image_f;
    public nearbyAdapter(List<Result> list)
    {
        this.list = list;
    }
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView name_f,status_f,rating_f;
        public MyViewHolder(View itemView) {
            super(itemView);
            name_f = (TextView) itemView.findViewById(R.id.name);
            status_f = (TextView) itemView.findViewById(R.id.status);
            rating_f = (TextView) itemView.findViewById(R.id.rating);
            image_f = (ImageView) itemView.findViewById(R.id.image);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content, parent, false);

        MyViewHolder holder = new MyViewHolder(itemView);
        context = itemView.getContext();
        return holder;

    }

    @Override
    public void onBindViewHolder( MyViewHolder  holder, int position) {
        Result c = list.get(position);
        try {

            holder.name_f.setText(c.getName());
            if (c.getOpeningHours() != null) {
                if (c.getOpeningHours().getOpenNow())
                    holder.status_f.setText("Open");
                else
                    holder.status_f.setText("Closed");
                holder.rating_f.setText(String.valueOf(c.getRating()));
            }

            int pos = getItemViewType(position);
                if (list.get(pos).getPhotos() != null) {
                        Picasso.with(context).load(
                                "https://maps.googleapis.com/maps/api/place/photo?photoreference=" +  c.getPhotos().get(0).getPhotoReference() + "&maxwidth="

                                        + c.getPhotos().get(0).getWidth() + "&maxheight=" + c.getPhotos().get(0).getHeight() + "&key=" + API_KEY).resize(200, 200).into(image_f);
                    } else {
                    Picasso.with(context).load("https://maps.googleapis.com/maps/api/place/photo?maxwidth=100&photoreference=CnRtAAAATLZNl354RwP_9UKbQ_5Psy40texXePv4oAlgP4qNEkdIrkyse7rPXYGd9D_Uj1rVsQdWT4oRz4QrYAJNpFX7rzqqMlZw2h2E2y5IKMUZ7ouD_SlcHxYq1yL4KbKUv3qtWgTK0A6QbGh87GB3sscrHRIQiG2RrmU_jF4tENr9wGS_YxoUSSDrYjWmrNfeEHSGSc3FyhNLlBU&key=AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8").resize(200, 200).into(image_f);
                }

            }catch(Exception e){
                //System.println("Array out of bound");
            }

        //holder.image_f.setImageDrawable((Drawable)c.getPhotos() );
        Log.d("", "onBindViewHolder: binding happened");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }



}