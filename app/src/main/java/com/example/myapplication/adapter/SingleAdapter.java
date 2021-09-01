package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.BaseModel;

import java.util.ArrayList;

public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.SingleViewHolder> {
    private Context context;
    private ArrayList<BaseModel> baseModels;
    private int checkedPosition = 0;

    public SingleAdapter (Context context, ArrayList<BaseModel> baseModels){
        this.context = context;
        this.baseModels = baseModels;
    }

    public void SetBaseModel(ArrayList<BaseModel> baseModels){
        this.baseModels = new ArrayList<>();
        this.baseModels = baseModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SingleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.common_item, parent, false);
        return new SingleViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SingleViewHolder holder, int position) {
        holder.bind(baseModels.get(position));
    }

    @Override
    public int getItemCount() {
        return baseModels.size();
    }


    class SingleViewHolder extends RecyclerView.ViewHolder{
        private TextView subject;
        private TextView date;
        private TextView description;
        private ImageView check;
        private RelativeLayout itemLayout;

        public SingleViewHolder(@NonNull View itemView) {
            super(itemView);
            subject =  itemView.findViewById(R.id.subject);
            date =  itemView.findViewById(R.id.date);
            description = itemView.findViewById(R.id.description);
            check = itemView.findViewById(R.id.check_mark);
            itemLayout = itemView.findViewById(R.id.item_layout_view);

        }
        void bind (final BaseModel baseModel){

            if (checkedPosition == -1) {
                check.setVisibility(View.GONE);
            } else {
                if (checkedPosition == getAdapterPosition()) {
                    check.setVisibility(View.VISIBLE);
                } else {
                    check.setVisibility(View.GONE);
                }
            }
            subject.setText(baseModel.getSubject());

            itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    check.setVisibility(View.VISIBLE);
                    if (checkedPosition != getAdapterPosition()) {
                        checkedPosition = getAdapterPosition();
                        notifyItemChanged(checkedPosition);
                    }

                }
            });
        }
    }

    public BaseModel getSelected(){
        if (checkedPosition != -1)
        {
            return baseModels.get(checkedPosition);
        }
        return null;
    }


}
