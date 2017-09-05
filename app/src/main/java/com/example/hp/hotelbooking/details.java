package com.example.hp.hotelbooking;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import io.techery.properratingbar.ProperRatingBar;

/**
 * Created by kunai on 12/8/17.
 */

public class details extends AppCompatActivity {
    private ImageView imageView;
    private TextView name;
    private TextView add;
    private TextView rate;
    private TextView review;
    private ProperRatingBar stars;
    final String API_KEY = "AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8";
    private String PhotoRef;
    private String Name;
    private CheckBox cb;
    private DatabaseReference mDatabase;
    private String placeId;
    private LinearLayout call;
    private ProperRatingBar fav;
    private int i=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        init();

        PhotoRef = getIntent().getExtras().getString("photoRef");
        Name = getIntent().getExtras().getString("name");
        //Naming
        name.setText(Name);
        //setting up image
        Picasso.with(details.this).load(
                "https://maps.googleapis.com/maps/api/place/photo?photoreference=" + PhotoRef + "&maxwidth=1000&maxheight=800&key=" + API_KEY).resize(750, 600).into(imageView);
        //address
        add.setText(" " + getIntent().getExtras().getString("Address"));
        rate.setText(" " + getIntent().getExtras().getInt("Rating"));
        googlePlaces g = new googlePlaces();
        g.execute();
        //checkbox click listener

        //favourite
    }
    private void init(){
        call = (LinearLayout) findViewById(R.id.call);
         imageView = (ImageView) findViewById(R.id.profile_image);
        name = (TextView) findViewById(R.id.name);
        add = (TextView) findViewById(R.id.address);
        rate = (TextView) findViewById(R.id.rating);
        //firebase ref
        mDatabase = FirebaseDatabase.getInstance().getReference("id");
        review = (TextView) findViewById(R.id.reviews);
        stars = (ProperRatingBar) findViewById(R.id.stars);
    }

    //gson parsing

    protected class googlePlaces extends AsyncTask<Void, Void, String> {

        String url;
        response.ResultBean resultArrayList;


        @Override
        protected String doInBackground(Void... params) {
            HttpURLConnection httpconn;
            url = "https://maps.googleapis.com/maps/api/place/details/json?placeid="+ getIntent().getExtras().getString("id") +"&key="+API_KEY;
            try {

                URL urlconn = new URL(url);
                httpconn = (HttpURLConnection) urlconn.openConnection();
                httpconn.setRequestMethod("GET");
                httpconn.connect();

                return readStream(httpconn.getInputStream());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            HttpClient httpClient = new DefaultHttpClient();
//            HttpGet get = new HttpGet(url);

            return null;

        }

        // Converting InputStream to String

        private String readStream(InputStream in) {
            BufferedReader reader = null;
            StringBuffer response = new StringBuffer();
            try {
                reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return response.toString();
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(String result) {
            TextView Phone,open;
            final int REQUEST_PHONE_CALL=1;
            LinearLayout website;
            Phone = (TextView) findViewById(R.id.phone);
            website = (LinearLayout)findViewById(R.id.website);
            open = (TextView) findViewById(R.id.open);
            Gson gson = new Gson();
            response hotelAPIResponse = gson.fromJson(result, response.class);
            resultArrayList =  hotelAPIResponse.getResult();
            final details d = new details();
            String phoneNo=resultArrayList.getFormatted_phone_number();
            Phone.setText(" "+phoneNo);

            //place id
            placeId = resultArrayList.getPlace_id();
            website.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = resultArrayList.getWebsite();
                    Intent i = new Intent(details.this, webview.class);
                    i.putExtra("url",url);
                    startActivity(i);
                }
            });
            review.setText(resultArrayList.getReviews().size() + " reviews");
            stars.setRating((int) resultArrayList.getRating());
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {                   Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + resultArrayList.getFormatted_phone_number()));
                    int checkPermission = ContextCompat.checkSelfPermission(details.this, android.Manifest.permission.CALL_PHONE);
                    if (checkPermission != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(details.this, new String[]{android.Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);

                    } else {
                       startActivity(intent);
                    }
                    if (ActivityCompat.checkSelfPermission(details.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }

                }
            });

        }

    }
}
