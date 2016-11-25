package com.zz.movieshow.adapter;

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
import com.zz.movieshow.bean.SerDatailiItemEnyity;

import java.util.List;

/**
 * Created by wyz on 2016/4/13.
 */
public class SerDatailfragmentAdapter extends MyBaseAdapter<SerDatailiItemEnyity> {
    public SerDatailfragmentAdapter(List<SerDatailiItemEnyity> datas, Context context) {
        super(datas, context);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView ==null){
            convertView = getInflater().inflate(R.layout.item_serdatail_recycle,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();

        }

        SerDatailiItemEnyity itemEnyity = getItem(position);
        if (itemEnyity.getTitle()!=null)
        {
            viewHolder.title.setText(itemEnyity.getTitle());
        }
        if (itemEnyity.getTime()!=null){
            viewHolder.time.setText("更新时间:"+itemEnyity.getTime());
        }
        if (itemEnyity.getImage_path()!=null){
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)//是否具有内存缓存
                    .cacheOnDisk(true)//是否具有磁盘缓存
                    .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)//图片的缩放类型
                    .bitmapConfig(Bitmap.Config.RGB_565)//图片的解码方式
                    .showImageForEmptyUri(R.mipmap.ic_launcher)//空url地址所显示的图片
                    .showImageOnFail(R.mipmap.ic_launcher)//失败的显示图片
                    .showImageOnLoading(R.mipmap.ic_launcher)//默认显示图片
                    .build();
            ImageLoader.getInstance().displayImage(itemEnyity.getImage_path(), viewHolder.imageView,options);
        }


        return convertView;
    }
    class ViewHolder{
        private TextView title,time;
        private ImageView imageView;

        public ViewHolder(View convertView){

            time = (TextView) convertView.findViewById(R.id.time_item_serdatail);
            title = (TextView) convertView.findViewById(R.id.title_item_serdataillist);
            imageView = (ImageView) convertView.findViewById(R.id.image_item_serdatail);
        }
    }
}
