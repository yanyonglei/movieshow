package com.zz.movieshow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
import com.zz.movieshow.adapter.ArticleListViewAdapter;
import com.zz.movieshow.bean.ArticleEntity;
import com.zz.movieshow.ui.WebViewActivity;
import com.zz.movieshow.uri.URI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangzhen on 2016/4/12.
 */
public class ArticleFragment extends BaseFragment{

    private PullToRefreshListView listView;
     private  String id;
    private ArticleListViewAdapter adapter;
    private  StringRequest request;
    private int p = 1;
    public ArticleFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getString("id");
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.artilce_fragment,null);
        listView = ((PullToRefreshListView) view.findViewById(R.id.article_listview));
        adapter = new ArticleListViewAdapter(new ArrayList<ArticleEntity.DataBean>(),getActivity());
        listView.setAdapter(adapter);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                adapter.clear();
                p = 1;
                loadData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                loadData();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("postid",adapter.getItem(position-1).getPostid());
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    private void loadData() {
       request = new StringRequest(Request.Method.POST,URI.URL_ARTICLE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                ArticleEntity entity = gson.fromJson(response,ArticleEntity.class);
                adapter.addAll(entity.getData());
            }
        }, null) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
               Map<String,String> map = new HashMap<String,String>();
                map.put( "p",(p++)+"");
                map.put("size","10");
                Log.i("----",id);
                map.put("cateid",id);

                return map;
            }
        };
        listView.onRefreshComplete();
        request.setTag("article");
        MyApp.getApp().getQueue().add(request);
    }

    @Override
    public void onDestroy() {
        if(request != null){
            MyApp.getApp().getQueue().cancelAll("article");
        }
        super.onDestroy();
    }
}
