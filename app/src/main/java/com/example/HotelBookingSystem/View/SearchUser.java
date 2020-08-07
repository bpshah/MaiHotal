package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.HotelBookingSystem.R;

public class SearchUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
    }
    public void search(View view)
    {
        Intent intent = new Intent(this,UsersList.class);
        startActivity(intent);
    }
}