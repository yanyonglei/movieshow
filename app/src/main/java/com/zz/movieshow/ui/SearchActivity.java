package com.zz.movieshow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.zz.movieshow.MyApp;
import com.zz.movieshow.R;
import com.zz.movieshow.adapter.SearchAdapter;
import com.zz.movieshow.bean.SearchEntity;
import com.zz.movieshow.uri.URI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 搜索Activty的创建
 */
public class SearchActivity extends AppCompatActivity {

    /**
     * 可编辑文本
     */
    private EditText editText;
    private ListView listView;
    private SearchAdapter adapter;
    private StringRequest request;
    private TextView textView;
    private boolean isBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();//初始化组件
    }

    private void initView() {
        editText = ((EditText) findViewById(R.id.edit_search));
        listView = ((ListView) findViewById(R.id.sraech_listview));
        textView = ((TextView) findViewById(R.id.search_text));

        adapter = new SearchAdapter(new ArrayList<SearchEntity.DataBean>(),this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
                intent.putExtra("postid",adapter.getItem(position-2).getPostid());
                startActivity(intent);
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                  if((firstVisibleItem +visibleItemCount) == totalItemCount){
                      isBottom = true;
                  }
            }
        });
    }

    //撤销按钮的点击事件
    public void cancel(View view){
        editText.setText("");
        adapter.clear();
        textView.setText("");
    }
    //内容搜索
    public void ContentSearch(View view){
        final String keyWord = editText.getText().toString();
        request = new StringRequest(Request.Method.POST, URI.URL_SEARCH, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
             SearchEntity entity = gson.fromJson(response,SearchEntity.class);
                textView.setText("搜索到"+entity.getData().size()+"条关于"+keyWord+"的内容");
                adapter.addAll(entity.getData());
            }
        },null){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put("p","1");
                map.put("size","10");
                map.put("kw",keyWord);
                return map;
            }
        };
        request.setTag("request");
        MyApp.getApp().getQueue().add(request);

    }

    @Override
    protected void onDestroy() {
        if(request != null){
            MyApp.getApp().getQueue().cancelAll("request");
        }
        super.onDestroy();
    }
}
