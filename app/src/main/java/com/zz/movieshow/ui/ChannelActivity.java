package com.zz.movieshow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.zz.movieshow.MyApp;
import com.zz.movieshow.R;
import com.zz.movieshow.adapter.ChannelRecycleViewAdapter;
import com.zz.movieshow.bean.ChannelEntity;
import com.zz.movieshow.uri.URI;

import java.util.ArrayList;

public class ChannelActivity extends AppCompatActivity {

    private RecyclerView recycleview_channel;
    private ChannelRecycleViewAdapter adapter;
    ChannelEntity channelEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
        recycleview_channel = ((RecyclerView) findViewById(R.id.recycleview_channel));
        getSupportActionBar().hide();


        //固定 recyclerView 的大小
        recycleview_channel.setHasFixedSize(true);
        //设置增删动画
        recycleview_channel.setItemAnimator(new DefaultItemAnimator());
        //设置布局管理器
        recycleview_channel.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        adapter = new ChannelRecycleViewAdapter(new ArrayList<ChannelEntity.DataBean>(), getApplicationContext(), new ChannelRecycleViewAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                ChannelEntity.DataBean dataBean = channelEntity.getData().get(position);
                String cateid = dataBean.getCateid();
                Intent intent = new Intent(getApplication(), ChannelVideoActivity.class);
                intent.putExtra("cateId",cateid);
                getSupportActionBar().setTitle("爱情");

                startActivity(intent);


            }
        }
        );
        recycleview_channel.setAdapter(adapter);
        loadData();




    }

    private void loadData() {
        StringRequest request = new StringRequest(Request.Method.POST,URI.URL_CHANNEL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                channelEntity = gson.fromJson(response, ChannelEntity.class);
                adapter.addAll(channelEntity.getData());

            }
        },null);
        request.setTag("channel");
        MyApp.getApp().getQueue().add(request);
    }

    @Override
    protected void onDestroy() {
        MyApp.getApp().getQueue().cancelAll("channel");
        super.onDestroy();
    }

    public void imageClick(View view) {
        startActivity(new Intent(getApplication(),LeftMenuActivity.class));
    }

    public void search(View view) {
         startActivity(new Intent(getApplication(),SearchActivity.class));
    }
}
