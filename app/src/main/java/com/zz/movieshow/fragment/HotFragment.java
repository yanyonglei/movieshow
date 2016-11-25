package com.zz.movieshow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zz.movieshow.MyApp;
import com.zz.movieshow.R;
import com.zz.movieshow.adapter.HotAdapter;
import com.zz.movieshow.bean.HotEntity;
import com.zz.movieshow.ui.VideoActivity;
import com.zz.movieshow.uri.URI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 最热页面的展示
 * Created by wyz on 2016/4/11.
 */
public class HotFragment extends BaseFragment {
    private PullToRefreshListView listView;
    private HotAdapter adapter;
    private int page = 1 ;

    public static  HotFragment newInsterce(){
        HotFragment fragment = new HotFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hot_fragment,null);
        listView = (PullToRefreshListView) view.findViewById(R.id.listview_hot);
        adapter = new HotAdapter(new ArrayList<HotEntity.DataBean>(),getActivity());
        listView.setAdapter(adapter);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //给listview设置点击监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                intent.putExtra("postid",adapter.getItem(position).getPostid());
                startActivity(intent);
            }
        });

        //给listview 设置上拉刷新，下啦加载监听
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                adapter.clear();
                page = 1;
                loadData();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                loadData();

            }
        });

//        加载数据
        loadData();
    }

    private void loadData() {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                URI.URL_HOT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        HotEntity entity = gson.fromJson(response, HotEntity.class);
                        adapter.addAll(entity.getData());
                    }
                },
                null
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String, String> map = new HashMap<>();
                map.put("p", page+"");
                map.put("size", "10");
                map.put("tab", "hot");
                return map;
            }


        };
        request.setTag("hot");
        MyApp.getApp().getQueue().add(request);
//        加载完数据后，隐藏刷新条
        listView.onRefreshComplete();

    }

    @Override
    public void onDestroy() {
        MyApp.getApp().getQueue().cancelAll("hot");
        super.onDestroy();
    }
}
