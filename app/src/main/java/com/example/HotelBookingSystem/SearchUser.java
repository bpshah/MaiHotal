package com.example.HotelBookingSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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