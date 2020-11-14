package com.example.jinnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MapActivity extends AppCompatActivity implements ChildEventListener{

    int countID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Write a message to the database
        DatabaseReference myRef = database.getReference("message");
        myRef.addChildEventListener(this);

    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
        String user_dat = dataSnapshot.getValue(String.class);
        String[] data = user_dat.split(";");

        Log.d("BD_namae",data[0]);
        Log.d("BD_wish",data[3]);

        String username=data[0];
        int x= Integer.parseInt(data[1]);
        int y= Integer.parseInt(data[2]);
        String wish = data[3];

        Button b = new Button(getApplicationContext());
        LinearLayout.LayoutParams linnear_lay = new LinearLayout.LayoutParams(250, 450); // высота и ширина
        linnear_lay.leftMargin = x; // отступ слева
        linnear_lay.topMargin = y; // отступ сверху

        b.setLayoutParams(linnear_lay);
        b.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)

        );
        b.setId(countID);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Wish","wish clicked");
            }
        });

        countID++;
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {}

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

    @Override
    public void onCancelled(DatabaseError databaseError) {}
}
