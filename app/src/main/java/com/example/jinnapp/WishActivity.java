package com.example.jinnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WishActivity extends AppCompatActivity implements View.OnClickListener {

    TextView title_wish;
    TextView namae_wish;
    TextView wish_wish;
    TextView alias_wish;
    Button submit_done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish);
        title_wish = (TextView)findViewById(R.id.title_wish);
        namae_wish = (TextView)findViewById(R.id.namae_wish);
        wish_wish = (TextView)findViewById(R.id.wish_wish);
        submit_done=(Button)findViewById(R.id.submit_done);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String namae = intent.getStringExtra("namae");
        String wish = intent.getStringExtra("wish");
        String alias = intent.getStringExtra("alias");
        title_wish.setText(title);
        namae_wish.setText(namae);
        wish_wish.setText(wish);
        alias_wish.setText("tg "+alias);
        submit_done.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.submit_log:
                Log.d("Wish","taken");
                Intent intent1 = new Intent(WishActivity.this,MapActivity.class);
                Toast.makeText(this, "Great! You gonna make this person happy!", Toast.LENGTH_SHORT).show();
                startActivity(intent1);
                break;
        }
    }
}
