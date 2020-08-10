package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.HotelBookingSystem.R;

public class AdminHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
    }

    public void searchUser(View view)
    {
        Intent intent = new Intent(this, SearchUser.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void viewProfile(View view){
        Intent intent = new Intent(this,ViewProfile.class);
        String username = getIntent().getStringExtra("uniquename");
        intent.putExtra("userID",username);
        startActivity(intent);
    }
}