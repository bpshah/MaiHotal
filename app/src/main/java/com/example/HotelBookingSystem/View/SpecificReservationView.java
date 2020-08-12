package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.HotelBookingSystem.Controllers.ModifyReservationContoller;
import com.example.HotelBookingSystem.R;

import java.text.ParseException;

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
        final ModifyReservationContoller cntrl = new ModifyReservationContoller();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation !");
        builder.setMessage("Do you want to cancel the reservation?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(cntrl.deleteReservation(Integer.parseInt(id.getText().toString()),contxt)){
                    Intent intent = new Intent(getApplicationContext(), SearchReservation.class);
                    Toast.makeText(getApplicationContext(), "Reservation Canceled!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), SpecificReservationView.class);
                    Toast.makeText(getApplicationContext(), "Unable to cancel reservation.", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();

    }

    public void modifyreservation(View view){

        final ModifyReservationContoller cntrl = new ModifyReservationContoller();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation !");
        builder.setMessage("Do you want to update the reservation?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    if(cntrl.modifyreservation(checkindate.getText().toString(),checkoutdate.getText().toString(),roomtype.getText().toString(),
                            Integer.parseInt(adults.getText().toString()),Integer.parseInt(adults.getText().toString()),
                            Integer.parseInt(rooms.getText().toString()),
                            Integer.parseInt(id.getText().toString()),contxt)){
                        price.setText((String)(cntrl.getPrice()));
                        Intent intent = new Intent(getApplicationContext(), SearchReservation.class);
                        Toast.makeText(getApplicationContext(), "Reservation Updated!", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(getApplicationContext(), SpecificReservationView.class);
                        Toast.makeText(getApplicationContext(), "Unable to Update Reservation.", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
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
        });

        builder.show();

    }

}