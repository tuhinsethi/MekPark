package com.example.mekpark.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mekpark.R;

public class AwaitingParkingActivity extends AppCompatActivity {
    Button reject;
    Button accept;
    FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkin3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_arrow);
        reject = findViewById(R.id.reject);

        accept = findViewById(R.id.accept);

        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AwaitingParkingActivity.this, OpenActivity.class));
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.checkin_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
