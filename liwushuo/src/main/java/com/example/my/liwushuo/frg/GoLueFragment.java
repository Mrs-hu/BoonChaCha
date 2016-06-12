package com.example.my.liwushuo.frg;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.alibaba.fastjson.JSON;
import com.example.my.liwushuo.ProgressDrawableDialog;
import com.example.my.liwushuo.R;
import com.example.my.liwushuo.adapter.GongLueExpendAdapter;
import com.example.my.liwushuo.adapter.GongLueRecyclerAdapter;
import com.example.my.liwushuo.entity.GLGroups;
import com.example.my.liwushuo.entity.GLGroupsHead;
import com.example.my.liwushuo.httputils.IOkTaskCallback;
import com.example.my.liwushuo.httputils.OkHttpTask;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoLueFragment extends Fragment {

    @BindView(R.id.fenlei_gonglue_expandable_lv)
    ExpandableListView expandableListView;

    private String GONG_LUE_URL = "http://api.liwushuo.com/v2/channel_groups/all";

    private ProgressDrawableDialog mProgressDialog;

    private GongLueExpendAdapter adapter;
    private GongLueRecyclerAdapter recyclerAdapter;

    private List<GLGroups.DataBean.ChannelGroupsBean> data = new ArrayList<>();
    private List<GLGroupsHead.DataBean.CollectionsBean> headData = new ArrayList<>();

    public GoLueFragment() {
        // Required empty public constructor
    }

    public static GoLueFragment newInstance() {
        
        Bundle args = new Bundle();
        
        GoLueFragment fragment = new GoLueFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_go_lue, container, false);
        ButterKnife.bind(this, view);
        mProgressDialog = new ProgressDrawableDialog(getContext());
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addHead();
        adapter = new GongLueExpendAdapter(getContext(), data);
        expandableListView.setAdapter(adapter);
        mProgressDialog.show();
        addData();
        expandableListView.setGroupIndicator(null);
    }

    private void addHead() {
        View headView = LayoutInflater.from(getContext()).inflate(R.layout.item_fenlei_gonglue_head, null);
        RecyclerView recyclerView = (RecyclerView) headView.findViewById(R.id.category_head_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerAdapter = new GongLueRecyclerAdapter(getContext(),headData);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        addHeadData() ;
        expandableListView.addHeaderView(headView);
    }


    private void addHeadData() {
        OkHttpTask.newInstance(getContext()).enqueue(new IOkTaskCallback() {
            @Override
            public void onSuccess(String result) {
                headData.clear();
                GLGroupsHead glGroupsHead = JSON.parseObject(result,GLGroupsHead.class);
                headData.addAll(glGroupsHead.getData().getCollections());
                recyclerAdapter.notifyDataSetChanged();
            }
        }).start("http://api.liwushuo.com/v2/collections?limit=10&offset=0");
    }

    private void addData() {
        OkHttpTask.newInstance(getContext()).enqueue(new IOkTaskCallback() {
            @Override
            public void onSuccess(String result) {
                data.clear();
                GLGroups glGroups = JSON.parseObject(result, GLGroups.class);
                data.addAll(glGroups.getData().getChannelGroups());
                mProgressDialog.dismiss();
                adapter.notifyDataSetChanged();
                if (adapter != null && data.size() > 0) {
                    for (int i = 0; i < data.size(); i++) {
                        expandableListView.expandGroup(i);
                    }
                }
            }
        }).start(GONG_LUE_URL);
    }
}
