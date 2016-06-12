package com.example.my.liwushuo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.my.liwushuo.R;
import com.example.my.liwushuo.entity.GLGroupsHead;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


/**
 * Created by Administrator on 2016/6/3.
 */
public class GongLueRecyclerAdapter extends RecyclerView.Adapter<ViewHolder.GongLueHeaderViewHolder> {

    private Context context;
    private List<GLGroupsHead.DataBean.CollectionsBean> data;
    private LayoutInflater inflater;

    public GongLueRecyclerAdapter(Context context, List<GLGroupsHead.DataBean.CollectionsBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder.GongLueHeaderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_fenlei_gonglue_head_recycler, null);
        return new ViewHolder.GongLueHeaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder.GongLueHeaderViewHolder holder, int position) {
        if (data.size()>0){
            Glide.with(context)
                    .load(data.get(position).getBannerImageUrl())
                    .bitmapTransform(new RoundedCornersTransformation(context, 20, 0,
                            RoundedCornersTransformation.CornerType.ALL))
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return data !=null?data.size():0;
    }

}
