package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.SampleItems;

import java.util.List;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder> {
    private List<SampleItems> sampleItems;
    private Context context;
    private String ClassName;

    public void setDatatoAdapter(List<SampleItems> sampleItems, Context context, String simpleName) {
        this.sampleItems = sampleItems;
        this.context = context;
        this.ClassName = simpleName;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.common_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SampleItems sampleItem = sampleItems.get(position);
        holder.bindView(sampleItem);
    }


    @Override
    public int getItemCount() {
        return sampleItems.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView subject;
        TextView date;
        TextView description;

        public ViewHolder(View itemView) {
            super(itemView);
            subject = (TextView) itemView.findViewById(R.id.subject);
            date = (TextView) itemView.findViewById(R.id.date);
            description = (TextView) itemView.findViewById(R.id.description);
        }

        public void bindView(SampleItems sampleItem) {
            subject.setText(sampleItem.getSubject());
            date.setText(sampleItem.getDate());
            description.setText(sampleItem.getDescription());
        }
    }
}
