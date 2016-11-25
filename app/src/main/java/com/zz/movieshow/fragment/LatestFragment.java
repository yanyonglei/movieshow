package com.zz.movieshow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zz.movieshow.MyApp;
import com.zz.movieshow.R;
import com.zz.movieshow.adapter.LatestListViewAdapter;
import com.zz.movieshow.adapter.LatestViewPagerAdapter;
import com.zz.movieshow.bean.LatestEntity;
import com.zz.movieshow.bean.ViewPagerEntity;
import com.zz.movieshow.ui.VideoActivity;
import com.zz.movieshow.uri.URI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhen on 2016/4/11.
 */
public class LatestFragment extends BaseFragment{
    /**
     * 下拉刷新列表
     */
    private PullToRefreshListView pullToRefreshListView;

    private ViewPager viewPager;
    private StringRequest request;
    /**
     * 线性布局
     */
    private LinearLayout layout;
    private List<View> views;
    /**
     * 当前的位置
     */
    private int perPosition;
    private LatestListViewAdapter adapter;

    private StringRequest listViewRequest;
    private boolean flag;
    private int page = 1;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1 :
                    if (viewPager.getCurrentItem()<views.size()-1){
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }else if (viewPager.getCurrentItem()==views.size()-1){
                        viewPager.setCurrentItem(0);
                    }
                    break;
            }
        }
    };



    public static LatestFragment newInstance() {

        LatestFragment fragment = new LatestFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.latest_fragment, null);
        flag = true;
        perPosition = 0;
        initView(view);//初始化组件
        initViewPager();//初始化ViewPager
        loadData();
        return view;
    }

    private void initView(View view) {
        pullToRefreshListView = ((PullToRefreshListView) view.findViewById(R.id.listview_latest));
        adapter = new LatestListViewAdapter(new ArrayList<LatestEntity.DataBean>(),getActivity());
        pullToRefreshListView.setAdapter(adapter);


        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,400);
        View header = LayoutInflater.from(getActivity()).inflate(R.layout.latest_viewpager, pullToRefreshListView, false);
        header.setLayoutParams(layoutParams);

        layout = ((LinearLayout) header.findViewById(R.id.linear_layout));
        viewPager = ((ViewPager) header.findViewById(R.id.latest_viewpager));

        //获取下拉刷新列表
        ListView lv = pullToRefreshListView.getRefreshableView();

        lv.addHeaderView(header);
        views = new ArrayList<View>();

        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
       //下拉刷新监听事件
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            /**
             * 向下
             */
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page = 1;
                adapter.clear();
                loadData();//加载数据
            }

            @Override
            /**
             * 向上
             */
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                loadData();
            }
        });
        //子目录点击事件
        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), VideoActivity.class);
                intent.putExtra("postid",adapter.getItem(position-2).getPostid());
                //窗口的跳转
                startActivity(intent);
            }
        });

    }


    private void initViewPager() {
        request = new StringRequest(URI.URL_VIEWPAGER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final ViewPagerEntity entity = gson.fromJson(response,ViewPagerEntity.class);
                for(int i = 0 ; i <entity.getData().size(); i++){
                    ImageView view = new ImageView(getActivity());
                    view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ImageLoader.getInstance().displayImage(entity.getData().get(i).getImage(), view);

                    view.setClickable(true);//可点击
                    final int finalI = i;
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String postid =  entity.getData().get(finalI).getExtra().substring(43,49);

                            Intent intent = new Intent(getActivity(), VideoActivity.class);
                            intent.putExtra("postid",postid);
                            startActivity(intent);
                        }
                    });
                    //增加子view
                    views.add(view);

                    TextView textView = new TextView(getActivity());
                    textView.setText("");
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(40,5);
                    params.setMargins(20,0,0,0);
                    textView.setLayoutParams(params);
                    textView.setBackgroundResource(R.drawable.text_selector);
                    textView.setEnabled(false);

                    layout.addView(textView);
                }
                viewPager.setAdapter(new LatestViewPagerAdapter(views));
                viewPager.setCurrentItem(0);
                layout.getChildAt(0).setEnabled(true);
            }
        },null);
        //开启多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    try {
                        Thread.sleep(5000);
                        handler.sendEmptyMessage(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        }).start();



        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                 layout.getChildAt(perPosition).setEnabled(false);
                  layout.getChildAt(position).setEnabled(true);
                perPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        request.setTag("viewPager");
        MyApp.getApp().getQueue().add(request);
    }


    private void loadData() {
        listViewRequest = new StringRequest(Request.Method.POST, URI.LATEST_LISTVIEW, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
              LatestEntity entity = gson.fromJson(response,LatestEntity.class);
                adapter.addAll(entity.getData());
            }
        },null){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put("p",(page++)+"");
                map.put("size","10");
                map.put("tab","latest");
                return map;
            }
        };
        pullToRefreshListView.onRefreshComplete();
        listViewRequest.setTag("listview");
        MyApp.getApp().getQueue().add(listViewRequest);

    }


    @Override
    public void onDestroy() {
        if(request != null){
            MyApp.getApp().getQueue().cancelAll("viewPager");
        }
        if(listViewRequest != null){
            MyApp.getApp().getQueue().cancelAll("listview");
        }
        super.onDestroy();
    }
}
