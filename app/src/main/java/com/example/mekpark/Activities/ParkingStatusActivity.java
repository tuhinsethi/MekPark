package com.example.mekpark.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mekpark.R;

public class ParkingStatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_status);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_arrow);

        Button print = findViewById(R.id.print);
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ParkingStatusActivity.this, PrintReceiptActivity.class));
            }
        });
        Button book = findViewById(R.id.book);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.checkin_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
