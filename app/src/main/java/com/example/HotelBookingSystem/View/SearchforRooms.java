package com.example.HotelBookingSystem.View;

import android.app.Activity;
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

public class SearchforRooms extends Activity {

    Context contxt;
    Intent intent;
    EditText roomno;
    EditText hotel;
    Button searchroombtn;
    SearchforRoomController cntrl = new SearchforRoomController();
    ArrayList<Room> rooms = new ArrayList<Room>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_for_room);
        contxt = this;

        hotel = (EditText)findViewById(R.id.editTextTextPersonName19);
        roomno = (EditText)findViewById(R.id.editTextTextPersonName20);
        searchroombtn = (Button)findViewById(R.id.button19);

    }

    public void searchroom(View view)
    {
        final String hotel_ = String.valueOf(hotel.getText());
        final String roomno_ = String.valueOf(roomno.getText());

        rooms = cntrl.searchforroom(roomno_,hotel_,contxt);

        if(rooms == null){
            Toast t = Toast.makeText(contxt,"No room found with this hotel name and roomno",Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            intent = new Intent(this, ViewRoomsList.class);
            intent.putExtra("roomList",rooms);
            contxt.startActivity(intent);
        }

    }

    public void home(View view){
        intent = new Intent(this, ManagerHomeActivity.class);
        contxt.startActivity(intent);

    }

    public void logout(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
