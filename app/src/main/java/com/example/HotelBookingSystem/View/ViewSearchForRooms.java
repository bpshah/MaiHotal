package com.example.HotelBookingSystem.View;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.HotelBookingSystem.Models.Room;
import com.example.HotelBookingSystem.Models.User;
import com.example.HotelBookingSystem.R;

import java.util.ArrayList;

public class ViewSearchForRooms extends AppCompatActivity {

    ListView listView;
    ArrayList<String> list;
    ArrayList<Room> list1;
    ArrayAdapter<String> adapter;
    Intent intent;
    Context contxt;
    String checkindate;
    String checkoutdate;
    String roomtype;
    Integer noofroom;
    Integer adults;
    Integer children;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_search_for_room);
        list1 = (ArrayList<Room>) getIntent().getSerializableExtra("rlist");
        checkindate = (String) getIntent().getSerializableExtra("checkin");
        checkoutdate = (String) getIntent().getSerializableExtra("checkout");
        noofroom = (Integer) getIntent().getSerializableExtra("nroom");
        roomtype = (String) getIntent().getSerializableExtra("roomt");
        adults = (Integer) getIntent().getSerializableExtra("adult");
        children = (Integer) getIntent().getSerializableExtra("child");
        userID = (String) getIntent().getSerializableExtra("username");

        listView = (ListView) findViewById(R.id.searchforroom);
        list = new ArrayList<String>();
        for (int i = 0; i < list1.size(); i++) {
            list.add("Hotel: " + list1.get(i)+ "Room Type: "+ list1.get(i));
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                final String checkindate_ = String.valueOf(checkindate);
                final String checkoutdate_ = String.valueOf(checkoutdate);
                final Integer noofroom_ = Integer.valueOf(noofroom);
                final String roomtype_ = String.valueOf(roomtype);
                final Integer adults_ = Integer.valueOf(adults);
                final Integer children_ = Integer.valueOf(children);
                final String user = String.valueOf(userID);
                Intent n = new Intent(getApplicationContext(), FinalPayment.class);
                n.putExtra("HotelName", list1.get(position));
                n.putExtra("checkin", checkindate_);
                n.putExtra("checkout", checkoutdate_);
                n.putExtra("nroom", noofroom_);
                n.putExtra("roomt", roomtype_);
                n.putExtra("adult", adults_);
                n.putExtra("child", children_);
                n.putExtra("userid", user);
                startActivity(n);
            }

        });

    }
}
