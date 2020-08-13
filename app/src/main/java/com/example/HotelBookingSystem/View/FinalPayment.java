package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.HotelBookingSystem.Controllers.AddReservationController;
import com.example.HotelBookingSystem.Controllers.ViewProfileController;
import com.example.HotelBookingSystem.Models.Reservation;
import com.example.HotelBookingSystem.Models.User;
import com.example.HotelBookingSystem.R;

import java.text.ParseException;
import java.util.ArrayList;

public class FinalPayment extends AppCompatActivity {

    EditText checkint;
    EditText checkoutt;
    EditText noroom;
    EditText adultt;
    EditText childd;
    EditText name;
    EditText card;
    EditText exp;
    EditText cvv;
    EditText price;
    EditText tax;
    EditText cost;
    Button pay;

    double prices;
    double taxes;
    double finalprice;

    String checkindate;
    String checkoutdate;
    String hotel;
    String roomtype;
    Integer noofroom;
    Integer adlt;
    Integer chld;
    String userID;
    Reservation res;

    ViewProfileController cntrl = new ViewProfileController();
    AddReservationController cntrl1 = new AddReservationController();
    Context contxt;

    ArrayList<User> usrdetail = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_payment);
        contxt=this;
        checkindate = (String) getIntent().getSerializableExtra("checkin");
        checkoutdate = (String) getIntent().getSerializableExtra("checkout");
        noofroom = (Integer) getIntent().getSerializableExtra("nroom");
        roomtype = (String) getIntent().getSerializableExtra("roomt");
        adlt = (Integer) getIntent().getSerializableExtra("adult");
        chld = (Integer) getIntent().getSerializableExtra("child");
        userID = (String) getIntent().getSerializableExtra("userid");
        hotel = (String) getIntent().getSerializableExtra("HotelName");

        Cursor cursor = cntrl.getProfile(userID,contxt);

        checkint = (EditText)findViewById(R.id.editTextTextPersonName29);
        checkint.setText((String)getIntent().getSerializableExtra("checkin"));

        checkoutt = (EditText)findViewById(R.id.editTextTextPersonName30);
        checkoutt.setText((String)getIntent().getSerializableExtra("checkout"));

        noroom = (EditText)findViewById(R.id.editTextNumber3);
        noroom.setText((String)(getIntent().getSerializableExtra("nroom")));

        adultt = (EditText)findViewById(R.id.editTextNumber7);
        adultt.setText((String)(getIntent().getSerializableExtra("adult")));

        childd = (EditText)findViewById(R.id.editTextNumber8);
        childd.setText((String)getIntent().getSerializableExtra("child"));

        name = (EditText)findViewById(R.id.editTextTextPersonName6);
        String s1;
        String s2;
        s1=cursor.getString(cursor.getColumnIndexOrThrow("firstname"));
        s2=cursor.getString(cursor.getColumnIndexOrThrow("lastname"));
        String cname;
        cname= s1 + " " + s2;
        name.setText(cname);

        card = (EditText)findViewById(R.id.editTextNumber);
        card.setText(cursor.getString(cursor.getColumnIndexOrThrow("cardNumber")));

        exp = (EditText)findViewById(R.id.editTextTextPersonName8);
        exp.setText(cursor.getString(cursor.getColumnIndexOrThrow("expiryDate")));

        cvv = findViewById(R.id.editTextNumber9);

        try {
            finalprice = res.calculateCost(checkindate,checkoutdate,roomtype,noofroom);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        prices = finalprice/1.0825;
        taxes = finalprice - prices;

        price = (EditText)findViewById(R.id.editTextNumberDecimal3);
        price.setText((int) prices);

        tax = (EditText)findViewById(R.id.editTextNumberDecimal2);
        tax.setText((int) taxes);

        cost = (EditText)findViewById(R.id.editTextNumberDecimal);
        cost.setText((int) finalprice);

        pay = findViewById(R.id.button11);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cntrl1.addReservation(checkindate,checkoutdate,noofroom,roomtype,adlt,chld,hotel,userID,finalprice,contxt);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        });
    }

    public void summaryView(View view)
    {
        final String checkindate_ = String.valueOf(checkindate);
        final String checkoutdate_ = String.valueOf(checkoutdate);
        final Integer noofroom_ = Integer.valueOf(noofroom);
        final String roomtype_ = String.valueOf(roomtype);
        final Integer adults_ = Integer.valueOf(adlt);
        final Integer children_ = Integer.valueOf(chld);
        final String user = String.valueOf(userID);
        final String hotel_ = String.valueOf(hotel);
        final Double price_ = Double.valueOf(prices);
        final Double tax_ = Double.valueOf(taxes);
        final Double cost_ = Double.valueOf(finalprice);
        Intent n = new Intent(this,SummaryView.class);
        n.putExtra("checkin", checkindate_);
        n.putExtra("checkout", checkoutdate_);
        n.putExtra("nroom", noofroom_);
        n.putExtra("roomt", roomtype_);
        n.putExtra("adult", adults_);
        n.putExtra("child", children_);
        n.putExtra("userid", user);
        n.putExtra("hotel", hotel_);
        n.putExtra("price", price_);
        n.putExtra("tax", tax_);
        n.putExtra("cost", cost_);
        startActivity(n);
    }
}