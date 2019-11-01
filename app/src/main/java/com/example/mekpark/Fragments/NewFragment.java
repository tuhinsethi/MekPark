package com.example.mekpark.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mekpark.Adapters.MyAdapter;
import com.example.mekpark.ModelClass;
import com.example.mekpark.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewFragment extends Fragment {
    ArrayList<ModelClass> list;

    public NewFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this LoginFragment
        list = new ArrayList<>();
        View root = inflater.inflate(R.layout.fragment_new, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.new_recycler);
        recyclerView.setAdapter(new MyAdapter(getActivity(), list));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }

}
