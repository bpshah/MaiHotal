package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.HotelBookingSystem.R;

public class UpdateProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
    }
    public void nextPage(View view)
    {
        Intent intent = new Intent(this, UpdateProfile.class);
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