package com.example.mekpark.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.mekpark.R;
import com.skydoves.balloon.ArrowOrientation;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.OnBalloonClickListener;
import com.skydoves.balloon.OnBalloonOutsideTouchListener;

public class ProfileActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_profile);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_arrow);

        imageView = findViewById(R.id.info);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Balloon balloon = new Balloon.Builder(getBaseContext())
                        .setArrowSize(10)
                        .setArrowOrientation(ArrowOrientation.TOP)
                        .setArrowVisible(true)
                        .setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.white))
                        .setWidthRatio(0.6f)

                        .setHeight(80)
                        // .setTextSize(15f)
                        .setArrowPosition(0.81f)
                        .setCornerRadius(4f)
                        .setLayout(R.layout.popup)
                        .setLifecycleOwner(ProfileActivity.this)
                        .build();

                balloon.showAlignTop(imageView);
                balloon.setOnBalloonClickListener(new OnBalloonClickListener() {
                    @Override
                    public void onBalloonClick(View view) {
                        balloon.dismiss();
                    }
                });
                balloon.setOnBalloonOutsideTouchListener(new OnBalloonOutsideTouchListener() {
                    @Override
                    public void onBalloonOutsideTouch(View view, MotionEvent motionEvent) {
                        balloon.dismiss();
                    }
                });
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }




}
