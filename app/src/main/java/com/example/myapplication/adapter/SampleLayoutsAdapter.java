package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.SampleItems;

import java.util.List;

public class SampleLayoutsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    final int VIEW_TYPE_ONE = 0;
    final int VIEW_TYPE_TWO = 1;
    Context context;
    List<SampleItems> layoutOne;
    List<SampleItems> layoutTwo;

    public SampleLayoutsAdapter(Context context, List<SampleItems> layoutOne, List<SampleItems> layoutTwo) {
        this.context = context;
        this.layoutOne = layoutOne;
        this.layoutTwo = layoutTwo;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_ONE){
            return new LayoutOneViewHolder(itemView);
        }

        if(viewType == VIEW_TYPE_TWO){
            return new LayoutTwoViewHolder(itemView);
        }

        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class LayoutOneViewHolder extends RecyclerView.ViewHolder{

        public LayoutOneViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class LayoutTwoViewHolder extends RecyclerView.ViewHolder{

        public LayoutTwoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

//    public class ViewHolder extends RecyclerView.ViewHolder {
//        public ViewHolder(@NonNull  View itemView) {
//            super(itemView);
//        }
//    }
}
