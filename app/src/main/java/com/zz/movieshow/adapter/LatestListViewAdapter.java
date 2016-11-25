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
import com.zz.movieshow.R;
import com.zz.movieshow.bean.LatestEntity;

import java.util.List;

/**
 * Created by zhangzhen on 2016/4/11.
 *最近列表的适配器
 */
public class LatestListViewAdapter extends MyBaseAdapter<LatestEntity.DataBean>{
    private Context context;
    //重新构造方法LatestListViewAdapter
    public LatestListViewAdapter(List<LatestEntity.DataBean> datas, Context context) {

        super(datas, context);
        this.context = context;
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null){
            convertView = getInflater().inflate(R.layout.item_fragment_hot,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if(getItem(position)!= null && getItem(position).getImage() != null){
          DisplayImageOptions options = new DisplayImageOptions.Builder()
                 .cacheOnDisk(true)
                 .cacheInMemory(true)
                 .showImageOnLoading(R.mipmap.main_pic_shadow)//设置下载时的默认显示图片
                 .bitmapConfig(Bitmap.Config.RGB_565)
                 .build();

         ImageLoader.getInstance().displayImage(getItem(position).getImage(), viewHolder.imageview_title,options);
     }

         if(getItem(position) != null && getItem(position).getTitle() != null){
          viewHolder.title.setText(getItem(position).getTitle());
         }

         if(getItem(position) != null && getItem(position).getRating() != null){
              viewHolder.layout.removeAllViews();//清理布局所有成员
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
         if(getItem(position)!= null && getItem(position).getShare_num() != null){
          viewHolder.share.setText(getItem(position).getShare_num());
      }

        if(getItem(position) != null && getItem(position).getDuration() != null){
            int times = Integer.parseInt( getItem(position).getDuration());
            String ss = "%02d:%02d";
            int minute = times%3600/60;
            int second = times%60;
            String time = String.format(ss,minute,second);
            viewHolder.time.setText(time);
        }
        //子目录的动画化设置 平移动画 translationY Y方向 1000到0
        ObjectAnimator animator = ObjectAnimator.ofFloat(convertView,"translationY",1000,0);

        //动画的时间800ms
        animator.setDuration(800);
        animator.start();
        return convertView;
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

            layout = ((LinearLayout) convertView.findViewById(R.id.linear_layout_hot));


        }
    }
}
