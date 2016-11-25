package com.zz.movieshow.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by zhangzhen on 2016/4/11.
 */
public class LatestViewPagerAdapter extends PagerAdapter{
    private List<View> datas;

    public LatestViewPagerAdapter(List<View> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(datas.get(position));
        return datas.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      //  super.destroyItem(container, position, object);
        container.removeView(datas.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
