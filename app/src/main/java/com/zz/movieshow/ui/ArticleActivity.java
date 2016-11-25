package com.zz.movieshow.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.zz.movieshow.MyApp;
import com.zz.movieshow.R;
import com.zz.movieshow.View.RotateUpTransformer;
import com.zz.movieshow.adapter.ArticleAdapter;
import com.zz.movieshow.bean.TabTextEntity;
import com.zz.movieshow.fragment.ArticleFragment;
import com.zz.movieshow.fragment.BaseFragment;
import com.zz.movieshow.uri.URI;

import java.util.ArrayList;
import java.util.List;

public class ArticleActivity extends BaseActivity {

    private ImageView articleMenu;
    private ImageView articleSearch;
    private ViewPager viewPager;
    private StringRequest request;
    private TabLayout tabLayout;
    private List<String> titles;
    private List<BaseFragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        initView();
        initFragment();
    }
    private void initView() {
        articleMenu = ((ImageView) findViewById(R.id.article_menu));
        articleSearch = ((ImageView) findViewById(R.id.article_search));
        viewPager = ((ViewPager) findViewById(R.id.article_viewpager));
        tabLayout = ((TabLayout) findViewById(R.id.tab_layout));
        tabLayout.setTabTextColors(Color.parseColor("#AEAEAE"),Color.parseColor("#272727"));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#272727"));

        titles = new ArrayList<String>();
        fragments = new ArrayList<BaseFragment>();
    }
    private void initFragment() {
        request = new StringRequest(URI.URL_TAB, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                TabTextEntity entity = gson.fromJson(response,TabTextEntity.class);
                for(int i = 0 ; i < entity.getData().size(); i ++) {
                    titles.add(entity.getData().get(i).getCatename());
                    ArticleFragment fragment = new ArticleFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("id", entity.getData().get(i).getCateid());
                    fragment.setArguments(bundle);
                  fragments.add(fragment);
                }
                viewPager.setAdapter(new ArticleAdapter(getSupportFragmentManager(), fragments, titles));
                viewPager.setPageTransformer(true, new RotateUpTransformer());
                tabLayout.setupWithViewPager(viewPager);
            }
        },null);
        request.setTag("text");
        MyApp.getApp().getQueue().add(request);
    }


    public void imageClick(View view){
        switch (view.getId()){
            case R.id.article_menu:
                startActivity(new Intent(this,LeftMenuActivity.class));
                break;
            case R.id.article_search:
                startActivity(new Intent(this,SearchActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        if(request != null){
            MyApp.getApp().getQueue().cancelAll("text");
        }
        super.onDestroy();
    }
}
