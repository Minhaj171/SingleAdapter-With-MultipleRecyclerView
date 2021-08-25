package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.BaseModel;

import java.util.List;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder> {
    private List<BaseModel> sampleItems;
    private Context context;
    private String className;

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

        public void bindView(BaseModel sampleItem) {
            subject.setText(sampleItem.getSubject());
            date.setText(sampleItem.getDate());
            description.setText(sampleItem.getDescription());

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
