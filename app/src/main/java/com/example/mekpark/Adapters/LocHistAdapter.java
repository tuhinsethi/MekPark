package com.example.mekpark.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mekpark.R;

public class LocHistAdapter extends RecyclerView.Adapter<LocHistAdapter.LocHistHolder> {
    @NonNull
    @Override
    public LocHistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.loc_history_item, parent, false);
        return new LocHistHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LocHistHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class LocHistHolder extends RecyclerView.ViewHolder {
        public LocHistHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
