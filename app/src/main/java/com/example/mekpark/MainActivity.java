package com.example.mekpark;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_login);

        login = findViewById(R.id.login);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });



    }

    public void OnEnter(View v){
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
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
