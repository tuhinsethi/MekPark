package com.example.mekpark.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mekpark.ModelClass;
import com.example.mekpark.R;

import java.util.ArrayList;

public class OngoingAdapter extends RecyclerView.Adapter<OngoingAdapter.OngoingViewholder> {
    private Context context;
    private ArrayList<ModelClass> dataArrayList;

    public OngoingAdapter(Context context, ArrayList<ModelClass> dataArrayList) {
        this.context = context;
        this.dataArrayList = dataArrayList;
    }

    @NonNull
    @Override
    public OngoingViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ongoing_recycler, parent, false);
        return new OngoingViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OngoingViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class OngoingViewholder extends RecyclerView.ViewHolder {
        public OngoingViewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
