package com.zz.movieshow.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zz.movieshow.fragment.BaseFragment;

import java.util.List;

/**
 * Created by zhangzhen on 2016/4/12.
 */
public class ArticleAdapter extends FragmentPagerAdapter{
    private List<BaseFragment> fragments;
    private List<String> titles;

    public ArticleAdapter(FragmentManager fm, List<BaseFragment> fragments, List<String> titles) {
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
