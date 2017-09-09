package com.example.hp.hotelbooking;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.hotelbooking.data.HotelAPIResponse;
import com.example.hp.hotelbooking.data.Result;
import com.github.florent37.materialtextfield.MaterialTextField;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.gson.Gson;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

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

public class NearbyPlacesList extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener,GoogleApiClient.ConnectionCallbacks{

    final String API_KEY = "AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8";
    private String lat;
    private String lang;
    private RecyclerView recyclerView;
    private nearbyAdapter mAdapter;
    private Boolean exit;
    private MaterialTextField custom_pp;
    int PLACE_PICKER_REQUEST = 1;
    private GoogleApiClient mGoogleApiClient;
    Place place;
    EditText editText;
    Drawer result;
    private static final int PERMISSION_ACCESS_COARSE_LOCATION = 1;
    private DatabaseReference databaseReference;
    public NearbyPlacesList() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*initialise googleclient*/

        //custom button on click
        editText = (EditText) findViewById(R.id.placepicker);
        custom_pp = (MaterialTextField) findViewById(R.id.custom_placepicker);
        custom_pp.expand();

        //Place Picker
        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();


         /*location service*/
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( mGoogleApiClient == null || !mGoogleApiClient.isConnected() )
                    return;
                Log.d("TAG", "before intent ");
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                try {
                    startActivityForResult(builder.build(NearbyPlacesList.this), PLACE_PICKER_REQUEST);
                    Log.d("TAG", "after intent ");
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }

        });


        //Users Current Location
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { android.Manifest.permission.ACCESS_COARSE_LOCATION },
                    PERMISSION_ACCESS_COARSE_LOCATION);
        }
        LocationManager locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        boolean network_enabled = locManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        Location location;
        if(network_enabled){
            location = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if(location!=null){
                lang = String.valueOf(location.getLongitude());
                lat = String.valueOf(location.getLatitude());
            }

            if(getIntent().getExtras()!=null && getIntent().getExtras()!=null){
                lat=getIntent().getExtras().getString("latitude");
                lang=getIntent().getExtras().getString("longitude");
            }
        }

        Toast.makeText(this, "" + lat, Toast.LENGTH_SHORT).show();
        googlePlaces g = new googlePlaces();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
            g.execute();
        }

        exit = false;
        //navigation drawer
        new DrawerBuilder().withActivity(this).build();

        //adding drawer items

//        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("Favourites");
        //create the drawer and remember the `Drawer` result object
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        result = new DrawerBuilder()
                .withActivity(this)
                .withHasStableIds(true)
                .withToolbar(toolbar)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Favourites").withIdentifier(1).withSelectable(false),
                          new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("Logout").withIdentifier(2).withSelectable(false)
  //
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if(drawerItem!=null){
                            if (drawerItem.getIdentifier()==1) {
                                FirebaseAuth.getInstance().signOut();
                                startActivity(new Intent(NearbyPlacesList.this, LoginActivity.class));
                            }
                            if (drawerItem.getIdentifier()==2)
                                startActivity(new Intent(NearbyPlacesList.this,favourites.class));
                        }
                            return false;

                    }
                })
                .build();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        double lats=0,longs=0;
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format("Place: %s", place.getName());
//                String address = String.format("%s", place.getAddress());
                Log.d("", "onActivityResult:is called ");
                custom_pp.getEditText().setText(toastMsg);
             Button button = (Button) findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(NearbyPlacesList.this,NearbyPlacesList.class);
                        lat = String.valueOf(place.getLatLng().latitude);
                        lang = String.valueOf(place.getLatLng().longitude);
                        intent.putExtra("latitude",lat);
                        intent.putExtra("longitude",lang);
                        startActivity(intent);
                    }
                });
                Toast.makeText(this, ""+lats+longs, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if( mGoogleApiClient != null )
            mGoogleApiClient.connect();

    }

    @Override
    protected void onStop() {
        if( mGoogleApiClient != null && mGoogleApiClient.isConnected() ) {
            mGoogleApiClient.disconnect();
        }

        super.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_ACCESS_COARSE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // All good!
                } else {
                    Toast.makeText(this, "Need your location!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if(exit) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
            exit = true;
        }
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.i(NearbyPlacesList.class.getSimpleName(), "Can't connect to Google Play Services!");

    }

    private List<Result> parseGoogleParse(String response) throws JSONException {
        List<Result> resultArrayList;
        Gson gson = new Gson();
        HotelAPIResponse hotelAPIResponse = gson.fromJson(response, HotelAPIResponse.class);
            resultArrayList = hotelAPIResponse.getResults();
        return resultArrayList;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    protected class googlePlaces extends AsyncTask<Void, Void, String> {
        String url;
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
            HttpURLConnection httpconn;
            url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+lat+","+lang+"&type=restaurant&radius=4000&key=AIzaSyD0vwXNlmIu_O4lAyCOB8imnnl3olpaVN8";
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

    class Favourites{
        String id;
        String name;
        String reference;

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getReference() {
            return reference;
        }
    }
}