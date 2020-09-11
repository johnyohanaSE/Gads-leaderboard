package com.jombeja.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LearningRecyclerAdapter extends RecyclerView.Adapter<LearningRecyclerAdapter.ViewHolder> {

    private ArrayList<LearningData> mListItems = new ArrayList<>();
    private Context mContext;

    public LearningRecyclerAdapter(ArrayList<LearningData> listItems, Context context) {
        this.mListItems = listItems;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.learning_fragment_items, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        LearningData listItem = mListItems.get(position);
        holder.mLearnersName.setText(listItem.getName());
        holder.mHours.setText(listItem.getTime());
        holder.mLearnerCountry.setText(listItem.getCountry());

        Picasso.get()
                .load(listItem.getLearningBadge())
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mImageView;
        public final TextView mLearnersName;
        public final TextView mHours;
        public final TextView mLearnerCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_learning_badge);
            mLearnersName = (TextView) itemView.findViewById(R.id.text_name);
            mHours = (TextView) itemView.findViewById(R.id.text_hours);
            mLearnerCountry = (TextView) itemView.findViewById(R.id.text_country);
        }
    }
}
