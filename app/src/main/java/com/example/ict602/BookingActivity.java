package com.example.ict602;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        TextView tvSportTitle = findViewById(R.id.tvSportTitle);

        // Get the sport name passed from Dashboard
        String sport = getIntent().getStringExtra("SPORT_NAME");
        tvSportTitle.setText("Book " + sport + " Court");

        Button btnSlot1 = findViewById(R.id.btnSlot1);
        Button btnSlot2 = findViewById(R.id.btnSlot2);
        Button btnSlot3 = findViewById(R.id.btnSlot3);

        // Simple click listener for booking
        btnSlot1.setOnClickListener(v -> confirmBooking(sport, "09:00 AM"));
        btnSlot2.setOnClickListener(v -> confirmBooking(sport, "02:00 PM"));
        btnSlot3.setOnClickListener(v -> confirmBooking(sport, "08:00 PM"));
    }

    private void confirmBooking(String sport, String time) {
        Toast.makeText(this, "Confirmed: " + sport + " at " + time, Toast.LENGTH_LONG).show();
        // Return to dashboard after booking
        finish();
    }
}