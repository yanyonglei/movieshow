package com.zz.movieshow.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.zz.movieshow.MyApp;
import com.zz.movieshow.R;
import com.zz.movieshow.adapter.HomeViewPagerAdapter;
import com.zz.movieshow.fragment.BaseFragment;
import com.zz.movieshow.fragment.HotFragment;
import com.zz.movieshow.fragment.LatestFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ImageView imageMenu;
    private ImageView imageSearch;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<BaseFragment> fragments = new ArrayList<BaseFragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//初始化组件
        initFragment();//初始化碎片组成

        //viewpager设置适配器
        viewPager.setAdapter(new HomeViewPagerAdapter(getSupportFragmentManager(), fragments));
        tabLayout.setupWithViewPager(viewPager);

        //ImageLoader.getInstance().clearDiskCache();
       // ImageLoader.getInstance().getDiskCache().getDirectory().
        //图片的缓存加载



      MyApp.cache=  ImageLoader.getInstance().getDiskCache().getDirectory().getUsableSpace();

    }



    private void initView() {
        imageMenu = ((ImageView) findViewById(R.id.image_menu));
        imageSearch = ((ImageView) findViewById(R.id.image_search));
        //标题
        tabLayout = ((TabLayout) findViewById(R.id.tablayout));
        tabLayout.setTabTextColors(Color.parseColor("#555555"),Color.WHITE);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        viewPager = ((ViewPager) findViewById(R.id.viewpager_main));
    }
    private void initFragment() {
        fragments.add(LatestFragment.newInstance());
        fragments.add(HotFragment.newInsterce());
    }

    //图片的点击事件
    public void imageClick(View view){
        switch (view.getId()){
            case R.id.image_menu:
                startActivity(new Intent(this,LeftMenuActivity.class));
                break;
            case R.id.image_search:
                startActivity(new Intent(this,SearchActivity.class));
                break;
        }
    }
}
