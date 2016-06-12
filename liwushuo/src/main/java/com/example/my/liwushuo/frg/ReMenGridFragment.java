package com.example.my.liwushuo.frg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.alibaba.fastjson.JSON;
import com.example.my.liwushuo.ProgressDrawableDialog;
import com.example.my.liwushuo.R;
import com.example.my.liwushuo.adapter.ReMenGridAdapter;
import com.example.my.liwushuo.entity.Gift;
import com.example.my.liwushuo.httputils.IOkTaskCallback;
import com.example.my.liwushuo.httputils.OkHttpTask;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReMenGridFragment extends Fragment {

    private String url;

    private Gift gift = null;

    private ReMenGridAdapter adapter;

    private ProgressDrawableDialog mProgressDialog;

    @BindView(R.id.remen_gv)
    PullToRefreshGridView mPullToRefreshGridView;
    private List<Gift.DataBean.ItemsBean> data = new ArrayList<>();

    public ReMenGridFragment() {
        // Required empty public constructor
    }


    public static ReMenGridFragment newInstance(String url) {
        ReMenGridFragment fragment = new ReMenGridFragment();
        Bundle args = new Bundle();
        args.putString("url", url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString("url");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remen_grid, container, false);
        ButterKnife.bind(this, view);
        mProgressDialog = new ProgressDrawableDialog(getContext());
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new ReMenGridAdapter(getContext(), data);
        mPullToRefreshGridView.setAdapter(adapter);
        mProgressDialog.show();
        addData(url);
        mPullToRefreshGridView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefreshGridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                data.clear();
                addData(url);
                mPullToRefreshGridView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                addData(gift.getData().getPaging().getNextUrl());
                mPullToRefreshGridView.onRefreshComplete();
            }
        });
    }



    private void addData(String url) {
        OkHttpTask.newInstance(getContext()).enqueue(new IOkTaskCallback() {
            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    gift = JSON.parseObject(result, Gift.class);
                    data.addAll(gift.getData().getItems());
                    mProgressDialog.dismiss();
                    adapter.notifyDataSetChanged();
                }
            }
        }).start(url);
    }

}
