package com.example.mekpark.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.mekpark.Activities.CompletionActivity;
import com.example.mekpark.GenericTextWatcher;
import com.example.mekpark.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class OpenFragment extends Fragment {
    Button open;
    TabLayout tabLayout;

    public OpenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.checkin2, container, false);
        open = root.findViewById(R.id.gates);
        // tabLayout=root.findViewById(R.id.tabs);
        // tabLayout.setVisibility(View.GONE);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CompletionActivity.class));
            }
        });

        EditText et1 = root.findViewById(R.id.pin1);
        EditText et2 = root.findViewById(R.id.pin2);
        EditText et3 = root.findViewById(R.id.pin3);
        EditText et4 = root.findViewById(R.id.pin4);

        et1.addTextChangedListener(new GenericTextWatcher(et2, et1));
        et2.addTextChangedListener(new GenericTextWatcher(et3, et1));
        et3.addTextChangedListener(new GenericTextWatcher(et4, et2));
        et4.addTextChangedListener(new GenericTextWatcher(et4, et3));
        // FrameLayout frame=root.findViewById(R.id.frame);
        return root;
    }

}
