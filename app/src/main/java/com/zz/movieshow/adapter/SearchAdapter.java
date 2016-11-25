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
import com.zz.movieshow.bean.SearchEntity;

import java.util.List;

/**
 * Created by zhangzhen on 2016/4/13.
 */
public class SearchAdapter extends MyBaseAdapter<SearchEntity.DataBean>{
    private Context context;
    public SearchAdapter(List<SearchEntity.DataBean> datas, Context context) {
        super(datas, context);
        this.context = context;
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = getInflater().inflate(R.layout.search_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        /**
         *  options = new DisplayImageOptions.Builder()
                     .showStubImage(R.drawable.ic_stub)          // 设置图片下载期间显示的图片
                     .showImageForEmptyUri(R.drawable.ic_empty)  // 设置图片Uri为空或是错误的时候显示的图片
                     .showImageOnFail(R.drawable.ic_error)       // 设置图片加载或解码过程中发生错误显示的图片
                     .cacheInMemory(true)                        // 设置下载的图片是否缓存在内存中
                     .cacheOnDisc(true)                          // 设置下载的图片是否缓存在SD卡中
                     .displayer(new RoundedBitmapDisplayer(20))  // 设置成圆角图片
                     .build();
         */                         // 创建配置过得DisplayImageOption对象

        //加载缓存图片
        if(getItem(position)!= null &&getItem(position).getImage() != null){
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheOnDisk(true)//设置下载图片是否缓存在SD卡中
                    .cacheInMemory(true)//设置下载图片是否缓存在内存中
                    .showImageOnLoading(R.mipmap.ic_launcher)
                    .bitmapConfig(Bitmap.Config.RGB_565)//图片的解码类型
                    .build();

            ImageLoader.getInstance().displayImage(getItem(position).getImage(), viewHolder.imageview,options);
        }

        if(getItem(position)!= null && getItem(position).getTitle()!= null){
            viewHolder.title.setText(getItem(position).getTitle());
        }
        if(getItem(position)!= null && getItem(position).getRating()!= null){
            viewHolder.layout.removeAllViews();
            int grade =(int) ((Double.parseDouble(getItem(position).getRating())+0.5)/2);
            for(int i = 0 ; i < grade ;i++){
                ImageView view = new ImageView(context);
                //重新布局
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
                view.setLayoutParams(params);
                view.setImageResource(R.drawable.ratingprogress);
                viewHolder.layout.addView(view);
            }
            for(int i = 0 ; i < 5-grade ;i++){
                ImageView view = new ImageView(context);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
                view.setLayoutParams(params);
                view.setImageResource(R.drawable.ratingbackgroud);
                viewHolder.layout.addView(view);
            }

            viewHolder.share.setText(grade + "分");
        }  if(getItem(position)!= null && getItem(position).getLike_num()!= null){
            viewHolder.like.setText(getItem(position).getLike_num());
        }
       // ObjectAnimator animator = ObjectAnimator.ofFloat(convertView,);
        return convertView;
    }
    class ViewHolder{
        private ImageView imageview;
        private TextView title,share,like;
        private LinearLayout layout;
        public ViewHolder(View convertView){
            imageview = (ImageView) convertView.findViewById(R.id.content_image);
            title = (TextView) convertView.findViewById(R.id.content_title);
            share = (TextView) convertView.findViewById(R.id.content_fen);
            like = (TextView) convertView.findViewById(R.id.content_count);
            layout = ((LinearLayout) convertView.findViewById(R.id.content_xing));


        }
    }

}
