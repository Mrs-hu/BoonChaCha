package com.example.my.liwushuo.frg;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.my.liwushuo.R;
import com.example.my.liwushuo.adapter.FenLeiAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FenLeiFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{


    private OnFragmentInteractionListener mListener;

    @BindView(R.id.fenlei_tool_bar)
    Toolbar mToolbar;
    @BindView(R.id.fenlei_tool_bar_rg)
    RadioGroup mRadioGroup;
    @BindView(R.id.fenlei_tool_bar_rb1)
    RadioButton mRadioButton1;
    @BindView(R.id.fenlei_tool_bar_rb2)
    RadioButton mRadioButton2;
    @BindView(R.id.fenlei_vp)
    ViewPager mViewPager;

    private List<Fragment> fragments = new ArrayList<>();

    private FenLeiAdapter pagerAdapter;

    public FenLeiFragment() {
        // Required empty public constructor
    }


    public static FenLeiFragment newInstance() {
        FenLeiFragment fragment = new FenLeiFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fen_lei, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mToolbar.inflateMenu(R.menu.menu_main);
        pagerAdapter = new FenLeiAdapter(getChildFragmentManager(), fragments);
        mViewPager.setAdapter(pagerAdapter);
        initData();
        pagerAdapter.notifyDataSetChanged();
        mRadioGroup.setOnCheckedChangeListener(this);
        mRadioButton1.setChecked(true);
        mViewPager.addOnPageChangeListener(this);
    }

    private void initData() {
        fragments.add(GoLueFragment.newInstance());
        fragments.add(GiftFragment.newInstance());
    }

    public void onButtonPressed(int uri) {
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
//        else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.fenlei_tool_bar_rb1:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.fenlei_tool_bar_rb2:
                mViewPager.setCurrentItem(1);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton childAt = (RadioButton) mRadioGroup.getChildAt(position);
        childAt.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
