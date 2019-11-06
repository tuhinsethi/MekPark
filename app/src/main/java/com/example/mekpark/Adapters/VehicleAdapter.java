package com.example.mekpark.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mekpark.R;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.programmingViewHolder> {

     private Context context;
    private String[] data;
    private int [] Imageid;
    public VehicleAdapter(String [] data, int[] Imageid){

        this.Imageid=Imageid;
        this.data=data;
    }

    @NonNull
    @Override
    public programmingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.list_items_layout,parent,false);

        return new programmingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull programmingViewHolder holder, int position) {


        String Vehicle= data[position];
        holder.VehicleName.setText(Vehicle);

        int img= Imageid[position];
        holder.ImgVehicle.setId(img);



    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class programmingViewHolder extends RecyclerView.ViewHolder{
        ImageView ImgVehicle;
        TextView VehicleName , VehicleNumber;

        public programmingViewHolder(@NonNull View itemView) {
            super(itemView);
            ImgVehicle= (ImageView) itemView.findViewById(R.id.ImgVehicle);
            VehicleName= (TextView) itemView.findViewById(R.id.VehicleName);
            VehicleNumber= (TextView) itemView.findViewById(R.id.VehicleNumber);
        }
    }
}
