package com.example.hp.hotelbooking;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kunai on 25/8/17.
 */

public class favourites extends Activity{
    private String id;
    List<Info> list;
    private RecyclerView recyclerView;
    private favouriteAdapter fAdapter;
    final String API_KEY = "AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8";
    private DatabaseReference mDatabase;
    List<String> idList= new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favs);
        mDatabase = FirebaseDatabase.getInstance().getReference("id");
        recyclerView = (RecyclerView) findViewById(R.id.favRecyclerView);
        fAdapter = new favouriteAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(fAdapter);
    }
}