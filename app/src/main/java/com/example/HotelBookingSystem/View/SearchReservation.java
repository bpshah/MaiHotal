package com.example.HotelBookingSystem.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.HotelBookingSystem.Controllers.SearchReservationCotroller;
import com.example.HotelBookingSystem.Models.Reservation;
import com.example.HotelBookingSystem.R;

import java.util.ArrayList;

public class SearchReservation extends Activity {

    EditText searchtxt;
    String uname;
    Context contxt;
    SearchReservationCotroller cntrl = new SearchReservationCotroller();
    ArrayList<Reservation> rlist= new ArrayList<Reservation>();
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_reservation);
        contxt = this;
        uname = getIntent().getStringExtra("userID");
        searchtxt = (EditText)findViewById(R.id.editTextDate2);
    }

    public void home(View view){
        Intent intent = new Intent(this, UserHomeActivity.class);
        startActivity(intent);

    }
    public void logout(View view){
        Intent intent = new Intent(this, MainActivity.class);
        Toast.makeText(this,"Logged Out!",Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }

    public void searchreservation(View view){
        String date = String.valueOf(searchtxt.getText());
        rlist = cntrl.searchreservations(date,uname,contxt);
        if(rlist == null){
            Toast t = Toast.makeText(contxt,"No reservation found after this date",Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            intent = new Intent(this, ViewMyReservations.class);
            intent.putExtra("rList",rlist);
            contxt.startActivity(intent);
        }
    }
}
