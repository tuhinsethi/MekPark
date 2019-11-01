package com.example.mekpark.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mekpark.Fragments.OTP_Fragment;
import com.example.mekpark.R;

public class LoginActivity extends AppCompatActivity {
    Button proceed;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_2);

        proceed = findViewById(R.id.proceed);
        back = findViewById(R.id.red_arrow);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment otp = new OTP_Fragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.replace, otp);

                transaction.commit();
            }
        });
    }


}
