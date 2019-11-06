package com.example.mekpark.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.mekpark.Activities.AwaitingParkingActivity;
import com.example.mekpark.Activities.ErrorActivity;
import com.example.mekpark.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Checkin extends Fragment {

    private Button error;
    private Button start;

    public Checkin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this LoginFragment
        View root = inflater.inflate(R.layout.activity_start_parking, container, false);
        error = root.findViewById(R.id.btn_err);
        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ErrorActivity.class));
            }
        });
        start = root.findViewById(R.id.btn_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getActivity(), NavActivity.class));
                // FragmentManager fragmentManager = getFragmentManager();
                //  Fragment otp = new OpenFragment();
                // FragmentTransaction transaction = fragmentManager.beginTransaction();
                //  transaction.replace(R.id.replace, otp);

                //  transaction.commit();
                startActivity(new Intent(getActivity(), AwaitingParkingActivity.class));
            }
        });
        return root;
    }

}
