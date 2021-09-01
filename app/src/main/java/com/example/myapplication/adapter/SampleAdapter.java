package com.example.myapplication.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Layout;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.BaseModel;

import java.util.List;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder> {
    private List<BaseModel> sampleItems;
    private Context context;
    private String className;
    private int selecteditem = 0;


    public void setDatatoAdapter(List<BaseModel> sampleItems, Context context, String simpleName) {
        this.sampleItems = sampleItems;
        this.context = context;
        this.className = simpleName;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.common_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BaseModel sampleItem = sampleItems.get(position);
        holder.bindView(sampleItem);
//        holder.configureCheckItem();

//        if (selecteditem == position) {
//            holder.itemView.setSelected(true); //using selector drawable
//            holder.check.setVisibility(View.VISIBLE);
//        } else {
//            holder.itemView.setSelected(false);
//            holder.check.setVisibility(View.GONE);
//        }
//
//        holder.itemView.setOnClickListener(v -> {
//            if (selecteditem >= 0)
//                notifyItemChanged(selecteditem);
//            selecteditem = holder.getAdapterPosition();
//            notifyItemChanged(selecteditem);
//        });

        if(selecteditem==position){
            holder.check.setVisibility(View.VISIBLE);
        }
        else{
            holder.check.setVisibility(View.INVISIBLE);

        }



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecteditem=position;
                holder.check.setVisibility(View.VISIBLE);
                notifyDataSetChanged();
            }
        });


    }


    @Override
    public int getItemCount() {
        return sampleItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView subject;
        TextView date;
        TextView description;
        ImageView check;
        RelativeLayout itemLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            subject =  itemView.findViewById(R.id.subject);
            date =  itemView.findViewById(R.id.date);
            description = itemView.findViewById(R.id.description);
            check = itemView.findViewById(R.id.check_mark);
            itemLayout = itemView.findViewById(R.id.item_layout_view);
        }

        public void bindView(BaseModel sampleItem) {
            subject.setText(sampleItem.getSubject());
            date.setText(sampleItem.getDate());
            description.setText(sampleItem.getDescription());
//            configureCheckItem(sampleItem);



        }

        private void configureCheckItem(BaseModel sampleItem) {
            if(selecteditem==getAdapterPosition()){
                check.setVisibility(View.VISIBLE);
                Toast.makeText(context.getApplicationContext(), sampleItem.getSubject(),Toast.LENGTH_SHORT).show();
            }
            else{
                check.setVisibility(View.INVISIBLE);
            }
            itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        selecteditem=getAdapterPosition();
                        check.setVisibility(View.VISIBLE);
                        Toast.makeText(context.getApplicationContext(), sampleItem.getSubject(),Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();
                }
            });

        }



//       private void setNewsCardView() {
//            if (MainFragment.class.getName().equals(className)) {
//                int position = getAdapterPosition();
//                if (position != RecyclerView.NO_POSITION) {
//                    NavController navController = Navigation.findNavController((Activity) context, R.id.nav_host_fragment);
//                    HomeFragmentDirections.ActionNavigationHomeToNewsEventDetails
//                            action = HomeFragmentDirections.actionNavigationHomeToNewsEventDetails(newsData.get(position));
//                    navController.navigate(action);
//                }
//
//            } else if (NewsAndEventFragment.class.getName().equals(className)) {
//                int position = getAdapterPosition();
//                if (position != RecyclerView.NO_POSITION) {
//                    NavController navController = Navigation.findNavController((Activity) context, R.id.nav_host_fragment);
//                    NewsAndEventFragmentDirections.ActionNewsEventsToNewsEventDetails
//                            action = NewsAndEventFragmentDirections.actionNewsEventsToNewsEventDetails(newsData.get(position));
//                    navController.navigate(action);
//                }
//            }
//        }
    }
}
