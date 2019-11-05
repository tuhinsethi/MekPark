package com.example.mekpark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mekpark.Adapters.VehicleAdapter;

public class MyVehicles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_vehicles);
        RecyclerView VehicleList = (RecyclerView) findViewById(R.id.recycler_vehicle);
        VehicleList.setLayoutManager(new LinearLayoutManager(this));

        String []Carnames= {"Wagon R","Bajaj Pulsor","Hundai i20","KTM Duke"};
        int []Imageid={R.drawable.wagonr,R.drawable.pulsor,R.drawable.i20,R.drawable.duke};
        VehicleList.setAdapter(new VehicleAdapter(Carnames,Imageid));

    }
}
