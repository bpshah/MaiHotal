package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.HotelBookingSystem.R;

public class SpecificReservationView extends AppCompatActivity {

    TextView id;
    TextView hotelname;
    TextView bookingdate;
    TextView price;
    EditText checkindate;
    EditText checkoutdate;
    EditText roomtype;
    EditText adults;
    EditText children;
    EditText rooms;

    Context contxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_specific_reservation);

        contxt = this;

        id = (TextView)findViewById(R.id.textView97);
        hotelname = (TextView)findViewById(R.id.textView5);
        bookingdate = (TextView)findViewById(R.id.textView101);
        price = (TextView)findViewById(R.id.textView106);

        checkindate = (EditText)findViewById(R.id.editTextTextPersonName16);
        checkoutdate = (EditText)findViewById(R.id.editTextTextPersonName9);
        roomtype = (EditText)findViewById(R.id.editTextTextPersonName10);
        adults = (EditText)findViewById(R.id.editTextTextPersonName11);
        children = (EditText)findViewById(R.id.editTextTextPersonName12);
        rooms = (EditText)findViewById(R.id.editTextTextPersonName13);

        id.setText((String)(getIntent().getSerializableExtra("id").toString()));
        hotelname.setText((String)getIntent().getSerializableExtra("HotelName"));
        bookingdate.setText((String)getIntent().getSerializableExtra("bookingdate"));
        price.setText((String)(getIntent().getSerializableExtra("price").toString()));
        checkindate.setText((String)getIntent().getSerializableExtra("checkindate"));
        checkoutdate.setText((String)getIntent().getSerializableExtra("checkoutdate"));
        roomtype.setText((String)getIntent().getSerializableExtra("roomtype"));
        adults.setText((String)(getIntent().getSerializableExtra("adult").toString()));
        children.setText((String)(getIntent().getSerializableExtra("children").toString()));
        rooms.setText((String)(getIntent().getSerializableExtra("noofrooms").toString()));

    }
    public void deletereservation(View view){

    }

    public void modifyreservation(View view){

    }

}