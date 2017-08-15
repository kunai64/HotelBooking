package com.example.hp.hotelbooking;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by kunai on 12/8/17.
 */

public class details extends Activity {
    private ImageView imageView;
    private TextView name,add,rate;
    final String API_KEY = "AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8";
    private String PhotoRef;
    private String Name;
    ArrayList<response.ResultBean> resultArrayList;


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
                "https://maps.googleapis.com/maps/api/place/photo?photoreference=" + PhotoRef + "&maxwidth=100&maxheight=100&key=" + API_KEY).resize(200, 200).into(imageView);
        //address
        add.setText(" "+getIntent().getExtras().getString("Address"));
        rate.setText(" "+getIntent().getExtras().getInt("Rating"));
        googlePlaces g = new googlePlaces();
        g.execute();

    }

    private void init(){
        imageView = (ImageView) findViewById(R.id.profile_image);
        name = (TextView) findViewById(R.id.name);
        add = (TextView) findViewById(R.id.address);
        rate = (TextView) findViewById(R.id.rating);

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
            TextView Phone,website;
            Phone = (TextView) findViewById(R.id.phone);
            website = (TextView) findViewById(R.id.website);
            Gson gson = new Gson();
            response hotelAPIResponse = gson.fromJson(result, response.class);
            resultArrayList =  hotelAPIResponse.getResult();
            details d = new details();
            String phoneNo=resultArrayList.getFormatted_phone_number();
            Phone.setText(" "+phoneNo);

            website.setText(" "+resultArrayList.getWebsite());
        }

    }
}
