package com.example.HotelBookingSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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