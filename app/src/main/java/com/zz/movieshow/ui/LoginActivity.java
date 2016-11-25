package com.zz.movieshow.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.zz.movieshow.R;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

/**
 * 第三方登录
 */
public class LoginActivity extends AppCompatActivity implements PlatformActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ShareSDK.initSDK(this);
        Platform qq = ShareSDK.getPlatform(this,QQ.NAME);
        if(qq.isValid()){
            qq.removeAccount();
        }

    }

    public void login_button(View view) {
    }

    public void loginQQ(View view) {
        loginDeal(new QQ(this));
    }
    public void loginDeal(Platform platform)
    {
        String userId = platform.getDb().getUserId();
        if(!TextUtils.isEmpty(userId))
        {//表示的已经认证过了。
            //直接跳转到成功界面
        }else
        {
            //1.要功能，不要数据
            //没有认证过，第一次去认证
            //platform.SSOSetting(true);
            //添加认证监听
            //platform.setPlatformActionListener(this);
            //去认证
            //platform.authorize();
            //2.要数据，不要功能
            platform.setPlatformActionListener(this);
            //网页认证
            platform.SSOSetting(true);

            platform.showUser(null);
        }

    }

    @Override
    public void onComplete(Platform platform, int action, HashMap<String, Object> hashMap) {
        if (action == Platform.ACTION_USER_INFOR) {
            Log.i("-----","zz");
            PlatformDb platDB = platform.getDb();//获取数平台数据DB
            //通过DB获取各种数据
            platDB.getToken();
            platDB.getUserGender();
            platDB.getUserIcon();
            platDB.getUserId();
            platDB.getUserName();
            Log.i("----",platDB.getUserIcon());
        }
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        Log.i("-----","zzz");
    }

    @Override
    public void onCancel(Platform platform, int i) {

    }
}
