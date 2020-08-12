package com.example.HotelBookingSystem.View;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.HotelBookingSystem.Controllers.SaveRoomController;
import com.example.HotelBookingSystem.Controllers.UpdateProfileAdminController;
import com.example.HotelBookingSystem.R;

public class ViewRoomDetails extends Activity {

    private String hotelname;
    private String roomno;
    private String roomtype;
    private String weekday;
    private String weekendprice;
    private String avail;

    EditText hname;
    EditText rno;
    EditText rtype;
    EditText wday;
    EditText wend;
    EditText avail_;

    Context contxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_room_details);

        contxt = this;

        hname = (EditText)findViewById(R.id.editTextTextPersonName18);
        hname.setText((String)getIntent().getSerializableExtra("HotelName"));

        rtype = (EditText)findViewById(R.id.editTextTextPersonName21);
        rtype.setText((String)getIntent().getSerializableExtra("RoomType"));

        wday = (EditText)findViewById(R.id.editTextTextPersonName22);
        wday.setText((String)(getIntent().getSerializableExtra("weekdayprice").toString()));

        wend = (EditText)findViewById(R.id.editTextTextPersonName23);
        wend.setText((String)(getIntent().getSerializableExtra("weekendprice")).toString());

        avail_ = (EditText)findViewById(R.id.editTextTextPersonName25);
        avail_.setText((String)getIntent().getSerializableExtra("availability"));

        rno = (EditText)findViewById(R.id.editTextTextPersonName24);
        rno.setText((String)(getIntent().getSerializableExtra("roomnumber")).toString());

    }

    public void saveRoom(View view)
    {
        final SaveRoomController cntrl = new SaveRoomController();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation !");
        builder.setMessage("Do you want to update the room information?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(cntrl.saveRoom(rtype.getText().toString(),wday.getText().toString(),wend.getText().toString(),avail_.getText().toString(),
                        hname.getText().toString(),rno.getText().toString(),contxt)){
                    Intent intent = new Intent(getApplicationContext(), SearchforRooms.class);
                    Toast.makeText(getApplicationContext(), "Update Successful", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), ViewRoomDetails.class);
                    Toast.makeText(getApplicationContext(), "Unable to Update Room Details.", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                hname.setText((String)getIntent().getSerializableExtra("HotelName"));
                rtype.setText((String)getIntent().getSerializableExtra("RoomType"));
                wday.setText((String)(getIntent().getSerializableExtra("weekdayprice").toString()));
                wend.setText((String)(getIntent().getSerializableExtra("weekendprice")).toString());
                avail_.setText((String)getIntent().getSerializableExtra("availability"));
                rno.setText((String)(getIntent().getSerializableExtra("roomnumber")).toString());
            }
        });

        builder.show();

    }


}
