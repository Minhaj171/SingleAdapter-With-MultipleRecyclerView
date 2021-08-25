package com.example.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.SampleAdapter;
import com.example.myapplication.databinding.FragmentMainBinding;
import com.example.myapplication.model.SampleItems;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {
    FragmentMainBinding fragmentMainBinding;
    View root;
    private static final String TAG = MainFragment.class.getSimpleName();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentMainBinding = DataBindingUtil.inflate(inflater ,  R.layout.fragment_main, container, false);

        root = fragmentMainBinding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configureLayoutOne();
    }

    private void configureLayoutOne() {
        SampleAdapter sampleAdapter = new SampleAdapter();
        fragmentMainBinding.recyclerViewOne.setAdapter(sampleAdapter);
        fragmentMainBinding.recyclerViewOne.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        List<SampleItems> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItems("Bangla", "Jan 22, 2021", "Jannah is the Muslim concept of heaven or paradise, where good and faithful Muslims go after Judgment Day. Jannah is a beautiful, peaceful garden where water flows and abundant food and drink are served to the dead and their families. Jannah has eight gates"));
        sampleItems.add(new SampleItems("English", "Jan 21, 2021", "Jannah is the Muslim concept of heaven or paradise, where good and faithful Muslims go after Judgment Day. Jannah is a beautiful, peaceful garden where water flows and abundant food and drink are served to the dead and their families. Jannah has eight gates"));
        sampleItems.add(new SampleItems("Arabic", "May 2, 2021", "Jannah is the Muslim concept of heaven or paradise, where good and faithful Muslims go after Judgment Day. Jannah is a beautiful, peaceful garden where water flows and abundant food and drink are served to the dead and their families. Jannah has eight gates"));
        sampleItems.add(new SampleItems("Urdu", "April 22, 2021", "Jannah is the Muslim concept of heaven or paradise, where good and faithful Muslims go after Judgment Day. Jannah is a beautiful, peaceful garden where water flows and abundant food and drink are served to the dead and their families. Jannah has eight gates"));

        sampleAdapter.setDatatoAdapter(sampleItems, getContext(), MainFragment.class.getSimpleName());
    }
}