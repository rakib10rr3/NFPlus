package com.rakib.nfplus.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rakib.nfplus.R;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private Context mContext;
    List<HashMap<String, String>> newsList;
    CustomTabsIntent.Builder builder;
    CustomTabsIntent customTabsIntent;

    int mode;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnailImageView;

        public MyViewHolder(View view) {
            super(view);
            thumbnailImageView = view.findViewById(R.id.img_news_img);
        }
    }


    public NewsAdapter(Context mContext, List<HashMap<String, String>> newsList) {
        this.mContext = mContext;
        this.newsList = newsList;

        builder = new CustomTabsIntent.Builder();
        customTabsIntent = builder.build();
        builder.setToolbarColor(mContext.getResources().getColor(R.color.colorPrimary));

    }

    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_news_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        // loading album cover using Glide library
        Glide.with(mContext).load(newsList.get(position).get("img")).into(holder.thumbnailImageView);

        holder.thumbnailImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext, movies.getName(), Toast.LENGTH_SHORT).show();
                Logger.d(newsList.get(position).get("name"));
                customTabsIntent.launchUrl(mContext, Uri.parse(newsList.get(position).get("link")));

            }
        });
    }


    @Override
    public int getItemCount() {
        return newsList.size();
    }
}