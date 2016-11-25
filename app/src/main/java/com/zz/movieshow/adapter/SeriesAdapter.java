package com.zz.movieshow.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zz.movieshow.R;
import com.zz.movieshow.bean.SeriesEntity;

import java.util.List;

/**
 * Created by wyz on 2016/4/11.
 */
public class SeriesAdapter extends MyBaseAdapter<SeriesEntity.DataBean> {
    public SeriesAdapter(List<SeriesEntity.DataBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView ==null){
            convertView = getInflater().inflate(R.layout.item_sreies,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //设置内容
        SeriesEntity.DataBean bean = getItem(position);

        if (bean.getImage()!=null){
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)//是否具有内存缓存
                    .cacheOnDisk(true)//是否具有磁盘缓存
                    .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)//图片的缩放类型
                    .bitmapConfig(Bitmap.Config.RGB_565)//图片的解码方式
                    .showImageForEmptyUri(R.mipmap.ic_launcher)//空url地址所显示的图片
                    .showImageOnFail(R.mipmap.ic_launcher)//失败的显示图片
                    .showImageOnLoading(R.mipmap.ic_launcher)//默认显示图片
                    .build();
            ImageLoader.getInstance().displayImage(bean.getImage(), viewHolder.imageview_title,options);
        }
        if (bean.getTitle()!=null){
            viewHolder.title.setText(bean.getTitle());
        }
        if (bean.getUpdate_to()!=null){
            viewHolder.num.setText("已更新至"+ bean.getUpdate_to()+"集");
        }
        if (bean.getFollower_num()!=null){
            viewHolder.people.setText(bean.getFollower_num()+"人已订阅");
        }
        if (bean.getContent()!=null){
            viewHolder.content.setText(bean.getContent());
        }
        ObjectAnimator animator = ObjectAnimator.ofFloat(convertView,"translationY",1000,0);
        animator.setDuration(800);
        animator.start();

        return convertView;
    }

    class ViewHolder{
        private ImageView imageview_title;
        private TextView title,num,people,content;
        public ViewHolder(View convertView){
            imageview_title = (ImageView) convertView.findViewById(R.id.imageview_sreies);
            title = (TextView) convertView.findViewById(R.id.title_sreies);
            num = (TextView) convertView.findViewById(R.id.textview_num_sreies);
            people = (TextView) convertView.findViewById(R.id.textview_people_series);
            content = (TextView) convertView.findViewById(R.id.textview_content_series);
        }
    }
}
