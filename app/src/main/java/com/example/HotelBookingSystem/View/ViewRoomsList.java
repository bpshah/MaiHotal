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

public class ViewRoomsList extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayList<Room> list1;
    ArrayAdapter<String> adapter;
    Intent intent;
    Context contxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_list_manager);
        list1 = (ArrayList<Room>) getIntent().getSerializableExtra("roomList");
        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.view_rooms);

        list = new ArrayList<String>();
        for(int i = 0;i<list1.size();i++){
            list.add("Room Type: " + list1.get(i).getRoomtype() + " Hotel Name: " + list1.get(i).getHotel() + " Room Number: "+ list1.get(i).getRoomno());
        }
//        list.add("Hotel Arlington Inn Room Type:- Standard  Room Number:- 1");
//        list.add("Hotel Arlington Inn Room Type:- Standard  Room Number:- 2");
//        list.add("Hotel Bella vista Inn Room Type:- Standard  Room Number:- 1");
//        list.add("Hotel Days Inn Room Type:- Standard  Room Number:- 1");
//        list.add("Hotel Dallas Inn Room Type:- Standard  Room Number:- 1");


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
            {

                Intent n = new Intent(getApplicationContext(), ViewRoomDetails.class);
                n.putExtra("HotelName", list1.get(position).getHotel());
                n.putExtra("RoomType", list1.get(position).getRoomtype());
                n.putExtra("weekdayprice", list1.get(position).getRoomprice());
                n.putExtra("weekendprice", list1.get(position).getRoomweekendprice());
                n.putExtra("availability", list1.get(position).getRoomstatus());
                n.putExtra("roomnumber", list1.get(position).getRoomno());
                startActivity(n);
            }

        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if (list.contains(query)) {
                    adapter.getFilter().filter(query);
                } else {
                    Toast.makeText(ViewRoomsList.this, "No Match found", Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}