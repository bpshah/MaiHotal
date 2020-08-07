package com.example.HotelBookingSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewRoomsList extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_list_manager);

        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.view_rooms);

        list = new ArrayList<>();
        list.add("Hotel Arlington Inn Room Type:- Standard  Price:- $64.58 per night");
        list.add("Hotel Arlington Inn Room Type:- Standard  Price:- $64.58 per night");
        list.add("Hotel Bella vista Inn Room Type:- Standard  Price:- $69.58 per night");
        list.add("Hotel Days Inn Room Type:- Standard  Price:- 69.58 per night");
        list.add("Hotel Dallas Inn Room Type:- Standard  Price:- 75.58 per night");


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

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