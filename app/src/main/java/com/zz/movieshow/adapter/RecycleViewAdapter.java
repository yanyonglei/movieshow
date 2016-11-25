package com.zz.movieshow.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zz.movieshow.fragment.BaseFragment;

import java.util.List;

/**
 * Created by wyz on 2016/4/12.
 */
public class RecycleViewAdapter extends FragmentPagerAdapter {
    private List<String> titles;


    private List<BaseFragment> fragments;

    public RecycleViewAdapter(FragmentManager fm,List<BaseFragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
