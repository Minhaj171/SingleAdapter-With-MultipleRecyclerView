package com.example.myapplication.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

public class SampleLayoutTwo extends Fragment {
    View view;
    RecyclerView layoutTwo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.sample_layout_two, container, false);

        layoutTwo = view.findViewById(R.id.recyclerView_two);

        configureLayoutTwo();

        return view;
    }

    private void configureLayoutTwo(){


    }
}