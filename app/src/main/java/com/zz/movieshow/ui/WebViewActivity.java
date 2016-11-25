package com.zz.movieshow.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.zz.movieshow.MyApp;
import com.zz.movieshow.R;
import com.zz.movieshow.bean.DetailBean;
import com.zz.movieshow.uri.URI;

import java.util.HashMap;
import java.util.Map;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private String postid;
    private StringRequest request;
    private  String uri;
    private ProgressDialog dialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = ((WebView) findViewById(R.id.webview_id));
        webViewInit();
        if(getIntent().getStringExtra("path") != null){
            uri = getIntent().getStringExtra("path");
            loadUrl(uri);
        }else if(getIntent().getStringExtra("postid") != null){
            postid = getIntent().getStringExtra("postid");
            loadData();
        }

    }

    private void loadData() {
        request = new StringRequest(Request.Method.POST, URI.URL_DETAIL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                DetailBean bean = gson.fromJson(response,DetailBean.class);
                uri = bean.getData().getShare_link().getSweibo();
               loadUrl(uri);
            }
        },null){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("postid",postid);
                return map;
            }
        };
        request.setTag("request");
        MyApp.getApp().getQueue().add(request);
    }

    private void webViewInit() {
        WebSettings settings = webView.getSettings();
        // 支持js语言
        settings.setJavaScriptEnabled(true);
        // 设置支持页面缩放
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        // 自动将网页设置为一个合理的比例 显示出来
        settings.setUseWideViewPort(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setLoadWithOverviewMode(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                dialog.dismiss();

            }
        });

    }


    public void loadUrl(String url)
    {
        if(webView != null)
        {
            webView.loadUrl(url);
            dialog = ProgressDialog.show(this, null, "页面加载中，请稍后..");
            webView.reload();
        }
    }


    @Override
    protected void onDestroy() {
        if(request != null){
            MyApp.getApp().getQueue().cancelAll("request");
        }
        super.onDestroy();
    }
}
