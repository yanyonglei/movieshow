package com.zz.movieshow.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zz.movieshow.R;
import com.zz.movieshow.adapter.GuidePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearLayout;    //点的布局容器
    private int prePosition = 0;          //记录点的位置，进行转换
    private Button goMain;                //第三个View进入主界面的按键
    private List<View> views = new ArrayList<View>();
    private static final String SHAREDPREFERENCES_NAME = "my_share";  //共享参数的名称
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();//初始化组件
    }
    private void initView() {

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        linearLayout = (LinearLayout) findViewById(R.id.liner_layout);
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        views.add(inflater.inflate(R.layout.guide_item1, null));
        views.add(inflater.inflate(R.layout.guide_item2, null));
        views.add(inflater.inflate(R.layout.guide_item3, null));

        //viewPager设置适配器
        viewPager.setAdapter(new GuidePagerAdapter(views));

        //页面改变监听事件
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            /**
             * 页面选择
             * @param  position  位置
             */
            @Override
            public void onPageSelected(int position) {

                prePosition = position;
                if (position == views.size() - 1) { //判断该位置是否是第三个view
                    goMain = (Button) findViewById(R.id.button_gomain);
                    goMain.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            //SharedPreferences 保存数据xml
                            SharedPreferences sPreferences = getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sPreferences.edit();
                            editor.putString("key", "false");
                            editor.commit();
                            Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
        viewPager.setCurrentItem(0);


    }
}
