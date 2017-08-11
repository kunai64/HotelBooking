package com.example.hp.hotelbooking;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.hp.hotelbooking.data.HotelAPIResponse;
import com.example.hp.hotelbooking.data.Result;
import com.google.gson.Gson;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by kunai on 3/8/17.
 */

public class NearbyPlacesList extends AppCompatActivity {

    final String API_KEY = "AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8";
    MainActivity ma = new MainActivity();
    private double lat=0;
    private double lang=0;
    private RecyclerView recyclerView;
    private nearbyAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nearby);

        lat = getIntent().getExtras().getDouble("latitude");
        lang = getIntent().getExtras().getDouble("longitude");
        Toast.makeText(this, "" + lat, Toast.LENGTH_SHORT).show();
        googlePlaces g = new googlePlaces();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
            g.execute();
        }
    }

    private List<Result> parseGoogleParse(String response) throws JSONException {
        List<Result> resultArrayList;
        Gson gson = new Gson();
        HotelAPIResponse hotelAPIResponse = gson.fromJson(response, HotelAPIResponse.class);
            resultArrayList = hotelAPIResponse.getResults();
        return resultArrayList;
    }

    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    protected class googlePlaces extends AsyncTask<Void, Void, String> {

        String url;


        String inputString = null;
        ProgressDialog asyncDialog = new ProgressDialog(NearbyPlacesList.this);
        @Override
        protected void onPreExecute() {
            //set message of the dialog
            asyncDialog.setMessage("Searching");
            //show dialog
            asyncDialog.show();
            super.onPreExecute();
        }


        @Override
        protected String doInBackground(Void... params) {
            StringBuilder ba;
            HttpURLConnection httpconn;
            url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+lat+","+lang+"&type=restaurant&radius=4000&key=AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8";
            StringBuffer sb = new StringBuffer();
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

        @Override
        protected void onPostExecute(String result) {
            asyncDialog.dismiss();
            if (result == null) {
                Toast.makeText(getApplicationContext(), "No Results Found", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    // venues = parseGoogleParse(result);
                    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

                    mAdapter = new nearbyAdapter(parseGoogleParse(result));

                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setAdapter(mAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}