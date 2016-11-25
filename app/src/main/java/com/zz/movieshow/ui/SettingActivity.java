package com.zz.movieshow.ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.zz.movieshow.MyApp;
import com.zz.movieshow.R;

/**
 * 设置窗体的界面
 */
public class SettingActivity extends AppCompatActivity {

    private TextView textView_cache;
    private ImageView imageview_allowdowload;
    private boolean isCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        textView_cache = ((TextView) findViewById(R.id.textview_cache));
        imageview_allowdowload = ((ImageView) findViewById(R.id.imageview_allowdownload));

        long usableSpace = ImageLoader.getInstance().getDiskCache().getDirectory().getUsableSpace();
        Log.i("----", usableSpace + "");
        Log.i("----", MyApp.cache + "");
        if ((usableSpace - MyApp.cache) < 1024) {
            textView_cache.setText("0.01");
        } else if ((usableSpace - MyApp.cache) < 2048) {
            textView_cache.setText("0.02");
        } else {
            double cache = (usableSpace - MyApp.cache) / 1024 / 1024;

            Log.i("----", cache + "");
            String result = String.format("%.2f", cache);
            getSupportActionBar().setTitle("设置");

            textView_cache.setText(result);
        }

    }


    public void feedback(View view) {
        startActivity(new Intent(this,FeedBackActivity.class));

    }

    public void ClearCache(View view) {

        textView_cache.setText(0 + "");
        ImageLoader.getInstance().clearMemoryCache();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("清理完毕");
        builder.show();

    }

    public void allowofflinecachedirtory(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("请选择存储路径");
        View view1 = LayoutInflater.from(this).inflate(R.layout.dialog_cachedirtory,null);
        builder.setView(view1);
        builder.show();
        isCheck = true;


    }

    public void comment(View view) {
    }

    public void version(View view) {
    }

    public void sharefriend(View view) {
    }

    public void takecareof(View view) {
    }

    public void addQQ(View view) {
    }

    public void takecareofus(View view) {
    }

    public void noduty(View view) {
    }

    public void allownowifi(View view) {
        if(isCheck){
            imageview_allowdowload.setImageResource(R.drawable.btn_checked);
            isCheck = false;
        }else{
            imageview_allowdowload.setImageResource(R.drawable.btn_check);
            isCheck = true;
        }


    }
}
