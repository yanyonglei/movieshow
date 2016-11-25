package com.zz.movieshow.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.zz.movieshow.R;

/***
 * WelcomeActivity 欢迎界面
 */
public class WelcomeActivity extends AppCompatActivity {


    private static final int GOTO_MAIN_ACTIVITY = 0;  //跳转到MainActivity的标志
    private static final int GOTO_GUIDE_ACTIVITY = 1;  //跳转到GuidActivty的标志
    private boolean mFirst;                          //判断是否是头次应用的进入
    private Handler mHandler;     //信息传递机制
    private static final String SHAREDPREFERENCES_NAME = "my_share";

    private Handler handler = new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GOTO_MAIN_ACTIVITY:

                    Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case GOTO_GUIDE_ACTIVITY:

                    Intent intent2 = new Intent(WelcomeActivity.this,GuideActivity.class);
                    startActivity(intent2);
                    finish();
                    break;

                default:
                    break;
            }
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = LayoutInflater.from(this).inflate(R.layout.activity_welcome, null);
        setContentView(rootView);
        mHandler = new Handler();


        //缩放动画
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);

        //设置动画监听事件
        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //当监听到动画结束时，开始跳转到MainActivity 窗口
                mHandler.post(new Runnable() {//开启线程

                    @Override
                    public void run() {
                        mFirst = isFirstEnter();
                        if(!mFirst){
                            handler.sendEmptyMessage(GOTO_MAIN_ACTIVITY);

                        }
                        else{
                            handler.sendEmptyMessage(GOTO_GUIDE_ACTIVITY);
                        }
                    }
                });
            }
        });

        //开始播放动画
        rootView.startAnimation(animation);
    }

    private boolean isFirstEnter() {
        SharedPreferences sPreferences = getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
        if("false".equals(sPreferences.getString("key", "true"))){//判断是否为第一次进入
            return false;
        }
        return true;
    }
}
