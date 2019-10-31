package com.example.mekpark.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mekpark.Adapters.HistoryAdapter;
import com.example.mekpark.ModelClass;
import com.example.mekpark.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    ArrayList<ModelClass> list;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this LoginFragment
        list = new ArrayList<>();
        View root = inflater.inflate(R.layout.fragment_history, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.hist_recycler);
        recyclerView.setAdapter(new HistoryAdapter(getActivity(), list));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;

    }

}
