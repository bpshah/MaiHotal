package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.HotelBookingSystem.R;

public class ViewProfile extends AppCompatActivity {

    TextView fname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        String firstName = (String)getIntent().getSerializableExtra("firstname");
        fname = (TextView)findViewById(R.id.textView12);
        fname.setText(firstName);

    }
    public void nextPage(View view)
    {
        Intent intent = new Intent(this, UpdateProfile.class);
        startActivity(intent);
    }
}