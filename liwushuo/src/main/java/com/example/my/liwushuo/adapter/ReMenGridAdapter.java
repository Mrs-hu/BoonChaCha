package com.example.my.liwushuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.my.liwushuo.R;
import com.example.my.liwushuo.entity.Gift;

import java.util.List;

/**
 * Created by Administrator on 2016/6/1.
 */
public class ReMenGridAdapter extends BaseAdapter {

    private Context context;
    private List<Gift.DataBean.ItemsBean> data;
    private LayoutInflater inflater;

    public ReMenGridAdapter(Context context, List<Gift.DataBean.ItemsBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_remen_grid,null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.item_remen_grid_iv);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.item_remen_grid__title_tv);
            viewHolder.tvPrice = (TextView) convertView.findViewById(R.id.item_remen_grid_price_tv);
            viewHolder.tvLikes = (TextView) convertView.findViewById(R.id.item_remen_grid_likes_tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(data.get(position).getData().getCoverImageUrl()).asBitmap().placeholder(R.drawable.placeholder).into(viewHolder.imageView);


        return convertView;
    }


    private class ViewHolder {
         ImageView imageView;
         TextView tvTitle;
         TextView tvPrice;
         TextView tvLikes;
    }
}
