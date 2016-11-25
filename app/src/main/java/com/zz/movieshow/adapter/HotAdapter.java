package com.zz.movieshow.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zz.movieshow.R;
import com.zz.movieshow.bean.HotEntity;

import java.util.List;

/**
 * Created by wyz on 2016/4/11.
 */
public class HotAdapter extends MyBaseAdapter<HotEntity.DataBean> {
    private HotEntity.DataBean bean;
    private Context context;

    public HotAdapter(List<HotEntity.DataBean> datas, Context context) {
        super(datas, context);
        this.context = context;
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView =getInflater().inflate(R.layout.item_fragment_hot,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        bean = getItem(position);
        if (bean.getImage()!=null){

            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)//是否具有内存缓存
                    .cacheOnDisk(true)//是否具有磁盘缓存
                    .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)//图片的缩放类型
                    .bitmapConfig(Bitmap.Config.RGB_565)//图片的解码方式
                    .showImageForEmptyUri(R.mipmap.main_pic_shadow)//空url地址所显示的图片
                    .showImageOnFail(R.mipmap.main_pic_shadow)//失败的显示图片
                    .showImageOnLoading(R.mipmap.main_pic_shadow)//默认显示图片
                    .build();
            ImageLoader.getInstance().displayImage(bean.getImage(), viewHolder.imageview_title,options);
        }
        if (bean.getTitle()!=null){
            viewHolder.title.setText(bean.getTitle());
        }
        if(getItem(position) != null && getItem(position).getRating() != null){
            viewHolder.layout.removeAllViews();
            int grade =(int) ((Double.parseDouble(getItem(position).getRating())+0.5)/2);
            for(int i = 0 ; i < grade ;i++){
                ImageView view = new ImageView(context);
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

            viewHolder.grade.setText(grade + "分");
        }
        if (bean.getShare_num()!=null){
            viewHolder.share.setText(bean.getShare_num());
        }
        if (bean.getDuration()!=null){
            String s = getTime();
            viewHolder.time.setText(s);
        }
        ObjectAnimator animator = ObjectAnimator.ofFloat(convertView,"translationX",1000,0);
        animator.setDuration(800);
        animator.start();

        return convertView;
    }

    private String getTime() {
        int duration = Integer.parseInt( bean.getDuration());


        return getS(duration);

    }
    public String getS(int time){
        String ss = "%02d:%02d";


        int hour = time/3600;
        int minute = time%3600/60;
        int second = time%60;
        return String.format(ss,minute, second);
    }
    class ViewHolder{
        private ImageView imageview_title;
        private TextView title,share,time,grade;
        private LinearLayout layout;
        public ViewHolder(View convertView){
            imageview_title = (ImageView) convertView.findViewById(R.id.imageview_hot);
            title = (TextView) convertView.findViewById(R.id.title_hot);
            share = (TextView) convertView.findViewById(R.id.textview_share_hot);
            time = (TextView) convertView.findViewById(R.id.text_time_hot);
            grade = (TextView) convertView.findViewById(R.id.textview_grade_hot);
            layout = (LinearLayout) convertView.findViewById(R.id.linear_layout_hot);

        }
    }
}
