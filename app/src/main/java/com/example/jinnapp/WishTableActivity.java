package com.example.jinnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class WishTableActivity extends AppCompatActivity implements ChildEventListener{
    int countID=0;
    Map<Integer, String> states = new HashMap<Integer, String>();
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_table);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Write a message to the database
        DatabaseReference myRef = database.getReference("message");
        myRef.addChildEventListener(this);
        Log.d("Table","created");

    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
        Log.d("Table","Found child");
        String user_dat = dataSnapshot.getValue(String.class);
        String[] data = user_dat.split(";");

        Log.d("BD_namae", data[1]);
        Log.d("BD_wish", data[2]);

        String title = data[0];
        states.put(countID,user_dat);
        Button b = new Button(getApplicationContext());
        b.setText(title);
        b.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        b.setId(countID);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Table","Wish clicked");
                Intent intent3 = new Intent(WishTableActivity.this, WishActivity.class);
                Log.d("Table","id"+v.getId()+" ");
                Log.d("Table",states.get(v.getId()).toString());
                String[] some_data = states.get(v.getId()).split(";");

                intent3.putExtra("title",some_data[0]);
                intent3.putExtra("namae",some_data[1]);
                intent3.putExtra("wish",some_data[2]);
                intent3.putExtra("alias",some_data[3]);
                startActivity(intent3);
            }
        });
        linearLayout.addView(b);
        Log.d("Map","button created");
        countID++;
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
    }

//    @Override
//    public void onClick(View view){
//        switch (view.getId())
//        {
//            case R.id.submit_log:
//                Log.d("Wish","taken");
//                Intent intent1 = new Intent(WishTableActivity.this,WishActivity.class);
//                Toast.makeText(this, "Great! You gonna make this person happy!", Toast.LENGTH_SHORT).show();
//                startActivity(intent1);
//                break;
//        }
//    }
}
