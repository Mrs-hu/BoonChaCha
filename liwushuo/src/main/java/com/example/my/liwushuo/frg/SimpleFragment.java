package com.example.my.liwushuo.frg;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.alibaba.fastjson.JSON;
import com.example.my.liwushuo.R;
import com.example.my.liwushuo.adapter.MyExpandAdapter;
import com.example.my.liwushuo.constant.Constant;
import com.example.my.liwushuo.entity.Selection;
import com.example.my.liwushuo.httputils.IOkTaskCallback;
import com.example.my.liwushuo.httputils.OkHttpTask;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends BaseFragment {

    String path = "http://api.liwushuo.com/v2/channels/101/items?ad=2&gender=1&generation=2&limit=20&offset=0";
    private String json;
    private Selection selection = null;
    private List<Selection.Data.Items> itemData = new ArrayList<>();
    private Map<Integer, List<Selection.Data.Items>> groupOne = new HashMap<>();
    private int size = 0;
    private List<Integer> group = new ArrayList<>();

    private float oneDay = 86400000;

    private Context mContext;

    @BindView(R.id.selected_expand_listview)
    PullToRefreshExpandableListView mExpandListView;

    private MyExpandAdapter mExpandAdapter;

    public SimpleFragment() {
        // Required empty public constructor
    }

    public static SimpleFragment newInstance(Constant.UrlInfo url) {

        Bundle args = new Bundle();

        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple, container, false);
        ButterKnife.bind(this, view);
        setupExpandListView();

        return view;
    }

    private void setupExpandListView() {
        mExpandAdapter = new MyExpandAdapter(mContext, group, groupOne);
        //从可刷新控件中拿到listview
        ExpandableListView refreshableView = mExpandListView.getRefreshableView();

        refreshableView.setAdapter(mExpandAdapter);
        initData();


//        //设置所有的GroupItem全部展开
//        for (int i = 0; i < groupOne.size(); i++) {
//            refreshableView.expandGroup(i);
//        }
//        //设置ExpandableListView的GroupItem点击事件失效
//        refreshableView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//                return true;
//            }
//        });

    }


    public void initData() {
        OkHttpTask.newInstance(mContext).enqueue(new IOkTaskCallback() {
            @Override
            public void onSuccess(String result) {
                json = result;
                selection = JSON.parseObject(json, Selection.class);
                if (selection != null) {
                    size = selection.getData().getItems().size();
                    if (size != 0) {
                        itemData.addAll(selection.getData().getItems());
                        initGroupData();
                    }
                }
            }
        }).start(path);

    }

    private void initGroupData() {
//        int publishedAt = 0;
//        int temp = 0;
//        int[] a = new int[size];
//        for (int i = 0; i < size; i++) {
//            publishedAt = selection.getData().getItems().get(i).getPublishedAt();
//            if(publishedAt != 0){
////                temp = publishedAt;
//                a[i] = publishedAt;
//            }
//
//        }
//        for (int i = 0; i < a.length; i++) {
//            if (i == 0){
//                group.add(a[0]);
//            }else if (!group.contains(a[i])){
//                group.add(a[i]);
//            }
//        }
//        List<Selection.Data.Items> tempList = new ArrayList<>();
//        for (int i = 0; i < group.size(); i++) {
//            for (int j = 0; j < size; j++) {
//
//                publishedAt = selection.getData().getItems().get(j).getPublishedAt();
//                if (publishedAt == group.get(i)) {
//                    itemData.clear();
//                    itemData.add(selection.getData().getItems().get(j));
//                    tempList.addAll(itemData);
//                }
//            }
//            groupOne.put(i, tempList);
//            tempList.clear();
//        }
        for (int i = 0; i < 2; i++) {
            group.add(itemData.get(i).getPublishedAt());
            List<Selection.Data.Items> tempList = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                tempList.add(itemData.get(j));
            }
            groupOne.put(i,tempList);
        }

        mExpandAdapter.notifyDataSetChanged();
    }
}
