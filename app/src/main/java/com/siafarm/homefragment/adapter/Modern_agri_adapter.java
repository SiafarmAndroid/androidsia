package com.siafarm.homefragment.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.siafarm.R;
import com.siafarm.homefragment.model.modern_agri_data;

import java.util.List;

public class Modern_agri_adapter extends RecyclerView.Adapter<Modern_agri_adapter.MyViewHolder> {

    private List<modern_agri_data> cardList;
    private Context myActivity;
    private int pos = -1;

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView date;
        TextView number;
        LinearLayout linear_layout;


        MyViewHolder(View view) {
            super(view);
            date =  view.findViewById(R.id.img_profile);
            number =  view.findViewById(R.id.validdate);
            linear_layout =  view.findViewById(R.id.linear_layout);

        }
    }

    public Modern_agri_adapter(List<modern_agri_data> cardList, Context context) {
        this.cardList = cardList;
        this.myActivity = context;
    }

    @Override
    public Modern_agri_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.modern_agri_adapter_layout, parent, false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return new Modern_agri_adapter.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final Modern_agri_adapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        modern_agri_data cardDetails = cardList.get(position);

        holder.number.setText(" " + cardDetails.getName());
        // Loading profile image
        Glide.with(myActivity).load(cardDetails.getDrawable())
                .crossFade()
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.date);

        holder.linear_layout.setTag(position);
        if (position != pos) {
            holder.linear_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    pos = position;
                    Log.e("Recycle Click", "Recycle Click" + position);
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }
}