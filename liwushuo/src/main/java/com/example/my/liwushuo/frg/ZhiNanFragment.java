package com.example.my.liwushuo.frg;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.my.liwushuo.R;
import com.example.my.liwushuo.adapter.ZhiNanAdapter;
import com.example.my.liwushuo.constant.Constant;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ZhiNanFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private List<Fragment> wData;
    @BindView(R.id.vp_jingxuan)
    public ViewPager vpW;
    @BindView(R.id.indicator)
    public TabPageIndicator tabPageIndicator;
    private ZhiNanAdapter zhiNanAdapter;

    public ZhiNanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ZhiNanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ZhiNanFragment newInstance(String param1, String param2) {
        ZhiNanFragment fragment = new ZhiNanFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
//http://api.liwushuo.com/v2/channels/101/items?ad=2&gender=1&generation=2&limit=20&offset=0
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zhi_nan, container, false);
        ButterKnife.bind(this,view);
        wData = new ArrayList<>();
        for (int i = 0; i < Constant.urlInfos.size(); i++) {
            wData.add(SimpleFragment.newInstance(Constant.urlInfos.get(i)));
        }
        zhiNanAdapter = new ZhiNanAdapter(getChildFragmentManager(),wData,Constant.urlInfos);
        vpW.setAdapter(zhiNanAdapter);
        tabPageIndicator.setViewPager(vpW);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
