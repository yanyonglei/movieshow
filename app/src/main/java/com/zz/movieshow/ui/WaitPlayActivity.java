package com.zz.movieshow.ui;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.zz.movieshow.R;
import com.zz.movieshow.widget.VerticalSeekBar;

public class WaitPlayActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{
    private VideoView videoView;
    private GestureDetector gestureDetector;
    private float inSampleSize;
    private ImageView imageView_1, imageView_2;
    //音量控制,初始化定义
    private AudioManager mAudioManager;
    private int width;
    private int curBrightness;
    private VerticalSeekBar lightSeekBar;
    private int curProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait_play);
        videoView = ((VideoView) findViewById(R.id.videoView));
        gestureDetector = new GestureDetector(this, this);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        width = getWindowManager().getDefaultDisplay().getWidth();
        lightSeekBar = ((VerticalSeekBar) findViewById(R.id.seekBar_light_id));

        lightSeekBar.setMax(255);
        changeAppBrightness(128);
        lightSeekBar.setProgress(128);

        try {
            inSampleSize = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }


        //接受传送过来的数据
        String playUrl = getIntent().getStringExtra("playUrl");
//        String title = getIntent().getStringExtra("title");
//        String description = getIntent().getStringExtra("description");
//        String category = getIntent().getStringExtra("category");
//        String duration = getIntent().getStringExtra("duration");
//        String collectionCount = getIntent().getStringExtra("collectionCount");
//        String shareCount = getIntent().getStringExtra("shareCount");
//        String replyCount = getIntent().getStringExtra("replyCount");
//        String feed = getIntent().getStringExtra("feed");
//
//        String x=feed+playUrl+title+description+category+duration+collectionCount+
//                shareCount+replyCount;
//        Toast.makeText(WaitPlayActivity.this, ""+x, Toast.LENGTH_SHORT).show();

        videoView.setVideoPath(playUrl);
        videoView.setMediaController(new MediaController(this));
        videoView.start();
        videoView.getDuration();

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {

        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        if (e1.getY() > e2.getY() + 50.0f) {                 //上滑
            inSampleSize += 20;
            curBrightness += 2;
            if(curBrightness<=30){
                curBrightness=30;
            }
            if (e1.getX() < width / 2) {
                voiceUp(inSampleSize);
            } else {
                changeAppBrightness(curBrightness);
            }
        } else if (e1.getY() + 50.0f < e2.getY()) {          //下滑
            inSampleSize -= 20;
            curBrightness -= 2;
            if(curBrightness>=255){
                curBrightness=255;
            }
            if (e1.getX() < width / 2) {
                voiceDown(inSampleSize);
            } else {
                changeAppBrightness(curBrightness);
            }
        }

        if(e1.getX()+30.0f<e2.getX()){              //右滑
            curProgress+=1000;
            chagngeProgress(curProgress);
        }else if(e1.getX()>e2.getX()+30.0f){        //左滑
            curProgress-=2500;
            chagngeProgress(curProgress);
        }

        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    //音量   +
    void voiceUp(float inSampleSize) {
        mAudioManager.adjustStreamVolume(
                AudioManager.STREAM_MUSIC,
                AudioManager.ADJUST_RAISE,
                AudioManager.FX_FOCUS_NAVIGATION_UP);
    }

    //音量   -
    void voiceDown(float inSampleSize) {
        mAudioManager.adjustStreamVolume(
                AudioManager.STREAM_MUSIC,
                AudioManager.ADJUST_LOWER,
                AudioManager.FX_FOCUS_NAVIGATION_UP);
    }


    // 根据亮度值修改当前window亮度
    public void changeAppBrightness(int curBrightness) {
        lightSeekBar.setProgress(curBrightness);

        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        if (curBrightness == -1) {
            lp.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE;
        } else {
            lp.screenBrightness = (curBrightness <= 0 ? 1 : curBrightness) / 255f;
        }
        window.setAttributes(lp);
    }

    void chagngeProgress(int curPosition){
        videoView.seekTo(curPosition);
    }

}

