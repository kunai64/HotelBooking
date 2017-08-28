package com.example.hp.hotelbooking;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kunai on 25/8/17.
 */

public class favourites extends Activity{
    private String id;
    final String API_KEY = "AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8";
    private DatabaseReference mDatabase;
    List<String> idList= new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favs);
        mDatabase = FirebaseDatabase.getInstance().getReference("id");

}
}