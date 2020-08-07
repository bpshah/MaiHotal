package com.example.HotelBookingSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UpdateProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
    }
    public void nextPage(View view)
    {
        Intent intent = new Intent(this, com.example.HotelBookingSystem.UpdateProfile.class);
        Toast.makeText(this, "Profile Updated!", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void deleteUser(View view)
    {
        Intent intent = new Intent(this,UsersList.class);
        Toast.makeText(this,"User Deleted!",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}