package com.example.mekpark.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mekpark.Fragments.OpenFragment;
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
        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenFragment openFragment = new OpenFragment();
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame, openFragment).addToBackStack(null).commit();
                //  Fragment otp = new OpenFragment();
                // FragmentTransaction transaction = fragmentManager.beginTransaction();
                //  transaction.replace(R.id.replace, otp);

                //  transaction.commit();
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
