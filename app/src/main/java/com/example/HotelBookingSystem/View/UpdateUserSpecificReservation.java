package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.HotelBookingSystem.R;

public class UpdateUserSpecificReservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_specific_reservation);
    }

    public void modReservation(View view)
    {
        Intent intent = new Intent(this,UpdateUserSpecificReservation.class);
        Toast.makeText(UpdateUserSpecificReservation.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}