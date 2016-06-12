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
import com.example.my.liwushuo.entity.GLGroups;

import java.util.List;

/**
 * Created by Administrator on 2016/6/3.
 */
public class GongLueGridAdapter extends BaseAdapter {

    private Context context;
    private List<GLGroups.DataBean.ChannelGroupsBean.ChannelsBean> data;
    private LayoutInflater inflater;

    public GongLueGridAdapter(Context context, List<GLGroups.DataBean.ChannelGroupsBean.ChannelsBean> data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
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
            convertView = inflater.inflate(R.layout.item_fenlei_expend_child_grid, null);
            viewHolder = new ViewHolder();
            viewHolder.childImage = (ImageView) convertView.findViewById(R.id.child_iv);
            viewHolder.childName = (TextView) convertView.findViewById(R.id.child_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.childName.setText(data.get(position).getName());
        Glide.with(context)
                .load(data.get(position).getIconUrl())
                .asBitmap()
                .into(viewHolder.childImage);
        return convertView;
    }

    private class ViewHolder {
        private ImageView childImage;
        private TextView childName;
    }
}
