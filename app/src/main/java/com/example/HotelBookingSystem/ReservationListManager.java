package com.example.HotelBookingSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReservationListManager extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_list_manager);

        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.view_rooms);

        list = new ArrayList<>();
        list.add("Reservation Id:- 1 Check-in Date:- 07/18/2020 Check-out Date:- 07/20/2020");
        list.add("Reservation Id:- 2 Check-in Date:- 07/20/2020 Check-out Date:- 07/21/2020");
        list.add("Reservation Id:- 3 Check-in Date:- 07/20/2020 Check-out Date:- 07/23/2020");
        list.add("Reservation Id:- 4 Check-in Date:- 07/20/2020 Check-out Date:- 07/21/2020");
        list.add("Reservation Id:- 5 Check-in Date:- 07/27/2020 Check-out Date:- 07/29/2020");


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(ReservationListManager.this, "No Match found",Toast.LENGTH_LONG).show();
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

    public void nextPage(View view)
    {
        Intent intent = new Intent(this, com.example.HotelBookingSystem.SpecificReservationView.class);
        startActivity(intent);
    }

    public void nextPage1(View view)
    {
        Intent intent = new Intent(this, com.example.HotelBookingSystem.ManagerHomeActivity.class);
        startActivity(intent);
    }
}