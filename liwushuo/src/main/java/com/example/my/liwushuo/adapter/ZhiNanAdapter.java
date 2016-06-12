package com.example.my.liwushuo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.my.liwushuo.entity.Channer;

import java.util.List;

/**
 * Created by my on 2016/5/31.
 */
public class ZhiNanAdapter extends FragmentStatePagerAdapter{
    private List<Fragment> data;
    private List<Channer.DataBean.ChannelsBean> channerData;
    public ZhiNanAdapter(FragmentManager fm,List<Fragment> data,List<Channer.DataBean.ChannelsBean> channerData) {
        super(fm);
        this.data =data;
        this.channerData = channerData;
    }

    @Override
    public Fragment getItem(int position) {
        return this.data!=null?this.data.get(position):null;
    }

    @Override
    public int getCount() {
        return this.data!=null?this.data.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.channerData.get(position).getName();
    }
}
