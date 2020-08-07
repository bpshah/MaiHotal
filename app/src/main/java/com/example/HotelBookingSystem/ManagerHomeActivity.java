package com.example.HotelBookingSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ManagerHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_home);
    }

    public void nextPage(View view)
    {
        Intent intent = new Intent(this, com.example.HotelBookingSystem.ReservationListManager.class);
        startActivity(intent);
    }

    public void nextPage1(View view)
    {
        Intent intent = new Intent(this, com.example.HotelBookingSystem.ViewProfile.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(this, com.example.HotelBookingSystem.MainActivity.class);
        startActivity(intent);
        finish();
    }
}