package com.example.my.liwushuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my.liwushuo.R;
import com.example.my.liwushuo.entity.Selection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by my on 2016/6/3.
 */
public class MyExpandAdapter extends BaseExpandableListAdapter {

    private Map<Integer,List<Selection.Data.Items>> childDataMap ;
    private List<Integer> group;
    private Context context;
    List<Selection.Data.Items> child = new ArrayList<>();

    public MyExpandAdapter(Context context,  List<Integer> group, Map<Integer, List<Selection.Data.Items>> childDataMap) {
        this.group = group;
        this.childDataMap = childDataMap;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return group == null ? 0 : group.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        child = childDataMap.get(groupPosition);
        return child == null ? 0 :child.size() ;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = convertView;
        GroupViewHolder groupViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.home_group_item_view,null);
            groupViewHolder = new GroupViewHolder(view);
        } else {
            groupViewHolder = (GroupViewHolder) view.getTag();
        }
        int integer = group.get(groupPosition);
        if(integer != 0){
            Date date = new Date(integer *1000l);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E");
            String format = sdf.format(date);
            groupViewHolder.dateText.setText(format);
        }
        else{
            groupViewHolder.dateText.setText("没拿到数据");
        }
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
       View childView = convertView;
        ChildViewHolder childViewHolder = null;
        if(childView == null){
            childView = LayoutInflater.from(context).inflate(R.layout.home_child_item_view,null);
            childViewHolder = new ChildViewHolder(childView);
        }else{
            childViewHolder = (ChildViewHolder) childView.getTag();
        }
        List<Selection.Data.Items> itemses = new ArrayList<>();

        List<Selection.Data.Items> itemses1 = childDataMap.get(group.get(groupPosition));
        if(itemses1!= null){

        itemses.addAll(itemses1);
        }

        if(itemses == null){

        childViewHolder.imageView.setImageResource(R.drawable.img14);
        }else{
            childViewHolder.imageView.setImageResource(R.drawable.img14);
//        Glide.with(context)
//                .load(itemses.get(0).getCoverImageUrl())
//                .placeholder(R.drawable.icon_picblank)
//                .error(R.drawable.btn_close_login)
//                .centerCrop()
//                .into(childViewHolder.imageView);
//        childViewHolder.tvLike.setText(itemses.get(childPosition).getLikesCount());
//        childViewHolder.tvTitle.setText(itemses.get(childPosition).getTitle());
        }
        return childView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }



class GroupViewHolder {
    @BindView(R.id.home_group_item_date_txt)
    public TextView dateText;

    public GroupViewHolder(View view) {
        view.setTag(this);
        ButterKnife.bind(this,view);
    }
}


    class ChildViewHolder {
        @BindView(R.id.child_item_img)
        public ImageView imageView;
        @BindView(R.id.home_child_likecount_tv)
        public TextView tvLike;
        @BindView(R.id.chile_item_title_tv)
        public TextView tvTitle;

        public ChildViewHolder(View view) {
            view.setTag(this);
            ButterKnife.bind(this,view);
        }

        @OnClick(R.id.child_item_img)
        public void click(View view) {
            Toast.makeText(context, "click", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(getActivity(),DetailsActivity.class);
//            startActivity(intent);
        }
    }
}