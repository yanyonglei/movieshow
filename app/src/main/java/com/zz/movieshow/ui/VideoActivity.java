package com.zz.movieshow.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zz.movieshow.MyApp;
import com.zz.movieshow.R;
import com.zz.movieshow.bean.VideoDetailsEntity;
import com.zz.movieshow.uri.URI;

import java.util.HashMap;
import java.util.Map;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class VideoActivity extends BaseActivity{

    private String postid;
    private TextView textview_title;//标题
    private TextView textview_content;//内容
    private ImageView imageview_icon;//图片
    private VideoView videoview_channel;//频道
    private ImageView imageFull;
    private  GestureDetector detector;//用户的手势检测
    private RelativeLayout layout; //相对布局
    private Handler handler = new Handler(){//消息传递机制
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            layout.setVisibility(View.GONE);//相对布局可见性关闭
        }
    };
    private LinearLayout ratingBar;
    private TextView textview_grade;//等级
    private TextView textview_catagary;//类别

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        postid = getIntent().getStringExtra("postid");


        Log.i("postid",postid);
        textview_title = ((TextView) findViewById(R.id.textview_videotitle));
        textview_content = ((TextView) findViewById(R.id.textview_videocontent));
        imageview_icon = ((ImageView) findViewById(R.id.imageview_videoimage));
        videoview_channel = ((VideoView) findViewById(R.id.videoview_channel));
        imageFull = ((ImageView) findViewById(R.id.image_full));
        layout = ((RelativeLayout) findViewById(R.id.full_layout));
        ratingBar = ((LinearLayout) findViewById(R.id.linearlayout_ratingbar));
        textview_grade = ((TextView) findViewById(R.id.textview_grade));
        textview_catagary = ((TextView) findViewById(R.id.textview_catagory));
        loadData();
    }


    private  void loadData() {
        StringRequest request = new StringRequest(Request.Method.POST, URI.URL_VIDEODETAIL, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                VideoDetailsEntity videoDetailsEntity = gson.fromJson(response, VideoDetailsEntity.class);
                String  title= videoDetailsEntity.getData().getTitle();
                String  content= videoDetailsEntity.getData().getIntro();

                if(videoDetailsEntity.getData() != null && videoDetailsEntity.getData().getRating() != null){
                    ratingBar.removeAllViews();
                    int grade =(int) ((Double.parseDouble(videoDetailsEntity.getData().getRating())+0.5)/2);
                    for(int i = 0 ; i < grade ;i++){
                        ImageView view = new ImageView(getApplication());
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
                        view.setLayoutParams(params);
                        view.setImageResource(R.drawable.ratingprogress);
                        ratingBar.addView(view);
                    }
                    for(int i = 0 ; i < 5-grade ;i++){
                        ImageView view = new ImageView(getApplication());
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
                        view.setLayoutParams(params);
                        view.setImageResource(R.drawable.ratingbackgroud);
                        ratingBar.addView(view);
                    }

                    textview_grade.setText(grade+"分");
                }


                textview_catagary.setText(videoDetailsEntity.getData().getCate().get(0));



                final String  image= videoDetailsEntity.getData().getImage();
//                Log.i("----",title);
//                Log.i("----",content);
//                Log.i("----", image);
                if(title != null){
                    textview_title.setText(title);
                }
                if(content != null){
                    textview_content.setText("     "+content);
                }
                if(image != null) {

                    DisplayImageOptions options = new DisplayImageOptions.Builder()
                            .cacheInMemory(true)
                            .cacheOnDisk(true)
                            .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                            .bitmapConfig(Bitmap.Config.RGB_565)
                            .showImageForEmptyUri(R.mipmap.ic_launcher)
                            .showImageOnFail(R.mipmap.ic_launcher)
                            .showImageOnLoading(R.mipmap.ic_launcher).build();


                    ImageLoader.getInstance().displayImage(image,
                            imageview_icon,
                            options);
                }
                final String url = videoDetailsEntity.getData().getContent().getVideo().get(0).getQiniu_url();
                if(url != null){
                    videoview_channel.setVideoURI(Uri.parse(url));
                    imageFull.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(),WaitPlayActivity.class);
                            intent.putExtra("playUrl",url);
                            startActivity(intent);
                        }
                    });
                }

                videoview_channel.setMediaController(new MediaController(VideoActivity.this));


            }
        },null){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String>map = new HashMap<>();
                map.put("postid",postid);

                return map;

            }
        };
        request.setTag("channellistvideo");
        MyApp.getApp().getQueue().add(request);
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoview_channel.start();
    }

    public void back(View view) {
        finish();
    }

    public void share(View view) {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

     // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("分享");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }
    public void likes(View view) {
    }

    public void download(View view) {
    }

    public void talk(View view) {
    }
    public void showFull(View view){
        switch (view.getId()){
            case R.id.textview_videotitle:
                layout.setVisibility(View.VISIBLE);
                handler.sendEmptyMessageDelayed(0, 3000);
                break;
            case R.id.textview_videocontent:
                layout.setVisibility(View.VISIBLE);
                handler.sendEmptyMessageDelayed(0,3000);
                break;
           case R.id.textview_catagory:
               layout.setVisibility(View.VISIBLE);
               handler.sendEmptyMessageDelayed(0,3000);
               break;
            case R.id.textview_grade:
                layout.setVisibility(View.VISIBLE);
                handler.sendEmptyMessageDelayed(0,3000);
                break;
        }
    }


    @Override
    protected void onDestroy() {
        MyApp.getApp().getQueue().cancelAll("channellistvideo");
        super.onDestroy();
    }


}
