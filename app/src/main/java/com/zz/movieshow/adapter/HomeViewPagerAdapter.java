package com.zz.movieshow.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zz.movieshow.fragment.BaseFragment;

import java.util.List;

/**
 * Created by zhangzhen on 2016/4/11.
 */
public class HomeViewPagerAdapter extends FragmentPagerAdapter{

    private List<BaseFragment> datas;
    private String [] title = {"最近","最热"};

    public HomeViewPagerAdapter(FragmentManager fm, List<BaseFragment> datas) {
        super(fm);
        this.datas = datas;
    }

    @Override
    public Fragment getItem(int position) {
        return datas.get(position);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
