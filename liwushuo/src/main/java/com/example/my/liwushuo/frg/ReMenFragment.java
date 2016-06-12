package com.example.my.liwushuo.frg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.my.liwushuo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReMenFragment extends Fragment {


    public static final String REMEN_PATH = "http://api.liwushuo.com/v2/items?gender=1&limit=20&offset=0&generation=2";
    @BindView(R.id.remen_tool_bar)
    Toolbar mToolbar;

    private ReMenGridFragment remenGridFragment;

    private FragmentManager childFragmentManager;

    public ReMenFragment() {
    }

    public static ReMenFragment newInstance() {
        ReMenFragment fragment = new ReMenFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_re_men, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpToolBar();
        childFragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = childFragmentManager.beginTransaction();
        if (remenGridFragment == null) {
            remenGridFragment = ReMenGridFragment.newInstance(REMEN_PATH);
            fragmentTransaction.add(R.id.remen_fl, remenGridFragment);
        } else {
            fragmentTransaction.show(remenGridFragment);
        }
        fragmentTransaction.commit();
    }

    private void setUpToolBar() {
        mToolbar.inflateMenu(R.menu.menu_main);
    }

}
