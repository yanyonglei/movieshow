package com.zz.movieshow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
import com.zz.movieshow.adapter.LatestListViewAdapter;
import com.zz.movieshow.bean.LatestEntity;
import com.zz.movieshow.uri.URI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChannelVideoActivity extends AppCompatActivity {

    private String cateId;
    private PullToRefreshListView pullToFresh_channel;
    private LatestListViewAdapter adapter;
    private int page =1;
    private LatestEntity latestEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_video);
        Intent intent = getIntent();
        cateId = intent.getStringExtra("cateId");
        getSupportActionBar().hide();
        pullToFresh_channel = ((PullToRefreshListView) findViewById(R.id.pulltorefresh_channellist));

        adapter = new LatestListViewAdapter(new ArrayList<LatestEntity.DataBean>(),getApplicationContext());
        pullToFresh_channel.setAdapter(adapter);
        pullToFresh_channel.setMode(PullToRefreshBase.Mode.BOTH);
        pullToFresh_channel.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
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

       pullToFresh_channel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//               List<LatestEntity.DataBean> data = latestEntity.getData();
//               LatestEntity.DataBean dataBean = data.get(position-1);
               LatestEntity.DataBean item = adapter.getItem(position - 1);
               String postid = item.getPostid();

               Intent intent1 = new Intent(getApplication(), VideoActivity.class);

               intent1.putExtra("postid",postid);

               startActivity(intent1);
           }
       });
        loadData();

    }
    private void loadData() {
        StringRequest request = new StringRequest(Request.Method.POST, URI.URL_CHANNEL_LIST, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                latestEntity = gson.fromJson(response,LatestEntity.class);
                adapter.addAll(latestEntity.getData());

            }
        },null){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String>map = new HashMap<>();
                map.put("p",(page++)+"");
                map.put("size",10+"");
                map.put("cateid",cateId);
                return map;

            }
        };
        request.setTag("channellist");
        MyApp.getApp().getQueue().add(request);
    }

    @Override
    protected void onDestroy() {
        MyApp.getApp().getQueue().cancelAll("channellist");
        super.onDestroy();
    }
}
