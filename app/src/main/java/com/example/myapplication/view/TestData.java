package com.example.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.TestDataBindingBinding;
import com.example.myapplication.model.Test;

public class TestData extends Fragment {
    private TestDataBindingBinding testDataBinding;
    private View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        testDataBinding = DataBindingUtil.inflate(inflater, R.layout.test_data_binding, container, false);

        root = testDataBinding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        Test test = new Test("", 25, "https://img.freepik.com/free-photo/beautiful-girl-stands-near-walll-with-leaves_8353-5378.jpg?size=626&ext=jpg&ga=GA1.2.2104465169.1630195200", false);

//        testDataBinding.setTestBinding(test);
//        testDataBinding.setSimple("N/A");


    }
}