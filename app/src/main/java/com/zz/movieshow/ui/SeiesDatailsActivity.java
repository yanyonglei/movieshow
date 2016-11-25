package com.zz.movieshow.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.zz.movieshow.MyApp;
import com.zz.movieshow.R;
import com.zz.movieshow.adapter.RecycleViewAdapter;
import com.zz.movieshow.bean.SerDatailEntity;
import com.zz.movieshow.bean.SerDatailEntity2;
import com.zz.movieshow.fragment.BaseFragment;
import com.zz.movieshow.fragment.SerDatailContentFragment;
import com.zz.movieshow.uri.URI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SeiesDatailsActivity extends AppCompatActivity {
    private TextView title_item,title,attention,weekly,num,tag,content;
    private String seriesid;
    private VideoView videoView;
    private SerDatailEntity entity;
    private String series_postid;
    private TabLayout tablayout;
    private ViewPager viewpager;

//    private RecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seies_datails);
        title = (TextView) findViewById(R.id.title_serdatail);
        title_item = (TextView) findViewById(R.id.title_item_serdatail);
        attention = (TextView) findViewById(R.id.attention_serdatail);
        num = (TextView) findViewById(R.id.num_serdatail);
        weekly = (TextView) findViewById(R.id.weekly_serdatail);
        videoView = (VideoView) findViewById(R.id.videoview_serdatail);
        tag = (TextView) findViewById(R.id.tag_serdatail);
        content = (TextView) findViewById(R.id.content_serdatail);
        tablayout = (TabLayout) findViewById(R.id.tablayout_serdatail);
        viewpager = (ViewPager) findViewById(R.id.view_pager_serdatail);

        seriesid = getIntent().getStringExtra("seriesid");
//        initRecycle();
        loadData();



    }
    //配置recycleview
    private void initRecycle() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);



    }




    @Override
    protected void onResume() {
        super.onResume();
        videoView.start();

    }

    private void loadData() {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                URI.URL_SERDATAIL,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        entity = gson.fromJson(response, SerDatailEntity.class);
                        String title_item1 = entity.getData().getPosts().get(0).getList().get(0).getTitle();
                        String title1 = entity.getData().getTitle();
                        String attention1 = entity.getData().getCount_follow();
                        String week1 = entity.getData().getWeekly();
                        String num1 = entity.getData().getUpdate_to();
                        String tag1 = entity.getData().getTag_name();
                        String content1 = entity.getData().getContent();
                        title.setText(title1);
                        title_item.setText(title_item1);
                        attention.setText(attention1+"人订阅");
                        weekly.setText("更新： "+week1);
                        num.setText("集数： " + num1);
                        tag.setText("类型： " + tag1);
                        content.setText(content1);
                        series_postid = entity.getData().getPosts().get(0).getList().get(0).getSeries_postid();


                        ArrayList<BaseFragment> fragments = new ArrayList<>();
                        for (int i = 0; i < entity.getData().getPosts().size(); i++) {

                            Bundle bundle = new Bundle();
                            bundle.putInt("position", i);
//                            Log.i("info",  i+ "----");
                            bundle.putString("seriesid",seriesid);
                            SerDatailContentFragment fragment = new SerDatailContentFragment();
                            fragment.setArguments(bundle);
                            fragments.add(fragment);
                        }



                        ArrayList<String> list = new ArrayList<>();
                        for (int i = 0; i < entity.getData().getPosts().size(); i++) {
                            list.add(entity.getData().getPosts().get(i).getFrom_to());
                        }
                        RecycleViewAdapter adapter = new RecycleViewAdapter(getSupportFragmentManager(), fragments, list);
                        viewpager.setAdapter(adapter);
                        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                            @Override
                            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


                            }

                            @Override
                            public void onPageSelected(int position) {

                            }

                            @Override
                            public void onPageScrollStateChanged(int state) {

                            }
                        });
                        tablayout.setupWithViewPager(viewpager);


                        StringRequest request1 = new StringRequest(
                                Request.Method.POST,
                                URI.URL_SERIESDATAIL,
                                new Response.Listener<String>() {


                                    private SerDatailEntity2 entity2;

                                    @Override
                                    public void onResponse(String response) {
                                        Gson gson = new Gson();
                                        entity2 = gson.fromJson(response, SerDatailEntity2.class);

                                        Uri uri = Uri.parse(entity2.getData().getQiniu_url());

                                        videoView.setVideoURI(uri);
                                        MediaController controller = new MediaController(SeiesDatailsActivity.this);
                                        videoView.setMediaController(controller);

                                    }
                                },
                                null


                        ) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {

                                HashMap<String, String> map = new HashMap<>();


                                map.put("series_postid", series_postid);
                                return map;
                            }

                        };
                        request1.setTag("serdatayil1");
                        MyApp.getApp().getQueue().add(request1);




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


//        加载完数据后，隐藏刷新条

    }



    public void imageClick(View view){
        switch (view.getId()){
            case R.id.serdatal_menu:
                startActivity(new Intent(this,LeftMenuActivity.class));
                break;
            case R.id.serdatal_search:
                startActivity(new Intent(this,SearchActivity.class));
                break;
        }
    }
    @Override
    public void onDestroy() {
        MyApp.getApp().getQueue().cancelAll("serdatayil");
        MyApp.getApp().getQueue().cancelAll("serdatayil1");
        super.onDestroy();
    }
}
