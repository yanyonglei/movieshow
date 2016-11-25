package com.zz.movieshow.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zz.movieshow.R;

/**
 * 左侧按钮窗口Activity
 */
public class LeftMenuActivity extends AppCompatActivity {

    /**
     *单选组
     */
    private RadioGroup radiogroup_choose;
    /**
     * 单选按钮数组
     */
    private RadioButton[] radioButtons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_menu);
        initeView();//初始化组件
    }

    private void initeView() {

        radiogroup_choose = ((RadioGroup) findViewById(R.id.radiogroup_choose));
        //初始化单选按钮的数组
        radioButtons = new RadioButton[radiogroup_choose.getChildCount()];

        for (int i = 0; i < radiogroup_choose.getChildCount(); i++) {
            radioButtons[i]= ((RadioButton) radiogroup_choose.getChildAt(i));
        }

        //设置单选按钮文本颜色以及默认可点击
        radioButtons[0].setTextColor(Color.parseColor("#ffffff"));
        radioButtons[0].setEnabled(true);

        //单选按钮的点击事件
        radiogroup_choose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               if (radioButtons[0].getId()==checkedId){
                   replece(0);
                   startActivity(new Intent(getApplication(),MainActivity.class));
               }
                if (radioButtons[1].getId()==checkedId){
                    replece(1);
                    startActivity(new Intent(getApplication(),ChannelActivity.class));

                }
                if (radioButtons[2].getId()==checkedId){
                    replece(2);
                    startActivity(new Intent(getApplication(),SeriesActivity.class));

                }
                if (radioButtons[3].getId()==checkedId){
                    replece(3);
                    startActivity(new Intent(getApplication(),ArticleActivity.class));

                }

                finish();


            }

//            单选按钮文本颜色以及默认可点击
            private void replece(int tarPosition) {

                for (int i = 0; i < radioButtons.length; i++) {
                    radioButtons[i].setTextColor(Color.parseColor("#848484"));
                }
                radioButtons[tarPosition].setTextColor(Color.parseColor("#ffffff"));
                radioButtons[tarPosition].setChecked(true);
            }
        });


    }

    //各个点击事件
    public void setting(View view) {
        startActivity(new Intent(getApplication(),SettingActivity.class));
    }

    public void login(View view) {
        startActivity(new Intent(getApplication(),LoginActivity.class));

    }

    public void message(View view) {
        startActivity(new Intent(getApplication(),LoginActivity.class));
    }

    public void Myorder(View view) {
        startActivity(new Intent(getApplication(),LoginActivity.class));
    }

    public void offlinecache(View view) {
        startActivity(new Intent(getApplication(),MyCacheActivity.class));
    }

    public void Mylove(View view) {
        startActivity(new Intent(getApplication(),LoginActivity.class));
    }

    public void closeActivity(View view) {
        finish();
    }

}
