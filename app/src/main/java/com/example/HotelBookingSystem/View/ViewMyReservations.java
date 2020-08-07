package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.HotelBookingSystem.R;

import java.util.ArrayList;

public class ViewMyReservations extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_reservations);

        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.view_rooms);

        list = new ArrayList<>();
        list.add("Reservation Id:- 1 Hotel Name:- Hotel Arlington Inn Check-in Date:- 07/18/2020 Check-out Date:- 07/20/2020");
        list.add("Reservation Id:- 3 Hotel Name:- Hotel Bella Vista Inn Check-in Date:- 07/20/2020 Check-out Date:- 07/22/2020");


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
    }
}