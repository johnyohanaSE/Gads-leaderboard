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

public class IqRecyclerAdapter extends RecyclerView.Adapter<IqRecyclerAdapter.ViewHolder> {

    private ArrayList<SkilliqData> mIqListItems = new ArrayList<>();
    private Context mContext;

    public IqRecyclerAdapter(ArrayList<SkilliqData> iqListItems, Context context) {
        mIqListItems = iqListItems;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.iq_fragment_items, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkilliqData iqlistItem = mIqListItems.get(position);
        holder.mName.setText(iqlistItem.getName());
        holder.mIq.setText(iqlistItem.getIq());
        holder.mCountry.setText(iqlistItem.getCountry());

        Picasso.get()
                .load(iqlistItem.getScoreBadge())
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mIqListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mImageView;
        public final TextView mName;
        public final TextView mIq;
        public final TextView mCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_iq_badge);
            mName = (TextView) itemView.findViewById(R.id.text_name_iq);
            mIq = (TextView) itemView.findViewById(R.id.text_iq);
            mCountry = (TextView) itemView.findViewById(R.id.text_country_iq);
        }
    }
}
