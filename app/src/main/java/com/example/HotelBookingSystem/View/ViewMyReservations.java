package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.HotelBookingSystem.Models.Reservation;
import com.example.HotelBookingSystem.Models.Room;
import com.example.HotelBookingSystem.R;

import java.util.ArrayList;

public class ViewMyReservations extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayList<Reservation> list1;
    ArrayAdapter<String > adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_reservations);

        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.view_reservations);

        list1 = (ArrayList<Reservation>) getIntent().getSerializableExtra("rList");


        list = new ArrayList<String>();

        for(int i = 0;i<list1.size();i++){
            list.add("Reservation ID: " + list1.get(i).getReserveid() + " Hotel Name: " + list1.get(i).getHotel() +
                    " Check-in-Date: "+ list1.get(i).getCheckindate() +" Check-out-Date: "+ list1.get(i).getCheckoutdate());
        }

//        list.add("Reservation Id:- 1 Hotel Name:- Hotel Arlington Inn Check-in Date:- 07/18/2020 Check-out Date:- 07/20/2020");
//        list.add("Reservation Id:- 3 Hotel Name:- Hotel Bella Vista Inn Check-in Date:- 07/20/2020 Check-out Date:- 07/22/2020");


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(ViewMyReservations.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
            {

                Intent n = new Intent(getApplicationContext(), SpecificReservationView.class);
                n.putExtra("id", list1.get(position).getReserveid());
                n.putExtra("HotelName", list1.get(position).getHotel());
                n.putExtra("checkindate", list1.get(position).getCheckindate());
                n.putExtra("checkoutdate", list1.get(position).getCheckoutdate());
                n.putExtra("bookingdate", list1.get(position).getBookingdate());
                n.putExtra("roomtype", list1.get(position).getRoomtype());
                n.putExtra("adult", list1.get(position).getAdults());
                n.putExtra("children", list1.get(position).getChildren());
                n.putExtra("noofrooms", list1.get(position).getNoofroom());
                n.putExtra("price", list1.get(position).getCost());

                startActivity(n);
            }

        });

    }
}