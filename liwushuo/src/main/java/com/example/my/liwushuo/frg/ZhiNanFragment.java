package com.example.my.liwushuo.frg;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.example.my.liwushuo.R;
import com.example.my.liwushuo.adapter.ZhiNanAdapter;
import com.example.my.liwushuo.entity.Channer;
import com.example.my.liwushuo.httputils.IOkTaskCallback;
import com.example.my.liwushuo.httputils.OkHttpTask;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ZhiNanFragment extends BaseFragment {




    private OnFragmentInteractionListener mListener;

    private List<Fragment> wData;

    @BindView(R.id.tb_zhinan)
    Toolbar mToolBar;
    @BindView(R.id.vp_jingxuan)
    public ViewPager vpW;
    @BindView(R.id.indicator_zhinan)
    public TabPageIndicator tabPageIndicator;

    private Channer channer = null;
    private List<Channer.DataBean.ChannelsBean> channerData = new ArrayList<>();
    private ZhiNanAdapter zhiNanAdapter;

    public static final String CHANNER_PATH = "http://api.liwushuo.com/v2/channels/preset?gender=1&generation=2";

    public ZhiNanFragment() {
        // Required empty public constructor
    }


    public static ZhiNanFragment newInstance() {
        ZhiNanFragment fragment = new ZhiNanFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
//http://api.liwushuo.com/v2/channels/101/items?ad=2&gender=1&generation=2&limit=20&offset=0
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zhi_nan, container, false);
        ButterKnife.bind(this,view);

        setupTollBar();

        wData = new ArrayList<>();
        wData.clear();
        channerData.clear();
        OkHttpTask.newInstance(getContext()).enqueue(new IOkTaskCallback() {
            @Override
            public void onSuccess(String result) {

                channer = JSON.parseObject(result, Channer.class);
                if(channer != null){
                channerData.addAll(channer.getData().getChannels());
                    for (int i = 0; i < channerData.size(); i++) {
                        String newPath = "http://api.liwushuo.com/v2/channels/"+channerData.get(i).getId()+"/items?gender=1&limit=20&offset=0&generation=2";
                        wData.add(SimpleFragment.newInstance(newPath, i));
                    }

                    zhiNanAdapter = new ZhiNanAdapter(getChildFragmentManager(),wData, channerData);
                    vpW.setAdapter(zhiNanAdapter);
                    tabPageIndicator.setViewPager(vpW);
                }

            }
        }).start(CHANNER_PATH);


        return view;
    }


    public void setupTollBar(){
        mToolBar.setTitle("");
        mToolBar.setNavigationIcon(R.drawable.btn_signin);
        mToolBar.inflateMenu(R.menu.menu_main);
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
//          else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}
