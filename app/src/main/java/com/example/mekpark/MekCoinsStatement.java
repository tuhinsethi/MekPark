package com.example.mekpark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mekpark.Adapters.mekCoinAdp;

public class MekCoinsStatement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mek_coins_statement);
        RecyclerView coinView = findViewById(R.id.recycler_mekcoins);

        int[] amt= {100,10,-10,-100,10};

        coinView.setAdapter(new mekCoinAdp(amt));

    }
}
