package com.example.mekpark.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.mekpark.GenericTextWatcher;
import com.example.mekpark.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OpenFragment extends Fragment {


    public OpenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.checkin2, container, false);
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
