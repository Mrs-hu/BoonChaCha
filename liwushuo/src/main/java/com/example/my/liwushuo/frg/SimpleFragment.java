package com.example.my.liwushuo.frg;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.example.my.liwushuo.ProgressDrawableDialog;
import com.example.my.liwushuo.R;
import com.example.my.liwushuo.adapter.MyExpandAdapter;
import com.example.my.liwushuo.adapter.ViewHolder;
import com.example.my.liwushuo.entity.BannersData;
import com.example.my.liwushuo.entity.HeadRecyImage;
import com.example.my.liwushuo.entity.Selection;
import com.example.my.liwushuo.httputils.IOkTaskCallback;
import com.example.my.liwushuo.httputils.OkHttpTask;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends BaseFragment {

    private OnFragmentInteractionListener mListener;

    private String path;
    private int num;
    private Selection selection = null;
    private List<Selection.Data.Items> itemData = new ArrayList<>();
    private Map<Integer, List<Selection.Data.Items>> groupOne = new HashMap<>();
    private List<String> group =  new ArrayList<>();


    private List<String> convenientData = new ArrayList<>();
    private List<HeadRecyImage.Data.SecondaryBanners> recyclerData = new ArrayList<>();

    private ProgressDrawableDialog mProgressDialog;

    private BannersData banners = null;
    private List<BannersData.Data.BannersBean> bannersList = new ArrayList<>();
    private HeaderViewHolder headerViewHolder ;
    private MyRecyclerAdapter myRecyclerAdapter;

    private Context mContext;

    @BindView(R.id.selected_expand_listview)
    PullToRefreshExpandableListView mExpandListView;

    private ExpandableListView expandableListView;
    private MyExpandAdapter mExpandAdapter;

    public SimpleFragment() {
        // Required empty public constructor
    }


    public static SimpleFragment newInstance(String s,int i) {

        Bundle args = new Bundle();
        args.putString("path",s);
        args.putInt("num",i);
        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (getArguments()!= null){
            path = getArguments().getString("path");
            num = getArguments().getInt("num");
        }
        View view = inflater.inflate(R.layout.fragment_simple, container, false);
        ButterKnife.bind(this, view);

        mProgressDialog = new ProgressDrawableDialog(getContext());

        if(num == 0){
        setupHeaderView ();
        setupExpandListView();
            initRecyData();
        }else{
            setupExpandListView();
        }
        return view;
    }
    class MyRecyclerAdapter extends RecyclerView.Adapter<ViewHolder.HomeHeaderViewHolder> {

        @Override
        public ViewHolder.HomeHeaderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_home_head_recycler,null);

            return new ViewHolder.HomeHeaderViewHolder(view);
        }



        @Override
        public void onBindViewHolder(ViewHolder.HomeHeaderViewHolder holder, int position) {
            if (recyclerData != null) {
                Glide.with(getContext())
                        .load(recyclerData.get(position).getImageUrl())
                        .error(R.drawable.icon_picblank)
                        .placeholder(R.drawable.placeholder)
                        .bitmapTransform(new RoundedCornersTransformation(getContext(), 10,0,
                                RoundedCornersTransformation.CornerType.ALL))
                        .into(holder.imageView);
            }else{
                holder.imageView.setImageResource(R.drawable.placeholder);
            }

        }

        @Override
        public int getItemCount() {
            return recyclerData!=null&&recyclerData.size()>0 ?recyclerData.size():0;
        }
    }

    private void initRecyData() {
        recyclerData.clear();
        OkHttpTask.newInstance(getContext()).enqueue(new IOkTaskCallback() {
            @Override
            public void onSuccess(String result) {

                HeadRecyImage headRecyImage= JSON.parseObject(result, HeadRecyImage.class);
                recyclerData.addAll(headRecyImage.getData().getSecondaryBanners());

                myRecyclerAdapter.notifyDataSetChanged();
            }
        }).start("http://api.liwushuo.com/v2/secondary_banners?gender=1&generation=1");
    }

    class RecViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public RecViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView;
        }
    }

    private void setupHeaderView () {

        View headerview = LayoutInflater.from(mContext).inflate(R.layout.listview_header_view, null);

        headerViewHolder = new HeaderViewHolder(headerview);

        OkHttpTask.newInstance(getContext()).enqueue(new IOkTaskCallback() {
            @Override
            public void onSuccess(String result) {
                if(result!=null){
                    bannersList.clear();
                    convenientData.clear();
                    banners =  JSON.parseObject(result, BannersData.class);
                    if(banners!=null){
                        bannersList.addAll(banners.getData().getBanners());
                        for (int i = 0; i < bannersList.size(); i++) {
                            convenientData.add(bannersList.get(i).getImageUrl());
                            headerViewHolder.convenientBanner.setPages(new CBViewHolderCreator<MyBannerHolder>() {
                                @Override
                                public MyBannerHolder createHolder() {
                                    return new MyBannerHolder();
                                }
                            },convenientData)
                                    .setPageIndicator(new int[] {R.drawable.ic_page_indicator,R.drawable.ic_page_indicator_focused})
                                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
                        }
                    }

                }
            }
        }).start("http://api.liwushuo.com/v2/banners");

        headerViewHolder.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        myRecyclerAdapter = new MyRecyclerAdapter();
        headerViewHolder.mRecyclerView.setHasFixedSize(false);

        headerViewHolder.mRecyclerView.setAdapter(myRecyclerAdapter);

        mExpandListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ExpandableListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ExpandableListView> refreshView) {
                mExpandListView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ExpandableListView> refreshView) {
                mExpandListView.onRefreshComplete();
            }
        });
        expandableListView = mExpandListView.getRefreshableView();
        expandableListView.addHeaderView(headerview);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                return true;
            }
        });

    }

    private class MyBannerHolder implements Holder<String> {
        ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String path) {
            Glide.with(context)
                    .load(path)
                    .into(imageView);
        }
    }

    class HeaderViewHolder {
        @BindView(R.id.home_header_bannner)
        public ConvenientBanner convenientBanner;
        @BindView(R.id.home_header_recyclerview)
        public RecyclerView mRecyclerView;

        public HeaderViewHolder(View view) {
            ButterKnife.bind(this,view);
        }
    }

    private void setupExpandListView() {
        if(itemData == null){

        mProgressDialog.show();
        }
        mExpandAdapter = new MyExpandAdapter(mContext, group, groupOne);
        //从可刷新控件中拿到listview
        expandableListView = mExpandListView.getRefreshableView();

        expandableListView.setAdapter(mExpandAdapter);
        initData();



        //设置ExpandableListView的GroupItem点击事件失效
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });

    }


    public void initData() {
        itemData.clear();
        groupOne.clear();
        group.clear();
        OkHttpTask.newInstance(getContext()).enqueue(new IOkTaskCallback() {
            @Override
            public void onSuccess(String result) {
                if(result!=null){

                selection = JSON.parseObject(result, Selection.class);
                }
                if (selection != null) {

                        itemData.addAll(selection.getData().getItems());
                        String time = "";

                        for (int i = 0; i < itemData.size(); i++) {
                            int createdAt = itemData.get(i).getCreatedAt();
                            Date date = new Date(Long.valueOf(createdAt) *1000l);
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E");
                            time = sdf.format(date);
                            if (!group.contains(time)) {
                                group.add(time);
                            }
                        }

                        for (int i = 0; i < group.size(); i++) {

                            List<Selection.Data.Items> tempList = new ArrayList<>();

                            for (int j = 0; j < itemData.size(); j++) {
                            int createdAt = itemData.get(j).getCreatedAt();
                                 Date date = new Date(Long.valueOf(createdAt) *1000l);
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E");
                                time = sdf.format(date);
                                if(time.equals(group.get(i))){
                                    tempList.add(itemData.get(j));
                                }
                            }
                            groupOne.put(i,tempList);
                        }
                }
                mProgressDialog.dismiss();
                mExpandAdapter.notifyDataSetChanged();

        //设置所有的GroupItem全部展开
        for (int i = 0; i < groupOne.size(); i++) {
            expandableListView.expandGroup(i);
        }
            }
        }).start(path);

    }

    @Override
    public void onResume() {
        super.onResume();
        if(headerViewHolder != null){
            headerViewHolder.convenientBanner.startTurning(3000);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(headerViewHolder != null){
            headerViewHolder.convenientBanner.stopTurning();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
