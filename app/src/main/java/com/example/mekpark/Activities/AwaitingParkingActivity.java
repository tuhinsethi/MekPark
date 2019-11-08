package com.example.mekpark.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mekpark.GenericTextWatcher;
import com.example.mekpark.R;

public class AwaitingParkingActivity extends AppCompatActivity {
    Button reject;
    Button accept;
    FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkin3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_arrow);
        reject = findViewById(R.id.reject);

        accept = findViewById(R.id.accept);

        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startActivity(new Intent(AwaitingParkingActivity.this, OpenActivity.class));

                final Dialog dialog = new Dialog(AwaitingParkingActivity.this, android.R.style.Theme_Translucent_NoTitleBar);

                dialog.setContentView(R.layout.checkin2);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    dialog.getWindow().setStatusBarColor(getResources().getColor(R.color.red_dark));
                }
                //generic text watcher
                EditText et1 = dialog.findViewById(R.id.pin1);
                EditText et2 = dialog.findViewById(R.id.pin2);
                EditText et3 = dialog.findViewById(R.id.pin3);
                EditText et4 = dialog.findViewById(R.id.pin4);

                et1.addTextChangedListener(new GenericTextWatcher(et2, et1));
                et2.addTextChangedListener(new GenericTextWatcher(et3, et1));
                et3.addTextChangedListener(new GenericTextWatcher(et4, et2));
                et4.addTextChangedListener(new GenericTextWatcher(et4, et3));


                ImageView imageView = dialog.findViewById(R.id.back);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                Button start = dialog.findViewById(R.id.gates);
                start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Dialog dialog1 = new Dialog(view.getContext(), android.R.style.Theme_Translucent_NoTitleBar);

                        dialog1.setContentView(R.layout.activity_stop_parking);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            dialog1.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                            dialog1.getWindow().setStatusBarColor(getResources().getColor(R.color.red_dark));
                        }
                        ImageView back = dialog1.findViewById(R.id.back);

                        back.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog1.dismiss();
                            }
                        });
                        Button stop = dialog1.findViewById(R.id.btn_stop);
                        stop.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final Dialog dialog2 = new Dialog(view.getContext(), android.R.style.Theme_Translucent_NoTitleBar);

                                dialog2.setContentView(R.layout.activity_reciept);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    dialog2.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                                    dialog2.getWindow().setStatusBarColor(getResources().getColor(R.color.red_dark));
                                }
                                Button pay = dialog2.findViewById(R.id.pay_btn);
                                pay.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        startActivity(new Intent(AwaitingParkingActivity.this, CheckoutActivity.class));
                                    }
                                });

                                dialog2.show();
                            }
                        });
                        dialog1.show();

                    }
                });


                dialog.show();
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.checkin_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
