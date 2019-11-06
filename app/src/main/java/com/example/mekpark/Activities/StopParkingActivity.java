package com.example.mekpark.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mekpark.R;

public class StopParkingActivity extends AppCompatActivity {
    Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_parking);

        stop = findViewById(R.id.btn_stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StopParkingActivity.this, ReceiptActivity.class));
            }
        });
    }
}
