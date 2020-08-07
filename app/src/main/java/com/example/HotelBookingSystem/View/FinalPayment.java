package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.HotelBookingSystem.R;

public class FinalPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_payment);
    }
    public void summaryView(View view)
    {
        Intent intent = new Intent(this,SummaryView.class);
        startActivity(intent);
    }
}