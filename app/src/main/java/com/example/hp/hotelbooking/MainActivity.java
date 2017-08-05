package com.example.hp.hotelbooking;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.github.florent37.materialtextfield.MaterialTextField;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.firebase.auth.FirebaseAuth;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private Boolean exit;
    Drawer result;
    int year_x, day_x, month_x;
    int PLACE_PICKER_REQUEST = 1;
    private GoogleApiClient mGoogleApiClient;
    private MaterialTextField start;
    private MaterialTextField end;
    public double lats;
    public double longs;

    private MaterialTextField custom_pp;
    Place place;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*initialise googleclient*/
        //start button on click event
        Button button = (Button) findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,NearbyPlacesList.class);
                    startActivity(intent);
                }
            });


        //naviigation drawer



        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();

        /*current location*/
        exit = false;

        //navigation drawer
        new DrawerBuilder().withActivity(this).build();

        //adding drawer items
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.drawer_item_home);
          SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName(R.string.drawer_item_settings);

        //create the drawer and remember the `Drawer` result object
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                                FirebaseAuth.getInstance().signOut();
                                startActivity(new Intent(MainActivity.this, LoginActivity.class));



                        return false;
                    }
                })
                .build();

   //     set the selection to the item with the identifier 1

//set the selection to the item with the identifier 2
       boolean t =item2.isSelected();
        if(t){
            result.setSelection(2,true);
        }
//set the selection and also fire the `onItemClick`-listener


        /*calendar*/
        end = (MaterialTextField) findViewById(R.id.custom_end);
        start = (MaterialTextField) findViewById(R.id.custom_start);
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Typo Quik Bold_Demo.otf");
//        start.setTypeface(typeface);
//        end.setTypeface(typeface);
        setDate();
        /*Date picker*/
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        year_x = calendar.get(java.util.Calendar.YEAR);
        month_x = calendar.get(java.util.Calendar.MONTH);
        day_x = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        /*calendar ends*/

        /*location service*/
        custom_pp = (MaterialTextField) findViewById(R.id.custom_placepicker);
        custom_pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( mGoogleApiClient == null || !mGoogleApiClient.isConnected() )
                    return;
                Log.d("TAG", "before intent ");
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                try {
                    startActivityForResult(builder.build(MainActivity.this), PLACE_PICKER_REQUEST);
                    Log.d("TAG", "after intent ");
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }


            }

        });
//         /*logout service*/
//        logoutBtn = (Button) findViewById(R.id.logout);
//        logoutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                startActivity(new Intent(MainActivity.this, LoginActivity.class));
//            }
//        });


        /*logout service ends*/
    }

   //part of nav drawer
 //nav drawer ends

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        double lats=0,longs=0;
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format("Place: %s", place.getName());
//                String address = String.format("%s", place.getAddress());
                Log.d("", "onActivityResult:is called ");
                custom_pp.expand();
                custom_pp.getEditText().setText(toastMsg);
                lats = place.getLatLng().latitude;
                longs = place.getLatLng().longitude;
                Toast.makeText(this, ""+lats+longs, Toast.LENGTH_SHORT).show();
                setLatitude(lats);
                setLongitude(longs);
            }
        }

    }

    private void setLongitude(double longs) {
        this.longs = longs;
    }

    public double getLats() {
        return this.lats;
    }

    private void setLatitude(double lats) {
        this.lats = lats;
    }

    public double getLongs() {
        return this.longs;
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
        }    }

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


    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(MainActivity.this, connectionResult.getErrorMessage() + "", Toast.LENGTH_LONG).show();
    }


        /*location service ends*/







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


    private DatePickerDialog.OnDateSetListener dpicklistener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x = month;
            day_x = dayOfMonth;
            start.expand();
            EditText one =start.getEditText();
            one = (EditText) findViewById(R.id.start);
            one.setText(year_x + "-" + month_x + "-" + day_x);
        }
    };

    private DatePickerDialog.OnDateSetListener dpickerlistener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x = month;
            day_x = dayOfMonth;
            end.expand();
            EditText two =start.getEditText();
            two = (EditText) findViewById(R.id.end);
            two.setText(year_x + "-" + month_x + "-" + day_x);
        }
    };


    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this, dpicklistener, year_x, month_x, day_x);
        }
        if (id == 666) {
            return new DatePickerDialog(this, dpickerlistener, year_x, month_x, day_x);
        }
        return null;
    }
    /*Date picker ends*/
}
