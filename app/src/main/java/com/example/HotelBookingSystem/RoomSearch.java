package com.example.HotelBookingSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RoomSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_search);
    }

    public void viewRoom(View view)
    {
        Intent intent = new Intent(this,FinalPayment.class);
        startActivity(intent);
    }
}