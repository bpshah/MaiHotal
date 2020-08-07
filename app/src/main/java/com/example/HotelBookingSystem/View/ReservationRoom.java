package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.HotelBookingSystem.R;

public class ReservationRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_room);
    }
    public void finalpayment(View view)
    {
        Intent intent = new Intent(this,FinalPayment.class);
        startActivity(intent);
    }
}