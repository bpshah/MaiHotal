package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.HotelBookingSystem.R;

public class ManagerHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_home);
    }

    public void nextPage(View view)
    {
        Intent intent = new Intent(this, ReservationListManager.class);
        startActivity(intent);
    }

    public void nextPage1(View view)
    {
        Intent intent = new Intent(this, ViewProfile.class);
        String username = getIntent().getStringExtra("uniquename");
        intent.putExtra("userID",username);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}