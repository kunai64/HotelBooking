package com.example.hp.hotelbooking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.github.florent37.materialtextfield.MaterialTextField;

/**
 * Created by kunai on 1/9/17.
 */

public class dates extends Activity {
    private MaterialTextField start;
    private MaterialTextField end;
    int year_x, day_x, month_x;
    int lat,lang;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date);
        end = (MaterialTextField) findViewById(R.id.custom_end);
        start = (MaterialTextField) findViewById(R.id.custom_start);
        setDate();

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        year_x = calendar.get(java.util.Calendar.YEAR);
        month_x = calendar.get(java.util.Calendar.MONTH);
        day_x = calendar.get(java.util.Calendar.DAY_OF_MONTH);

        lat=getIntent().getExtras().getInt("latitude");
        lang=getIntent().getExtras().getInt("longitude");

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dates.this,NearbyPlacesList.class);
                intent.putExtra("latitude",lat);
                intent.putExtra("longitude",lang);

                startActivity(intent);
            }
        });

    }

    public void setDate() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(999);
            }
        });

        end.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showDialog(666);
            }
        });


    }


}
