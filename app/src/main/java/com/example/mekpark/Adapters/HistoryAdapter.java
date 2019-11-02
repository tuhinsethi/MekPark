package com.example.mekpark.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mekpark.Activities.ParkingStatusActivity;
import com.example.mekpark.ModelClass;
import com.example.mekpark.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {
    private Context context;
    private ArrayList<ModelClass> dataArrayList;

    public HistoryAdapter(Context context, ArrayList<ModelClass> dataArrayList) {
        this.context = context;
        this.dataArrayList = dataArrayList;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_recycler, parent, false);
        return new HistoryHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), ParkingStatusActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {
        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
