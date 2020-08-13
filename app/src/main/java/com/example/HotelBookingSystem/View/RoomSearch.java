package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.HotelBookingSystem.Controllers.SearchforRoomController;
import com.example.HotelBookingSystem.Models.Room;
import com.example.HotelBookingSystem.R;

import java.util.ArrayList;

public class RoomSearch extends AppCompatActivity {

    EditText checkindate;
    EditText checkoutdate;
    EditText noofroom;
    EditText adults;
    EditText children;
    EditText roomtype;
    String userid;
    Context contxt;
    Intent intent;
    ArrayList<String> room = new ArrayList();
    SearchforRoomController cntrl = new SearchforRoomController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_search);
        System.out.println("In room search");

        checkindate = findViewById(R.id.editTextDate3);
        checkoutdate = findViewById(R.id.editTextDate4);
        noofroom = findViewById(R.id.editTextNumber4);
        adults = findViewById(R.id.editTextNumber5);
        children = findViewById(R.id.editTextNumber6);
        roomtype = findViewById(R.id.editTextTextPersonName3);

        userid = (String)getIntent().getSerializableExtra("userID");

        contxt = this;

    }

    public void searchroom(View view){

        final String checkindate_ = String.valueOf(checkindate.getText());
        final String checkoutdate_ = String.valueOf(checkoutdate.getText());
        final String noofroom_ = String.valueOf(noofroom.getText());
        final String roomtype_ = String.valueOf(roomtype.getText());
        final String adults_ = String.valueOf(adults.getText());
        final String children_ = String.valueOf(noofroom.getText());
        final String user = String.valueOf(userid);

        ArrayList<Room> rlist= new ArrayList<Room>();

        rlist = cntrl.roomsearch(checkindate_,checkoutdate_,noofroom_,roomtype_,contxt);
        System.out.println("In room search");
        if(rlist == null){
            intent = new Intent(this, RoomSearch.class);
            Toast t = Toast.makeText(contxt,"No room found on these dates",Toast.LENGTH_SHORT);
            t.show();
            startActivity(intent);
        }
        else{

            intent = new Intent(this, ViewSearchForRooms.class);
            intent.putExtra("rlist",rlist);
            //intent.putExtra("hotelList",room);
            intent.putExtra("checkin",checkindate_);
            intent.putExtra("checkout",checkoutdate_);
            intent.putExtra("nroom",noofroom_);
            intent.putExtra("roomt",roomtype_);
            intent.putExtra("adult",adults_);
            intent.putExtra("child",children_);
            intent.putExtra("username",user);
            contxt.startActivity(intent);
        }

    }

    public void viewRoom(View view)
    {
        Intent intent = new Intent(this,FinalPayment.class);
        startActivity(intent);
    }
}