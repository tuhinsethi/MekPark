package com.example.mekpark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewholder> {
    private Context context;
    private ArrayList<ModelClass> dataArrayList;

    MyAdapter(Context context, ArrayList<ModelClass> dataArrayList) {
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

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class MyAdapterViewholder extends RecyclerView.ViewHolder {
        public MyAdapterViewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
