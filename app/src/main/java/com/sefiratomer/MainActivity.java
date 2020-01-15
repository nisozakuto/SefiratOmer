package com.sefiratomer;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import org.w3c.dom.Text;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TimeZone;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;
import zmanim.*;
import zmanim.util.*;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final int REQUEST_LOCATION_PERMISSION = 1;
    String geolocation = "Istanbul";
    double latitude =41.0082, longitude= 28.9784;
//Testing
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        requestLocationPermission();

        TextView Sefirat = (TextView) findViewById(R.id.OmerText);
        final EditText locationText = (EditText) findViewById(R.id.locationText);
        Button locationButton = (Button) findViewById(R.id.locationButton);
        final TextView HalachicTimesTextView = (TextView) findViewById(R.id.HalachicTimes);

        final ZmanimTimes zmanimTimes = new ZmanimTimes();

        Sefirat.setText(getString(R.string.omer_text) + "\n\n" + getString(R.string.omer_days)+ "\n\n" + getString(R.string.lamnatseah));

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                geolocation = locationText.getText().toString();
                Toast.makeText(getApplicationContext(), geolocation, Toast.LENGTH_SHORT).show();
                //zmanimTimes.Sunrise(latitude, longitude, geolocation);

                String locationName = "Lakewood, NJ";
                double latitude = 40.096; //Lakewood, NJ
                double longitude = -74.222; //Lakewood, NJ
                double elevation = 0; //optional elevation
                TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
                GeoLocation location = new GeoLocation(locationName, latitude, longitude, elevation, timeZone);
//Use any of the API's Calendar classes
//AstronomicalCalendar zCal = new ComplexZmanimCalendar(location);
//ZmanimCalendar zCal = new ComplexZmanimCalendar(location);
                ComplexZmanimCalendar zCal = new ComplexZmanimCalendar(location);
//                Toast.makeText(getApplicationContext(), (CharSequence) zCal,Toast.LENGTH_SHORT).show();
Log.i("Time", String.valueOf(zCal));
                HalachicTimesTextView.setText(zmanimTimes.Sunrise(latitude, longitude,geolocation));
                //Usage of Fragments for City loader
                //https://guides.codepath.com/android/creating-and-using-fragments
            }
        });
        // BasicCalc basicCalc = new BasicCalc();
        //Log.i("Answer", String.valueOf(basicCalc.add(8,6)));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
        //Log.i("location: ", String.valueOf(this));
    }

    @AfterPermissionGranted(REQUEST_LOCATION_PERMISSION)
    public void requestLocationPermission() {

        String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION};
        //Log.i("location: ", String.valueOf(this));
        if(EasyPermissions.hasPermissions(this, perms)) {
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
        else {
            EasyPermissions.requestPermissions(this, "Please grant the location permission", REQUEST_LOCATION_PERMISSION, perms);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
