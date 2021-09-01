package com.example.myapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ItemClickListener;
import com.example.myapplication.adapter.SampleAdapter;
import com.example.myapplication.adapter.SingleAdapter;
import com.example.myapplication.databinding.FragmentMainBinding;
import com.example.myapplication.model.BaseModel;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {
    private FragmentMainBinding fragmentMainBinding;
    private View root;
    private static final String TAG = MainFragment.class.getSimpleName();
    private ArrayList<BaseModel> baseModels = new ArrayList<>();
    public SingleAdapter adapter;


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
//        singleItemConfiguration();
        configureRecyclerViewMain();
    }

    private void configureRecyclerViewMain() {

        SampleAdapter sampleAdapter = new SampleAdapter();
        fragmentMainBinding.recyclerViewOne.setAdapter(sampleAdapter);
        fragmentMainBinding.recyclerViewOne.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        List<BaseModel> sampleItems = new ArrayList<>();
        sampleItems.add(new BaseModel("Bangla", "Jan 22, 2021", "Jannah is the Muslim concept of heaven or paradise, where good and faithful Muslims go after Judgment Day. Jannah is a beautiful, peaceful garden where water flows and abundant food and drink are served to the dead and their families. Jannah has eight gates"));
        sampleItems.add(new BaseModel("English", "Jan 21, 2021", "Jannah is the Muslim concept of heaven or paradise, where good and faithful Muslims go after Judgment Day. Jannah is a beautiful, peaceful garden where water flows and abundant food and drink are served to the dead and their families. Jannah has eight gates"));
        sampleItems.add(new BaseModel("Arabic", "May 2, 2021", "Jannah is the Muslim concept of heaven or paradise, where good and faithful Muslims go after Judgment Day. Jannah is a beautiful, peaceful garden where water flows and abundant food and drink are served to the dead and their families. Jannah has eight gates"));
        sampleItems.add(new BaseModel("Urdu", "April 22, 2021", "Jannah is the Muslim concept of heaven or paradise, where good and faithful Muslims go after Judgment Day. Jannah is a beautiful, peaceful garden where water flows and abundant food and drink are served to the dead and their families. Jannah has eight gates"));

        sampleAdapter.setDatatoAdapter(sampleItems, getContext(), MainFragment.class.getSimpleName());

//        LinearLayoutManager layoutManager = ((LinearLayoutManager)fragmentMainBinding.recyclerViewOne.getLayoutManager());
//        fragmentMainBinding.recyclerViewOne.setVerticalScrollbarPosition(recyclerPosition);

    }

    private void singleItemConfiguration(){
        fragmentMainBinding.recyclerViewOne.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        adapter = new SingleAdapter(getContext(), baseModels);

        fragmentMainBinding.recyclerViewOne.setAdapter(adapter);

//        createList();

        fragmentMainBinding.showItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.getSelected() != null){
                    Toast.makeText(getContext(), adapter.getSelected().getSubject(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "No selection", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

//    private void createList() {
//        baseModels = new ArrayList<>();
//        for (int i = 0 ; i < 20 ; i ++){
//            BaseModel baseModel = new BaseModel();
//            baseModel.setSubject("Minhaj" + (i+1));
//            baseModels.add(baseModel);
//        }
//        adapter.SetBaseModel(baseModels);
//
//    }


}