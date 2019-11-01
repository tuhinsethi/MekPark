package com.example.mekpark.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mekpark.R;
import com.example.mekpark.error_report;
import com.example.mekpark.reciept;

public class MainActivity extends AppCompatActivity {
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);


    }

    public void onError(View v) {

        Intent i = new Intent(MainActivity.this, error_report.class);
        startActivity(i);

    }

    public void OnEnter(View v){
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);

    }

    public void onFeedback(View v){

        Intent i = new Intent(MainActivity.this, FeedbackActivity.class);
        startActivity(i);



    }
    public void onProfile(View v){


        Intent i = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(i);
    }
    public void onReciept(View v){

        Intent i = new Intent(MainActivity.this, reciept.class);
        startActivity(i);
    }
    public void onComplete(View v){
        Intent i = new Intent(MainActivity.this, CompletionActivity.class);
        startActivity(i);


    }

    public void onParkingComplete(View v){

        Intent i = new Intent(MainActivity.this,parkingcompleted.class);
        startActivity(i);

    }
}
