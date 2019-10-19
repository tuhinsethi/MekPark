package com.example.mekpark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }

    public void OnEnter(View v){
        Intent i = new Intent(MainActivity.this,account_login.class);
        startActivity(i);

    }

    public void onFeedback(View v){

        Intent i = new Intent(MainActivity.this,feedback.class);
        startActivity(i);



    }
    public void onProfile(View v){


        Intent i = new Intent(MainActivity.this,profile.class);
        startActivity(i);
    }
    public void onReciept(View v){

        Intent i = new Intent(MainActivity.this,reciept.class);
        startActivity(i);
    }
    public void onComplete(View v){
        Intent i = new Intent(MainActivity.this,completion.class);
        startActivity(i);


    }
}
