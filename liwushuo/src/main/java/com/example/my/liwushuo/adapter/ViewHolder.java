package com.example.my.liwushuo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.my.liwushuo.R;


/**
 * Created by Administrator on 2016/6/3.
 */

public class ViewHolder {

    public static class HomeHeaderViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public HomeHeaderViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.home_head_recycler_imv);
        }
    }

    public static class GongLueHeaderViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public GongLueHeaderViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }






}
