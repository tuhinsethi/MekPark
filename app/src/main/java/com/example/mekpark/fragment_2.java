package com.example.mekpark;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment_2 extends Fragment {
    public fragment_2() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_otp, container, false);
        Button enter = root.findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CheckinActivity.class);
                startActivity(intent);
            }
        });
        EditText et1 = root.findViewById(R.id.et1);
        EditText et2 = root.findViewById(R.id.et2);
        EditText et3 = root.findViewById(R.id.et3);
        EditText et4 = root.findViewById(R.id.et4);
        EditText et5 = root.findViewById(R.id.et5);
        EditText et6 = root.findViewById(R.id.et6);

        et1.addTextChangedListener(new GenericTextWatcher(et2, et1));
        et2.addTextChangedListener(new GenericTextWatcher(et3, et1));
        et3.addTextChangedListener(new GenericTextWatcher(et4, et2));
        et4.addTextChangedListener(new GenericTextWatcher(et5, et3));
        et5.addTextChangedListener(new GenericTextWatcher(et6, et4));
        et6.addTextChangedListener(new GenericTextWatcher(et6, et5));

        return root;
    }
}
