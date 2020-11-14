package com.example.jinnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText namae;
    EditText psw;
    Button submit_log;
    Button create_acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namae=(EditText)findViewById(R.id.namae);
        psw=(EditText)findViewById(R.id.psw);
        submit_log =(Button)findViewById(R.id.submit_log);
        create_acc=(Button)findViewById(R.id.create_acc);

        submit_log.setOnClickListener(this);
        create_acc.setOnClickListener(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Write a message to the database
        DatabaseReference myRef = database.getReference("message/stuff");

//        myRef.setValue("Hello, World!");
        // Read from the database

        // Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d("DB", "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("DB", "Failed to read value.", error.toException());
//            }
//        });
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.submit_log:
                Log.d("Button","logged");
                Intent intent1 = new Intent(MainActivity.this,MapActivity.class);
                startActivity(intent1);
                break;
            case R.id.create_acc:
                Log.d("Button","creating");
                Intent intent2 = new Intent(MainActivity.this,NewAcc.class);
                startActivity(intent2);
                break;
            //handle multiple view click events
        }
    }

}
