package com.example.mekpark.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mekpark.R;

public class LauncherActivity extends AppCompatActivity {
    LinearLayout faq;
    LinearLayout feedback;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_login);
        faq = findViewById(R.id.faq);
        feedback = findViewById(R.id.feedback);
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, FeedbackActivity.class));
            }
        });
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, LoginActivity.class));
            }
        });
    }
}
