package com.example.jinnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

import java.time.Instant;
import java.util.Map;

public class NewAcc extends AppCompatActivity implements View.OnClickListener {
    EditText namae;
    EditText psw;
    Button submit_log;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_acc);

        namae=(EditText)findViewById(R.id.namae);
        psw=(EditText)findViewById(R.id.psw);
        submit_log =(Button)findViewById(R.id.submit_log);

        submit_log.setOnClickListener(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.submit_log:
                Log.d("Button","logged");
                Intent intent = new Intent(NewAcc.this, MapActivity.class);
                user=namae.getText().toString();
                intent.putExtra("user",user);
                startActivity(intent);
                break;
            //handle multiple view click events
        }
    }

}
