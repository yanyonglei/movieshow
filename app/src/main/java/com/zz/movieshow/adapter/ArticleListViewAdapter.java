package com.zz.movieshow.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zz.movieshow.R;
import com.zz.movieshow.bean.ArticleEntity;

import java.util.List;

/**
 * Created by zhangzhen on 2016/4/12.
 */
public class ArticleListViewAdapter extends MyBaseAdapter<ArticleEntity.DataBean>{
    public ArticleListViewAdapter(List<ArticleEntity.DataBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = getInflater().inflate(R.layout.article_listview,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if(getItem(position)!= null &&getItem(position).getImage() != null){
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheOnDisk(true)
                    .cacheInMemory(true)
                    .showImageOnLoading(R.mipmap.ic_launcher)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .build();
            ImageLoader.getInstance().displayImage(getItem(position).getImage(), viewHolder.imageview,options);
        }

        if(getItem(position)!= null && getItem(position).getTitle()!= null){
            viewHolder.title.setText(getItem(position).getTitle());
        }
        if(getItem(position)!= null && getItem(position).getShare_num()!= null){
            viewHolder.share.setText(getItem(position).getShare_num());
        }  if(getItem(position)!= null && getItem(position).getLike_num()!= null){
            viewHolder.like.setText(getItem(position).getLike_num());
        }



        return convertView;
    }
    class ViewHolder{
        private ImageView imageview;
        private TextView title,share,like;
        private LinearLayout layout;
        public ViewHolder(View convertView){
            imageview = (ImageView) convertView.findViewById(R.id.article_image);
            title = (TextView) convertView.findViewById(R.id.article_title);
            share = (TextView) convertView.findViewById(R.id.article_count);
            like = (TextView) convertView.findViewById(R.id.article_amount);


        }
    }
}
