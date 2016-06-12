package com.example.my.liwushuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.my.liwushuo.R;
import com.example.my.liwushuo.entity.GLGroups;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/6/1.
 */
public class GongLueExpendAdapter extends BaseExpandableListAdapter {

    private List<GLGroups.DataBean.ChannelGroupsBean> groupData;

    private Context context;

    private GongLueGridAdapter adapter;
    

    public GongLueExpendAdapter(Context context, List<GLGroups.DataBean.ChannelGroupsBean> groupData) {
        this.context = context;
        this.groupData = groupData;
    }

    @Override
    public int getGroupCount() {
        return groupData != null ? groupData.size() : 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        List<GLGroups.DataBean.ChannelGroupsBean.ChannelsBean> channels = groupData.get(groupPosition).getChannels();
        if (channels.size() > (channels.size() / 4) * 4) {
            return (channels.size() / 4) + 1;
        } else {
            return channels.size() / 4;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupData != null ? groupData.get(groupPosition) : null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupData.get(groupPosition).getChannels() != null ? groupData.get(groupPosition).getChannels().get(childPosition) : null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupData != null ? groupPosition : 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupData.get(groupPosition).getChannels() != null ? childPosition : 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fenei_gonglue_group, null);
            groupViewHolder = new GroupViewHolder(convertView);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.groupNameTv.setText(groupData.get(groupPosition).getName());
        return convertView;
    }

    class GroupViewHolder {

        @BindView(R.id.group_name_tv)
        TextView groupNameTv;

        public GroupViewHolder(View view) {
            view.setTag(this);
            ButterKnife.bind(this, view);
        }

    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fenlei_gonglue_child, null);
            childViewHolder = new ChildViewHolder(convertView);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        List<GLGroups.DataBean.ChannelGroupsBean.ChannelsBean> channels = new ArrayList<>();
        List<GLGroups.DataBean.ChannelGroupsBean.ChannelsBean> channels1 = groupData.get(groupPosition).getChannels();
        channels.clear();
        //这样算，第二行3个时，
        if (channels1.size() >=(childPosition+1)*4){
            for (int i = childPosition*4; i < (childPosition + 1) * 4; i++) {
                channels.add(channels1.get(i));
            }
        }else {
            for (int i = childPosition*4; i < channels1.size(); i++) {
                channels.add(channels1.get(i));
            }
        }
        adapter = new GongLueGridAdapter(context, channels);
        childViewHolder.childGridView.setAdapter(adapter);

        return convertView;
    }

    class ChildViewHolder {

        @BindView(R.id.child_grid_view)
        GridView childGridView;

        public ChildViewHolder(View view) {
            view.setTag(this);
            ButterKnife.bind(this, view);
        }

    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
