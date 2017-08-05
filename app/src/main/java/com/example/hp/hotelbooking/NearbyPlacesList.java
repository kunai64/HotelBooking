package com.example.hp.hotelbooking;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kunai on 3/8/17.
 */

public class NearbyPlacesList extends AppCompatActivity {

    private double lat;
    private double lang;
    MainActivity ma = new MainActivity();
    final String API_KEY = "AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8";
    private RecyclerView recyclerView;
    private nearbyAdapter mAdapter;
    HttpResponse response;
    ArrayList<content>venues;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nearby);

        lat = ma.getLats();
        lang = ma.getLongs();
        Toast.makeText(this, ""+ lat, Toast.LENGTH_SHORT).show();
        googlePlaces g = new googlePlaces();
        g.execute();
    }

    protected class googlePlaces extends AsyncTask<Void, Void, String> {

        String url;


        String inputString = null;

        @Override
        protected String doInBackground(Void... params) {
            StringBuilder ba;
            HttpURLConnection httpconn;
            url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=22.72,75.83&type=hotel&radius=400&key=AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8";
              StringBuffer sb = new StringBuffer(url);
            try {
                String inputString = null;
                URL urlconn = new URL(url);
                httpconn = (HttpURLConnection) urlconn.openConnection();
                httpconn.setRequestMethod("GET");
                httpconn.connect();
                InputStream is = httpconn.getInputStream();
                BufferedReader bf = new BufferedReader(new InputStreamReader(is));
                ba = new
                        StringBuilder();

                while ((bf.read() != -1)) {
                    ba.append(inputString);

                }
                return ba.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            HttpClient httpClient = new DefaultHttpClient();
//            HttpGet get = new HttpGet(url);

            return null;

        }

        @Override
        protected void onPostExecute(String result) {
            if(url == null){
                Toast.makeText(getApplicationContext(), "No Results Found", Toast.LENGTH_SHORT).show();
            }
            else {
                try {
                    venues = parseGoogleParse(url);
                    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    List listTitle = new ArrayList();
                    for (int i = 0; i < venues.size(); i++) {
                        // make a list of the venus that are loaded in the list.
                        // show the name, the category and the city
                        listTitle.add(i, venues.get(i).getName() + "\nOpen Now: " + venues.get(i).getOpenNow() );
                    }
                    mAdapter = new nearbyAdapter(listTitle);

                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setAdapter(mAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    private ArrayList parseGoogleParse(final String url) throws JSONException {
        ArrayList<content> temp;
        temp = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(url);

        if (jsonObject.has("results")) {
            JSONArray jsonArray = new JSONArray("results");
            content c = new content();
            for (int i = 0; i < jsonArray.length(); i++) {

                if (jsonArray.getJSONObject(i).has("name")) {
                    c.setName(jsonArray.getJSONObject(i).optString("name"));
                    if (jsonArray.getJSONObject(i).has("opening_hours")){
                        if(jsonArray.getJSONObject(i).getJSONObject("opening_hours").has("open")){
                            if (jsonArray.getJSONObject(i).getJSONObject("opening_hours").getString("open_now").equals("true")) {
                                c.setOpenNow("YES");
                            } else {
                                c.setOpenNow("NO");
                            }
                        }
                    }
                    else {
                        c.setOpenNow("Not Known");
                    }
                }
            }

            temp.add(c);
        }
        return temp;
    }
}