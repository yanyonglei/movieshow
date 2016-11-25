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
import com.zz.movieshow.MyApp;
import com.zz.movieshow.R;
import com.zz.movieshow.adapter.SerDatailfragmentAdapter;
import com.zz.movieshow.bean.SerDatailEntity;
import com.zz.movieshow.bean.SerDatailiItemEnyity;
import com.zz.movieshow.ui.WebViewActivity;
import com.zz.movieshow.uri.URI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wyz on 2016/4/13.
 */
public class SerDatailContentFragment extends BaseFragment {
    private ListView listView;
    int position;
    String seriesid;
    private SerDatailfragmentAdapter adapter;

    public static SerDatailContentFragment newInsterce(){
        SerDatailContentFragment fragment = new SerDatailContentFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position");
//        Log.i("info",position+"++++++");
        seriesid = getArguments().getString("seriesid");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_serdatail_linear, null);
        listView = (ListView) view.findViewById(R.id.listview_linear_serdatail);

        adapter = new SerDatailfragmentAdapter(new ArrayList<SerDatailiItemEnyity>(),getActivity());
        listView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LoadData();

    }

    private void LoadData() {

//        position = getArguments().getInt("position");
//        position = 3;

//        seriesid = getArguments().getString("seriesid");
//        seriesid = 45+"";
        StringRequest request = new StringRequest(
                Request.Method.POST,
                URI.URL_SERDATAIL,
                new Response.Listener<String>() {
                    private SerDatailEntity entity;

                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        entity = gson.fromJson(response, SerDatailEntity.class);
                        ArrayList<SerDatailiItemEnyity> itemEnyities = new ArrayList<>();

                        for (int i = 0; i < entity.getData().getPosts().get(position).getList().size(); i++) {

                            SerDatailiItemEnyity itemEnyity = new SerDatailiItemEnyity();
                            String title = entity.getData().getPosts().get(position).getList().get(i).getTitle();
                            String image_path = entity.getData().getPosts().get(position).getList().get(i).getThumbnail();
                            String time = entity.getData().getPosts().get(position).getList().get(i).getAddtime();
                            String path = entity.getData().getPosts().get(position).getList().get(i).getSource_link();
                            itemEnyity.setTitle(title);
                            itemEnyity.setImage_path(image_path);
                            itemEnyity.setTime(time);
                            itemEnyity.setPath(path);
                            itemEnyities.add(itemEnyity);
                        }
                        Log.i("11111",itemEnyities.size()+"");

                        adapter.addAll(itemEnyities);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String path = adapter.getItem(position).getPath();
                                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                                intent.putExtra("path",path);
                                startActivity(intent);
                            }
                        });
                    }
                },
                null
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String, String> map = new HashMap<>();


                map.put("seriesid", seriesid);
                return map;
            }


        };
        request.setTag("serdatayil");

        MyApp.getApp().getQueue().add(request);
    }
    @Override
    public void onDestroy() {
        MyApp.getApp().getQueue().cancelAll("serdatayil");

        super.onDestroy();
    }
}
