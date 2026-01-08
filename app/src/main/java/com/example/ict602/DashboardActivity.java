package com.example.ict602;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DashboardActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Link the Java variables to the XML IDs
        ImageView imgBadminton = findViewById(R.id.imgBadminton);
        ImageView imgTennis = findViewById(R.id.imgTennis);
        ImageView imgPickleball = findViewById(R.id.imgPickleball);

        // Click Logic - Passes the sport name to the next screen
        imgBadminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBooking("Badminton");
            }
        });

        imgTennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBooking("Tennis");
            }
        });

        imgPickleball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBooking("Pickleball");
            }
        });

        // Initialize Google Map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    // Helper function to switch screens
    private void openBooking(String sportName) {
        Intent intent = new Intent(DashboardActivity.this, BookingActivity.class);
        intent.putExtra("SPORT_NAME", sportName);
        startActivity(intent);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker at a default location (e.g., Kuala Lumpur) and move the camera
        LatLng location = new LatLng(3.1390, 101.6869);
        mMap.addMarker(new MarkerOptions().position(location).title("Sports Centre Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
    }
}