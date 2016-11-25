package com.zz.movieshow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
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
import com.zz.movieshow.adapter.SeriesAdapter;
import com.zz.movieshow.bean.SeriesEntity;
import com.zz.movieshow.uri.URI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 系列界面的activity
 */
public class SeriesActivity extends BaseActivity {
    private PullToRefreshListView  listView;
    private SeriesAdapter adapter;
    private int page = 1;
    private ImageView seriesMenu;
    private ImageView seriesSearch;
    private SeriesEntity entity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);
        seriesMenu = ((ImageView) findViewById(R.id.series_menu));
        seriesSearch = ((ImageView) findViewById(R.id.series_search));
        listView = (PullToRefreshListView) findViewById(R.id.listview_series);
        adapter = new SeriesAdapter(new ArrayList<SeriesEntity.DataBean>(),this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SeriesActivity.this,SeiesDatailsActivity.class);
                intent.putExtra("seriesid",adapter.getItem(position-1).getSeriesid());
                startActivity(intent);
            }
        });




        listView.setMode(PullToRefreshBase.Mode.BOTH);
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

        loadData();
    }

    private void loadData() {

        StringRequest request = new StringRequest(
                Request.Method.POST,
                URI.URL_SERIES,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        entity = gson.fromJson(response, SeriesEntity.class);
                        Log.i("info--", entity.getData().size() + "");
                        adapter.addAll(entity.getData());
                        Log.i("info--", adapter.getCount() + "");




                    }
                },
                null

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String, String> map = new HashMap<>();
                map.put("p", page+"");
                map.put("size", "10");

                return map;
            }


        };
        request.setTag("series");
        MyApp.getApp().getQueue().add(request);
//        加载完数据后，隐藏刷新条
        listView.onRefreshComplete();
    }

    public void imageClick(View view){
        switch (view.getId()){
            case R.id.series_menu:
                startActivity(new Intent(this,LeftMenuActivity.class));
                break;
            case R.id.series_search:
                startActivity(new Intent(this,SearchActivity.class));
                break;
        }
    }
    @Override
    public void onDestroy() {
        MyApp.getApp().getQueue().cancelAll("series");
        super.onDestroy();
    }

}
