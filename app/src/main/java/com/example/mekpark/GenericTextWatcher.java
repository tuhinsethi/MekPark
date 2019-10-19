package com.example.mekpark;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class GenericTextWatcher implements TextWatcher {
    private EditText etPrev;
    private EditText etNext;

    public GenericTextWatcher(EditText etNext, EditText etPrev) {
        this.etPrev = etPrev;
        this.etNext = etNext;
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        {
            // TODO Auto-generated method stub
            String text = editable.toString();

            if (text.length() == 1)
                etNext.requestFocus();
            else if (text.length() == 0)
                etPrev.requestFocus();

        }


    }


}

