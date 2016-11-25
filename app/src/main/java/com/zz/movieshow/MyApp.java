package com.zz.movieshow;

import android.app.Application;
import android.graphics.Typeface;
import android.os.Environment;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * Created by zhangzhen on 2016/4/11.
 */
public class MyApp extends Application{
    private static MyApp app;
    private RequestQueue queue;
    public static long cache ;
    public static Typeface mYoungHK_Xbold;

    public static MyApp getApp() {
        return app;
    }

    public RequestQueue getQueue() {
        return queue;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.app = this;
        initVolley();
        initUIL();
    }

    private void initUIL() {
        File imgcache = new File(Environment.getExternalStorageDirectory(), "imgcache");

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .threadPoolSize(3)
                .memoryCacheSize(10 << 20)
                .memoryCacheSizePercentage(12)
                .diskCacheSize(100 << 20)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                .writeDebugLogs()
                .diskCache(new UnlimitedDiskCache(imgcache)).build();
        ImageLoader.getInstance().init(configuration);
    }

    private void initVolley() {
        queue = Volley.newRequestQueue(this);
    }
}
