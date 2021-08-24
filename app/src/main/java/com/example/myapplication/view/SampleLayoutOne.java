package com.example.myapplication.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

public class SampleLayoutOne extends Fragment {
    View view;
    RecyclerView layoutOne;
//    TextView itemSubject;
//    TextView itemDate;
//    TextView itemDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.sample_layout_one, container, false);

        layoutOne = view.findViewById(R.id.recyclerView_one);

        configureLayoutOne();

        return view;
    }

    private void configureLayoutOne() {

    }


}