package com.example.mekpark.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mekpark.Activities.AwaitingParkingActivity;
import com.example.mekpark.Activities.CheckoutActivity;
import com.example.mekpark.ModelClass;
import com.example.mekpark.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewholder> {
    private Context context;
    private ArrayList<ModelClass> dataArrayList;

    public MyAdapter(Context context, ArrayList<ModelClass> dataArrayList) {
        this.context = context;
        this.dataArrayList = dataArrayList;

    }

    @NonNull
    @Override
    public MyAdapterViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_recycler, parent, false);
        return new MyAdapterViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterViewholder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), AwaitingParkingActivity.class));
            }
        });
        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // OpenFragment openFragment = new OpenFragment();
                //  AppCompatActivity activity = (AppCompatActivity) view.getContext();
                //  activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame, openFragment).addToBackStack(null).commit();
                //  Fragment otp = new OpenFragment();
                // FragmentTransaction transaction = fragmentManager.beginTransaction();
                //  transaction.replace(R.id.replace, otp);

                //  transaction.commit();
                final Dialog dialog = new Dialog(view.getContext(), android.R.style.Theme_Translucent_NoTitleBar);

                dialog.setContentView(R.layout.checkin2);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    dialog.getWindow().setStatusBarColor(context.getResources().getColor(R.color.red_dark));
                }


                ImageView imageView = dialog.findViewById(R.id.back);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Log.e("back arrow", "clickedd");
                        dialog.dismiss();
                    }
                });
                final Button gates = dialog.findViewById(R.id.gates);
                gates.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.e("open gates", "clickedd");
                        final Dialog dialog1 = new Dialog(view.getContext(), android.R.style.Theme_Translucent_NoTitleBar);

                        dialog1.setContentView(R.layout.activity_stop_parking);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            dialog1.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                            dialog1.getWindow().setStatusBarColor(context.getResources().getColor(R.color.red_dark));
                        }
                        Button stop = dialog1.findViewById(R.id.btn_stop);
                        stop.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final Dialog dialog2 = new Dialog(view.getContext(), android.R.style.Theme_Translucent_NoTitleBar);

                                dialog2.setContentView(R.layout.activity_reciept);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    dialog2.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                                    dialog2.getWindow().setStatusBarColor(context.getResources().getColor(R.color.red_dark));
                                }
                                Button pay = dialog2.findViewById(R.id.pay_btn);
                                pay.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        view.getContext().startActivity(new Intent(view.getContext(), CheckoutActivity.class));
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
        holder.reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class MyAdapterViewholder extends RecyclerView.ViewHolder {
        Button accept;
        Button reject;
        public MyAdapterViewholder(@NonNull View itemView) {
            super(itemView);
            accept = itemView.findViewById(R.id.accept);
            reject = itemView.findViewById(R.id.reject);
        }
    }
}
