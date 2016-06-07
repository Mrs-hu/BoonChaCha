package com.example.my.liwushuo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.my.liwushuo.constant.Constant;

import java.util.List;

/**
 * Created by my on 2016/5/31.
 */
public class ZhiNanAdapter extends FragmentStatePagerAdapter{
    private List<Constant.UrlInfo> urlInfos;
    private List<Fragment> data;
    public ZhiNanAdapter(FragmentManager fm,List<Fragment> data,List<Constant.UrlInfo> urlInfos) {
        super(fm);
        this.data =data;
        this.urlInfos = urlInfos;
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
        return this.urlInfos.get(position).getTitle();
    }
}
