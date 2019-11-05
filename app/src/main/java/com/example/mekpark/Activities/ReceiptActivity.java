package com.example.mekpark.Activities;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mekpark.R;

public class ReceiptActivity extends AppCompatActivity {
    TextView caution;
    TextView powered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_arrow);

        caution = findViewById(R.id.caution);
        powered = findViewById(R.id.courtesy);
        String text = "Parking at owners risk. No responsibility for valuable items like Laptop, Wallet, cash etc. <font color=#000000>Lost ticket charges ₹ 20</font> after verification.";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            caution.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY));
        }
        //String text1 = "<font color=#cc0029>First Color</font> <font color=#ffcc00>Second Color</font>";
        String courtsey = "Powered by:  <font color=#000000>Mekpark.com</font>";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            powered.setText(Html.fromHtml(courtsey, Html.FROM_HTML_MODE_LEGACY));
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.receipt_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
