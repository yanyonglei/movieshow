package com.zz.movieshow.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zz.movieshow.R;
import com.zz.movieshow.bean.ChannelEntity;

import java.util.List;

/**
 * Created by zhang on 2016/4/11.
 */
public class ChannelRecycleViewAdapter extends RecyclerView.Adapter<ChannelRecycleViewAdapter.ViewHolder> {

    private ItemClickListener itemClickListener;
    private List<ChannelEntity.DataBean> datas;
    private LayoutInflater inflater;

    public ChannelRecycleViewAdapter(List<ChannelEntity.DataBean> datas,Context context,ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {


        return new ViewHolder(inflater.inflate(R.layout.item_channel_recyclerview,null)) ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ChannelEntity.DataBean dataBean = datas.get(position);

        if (dataBean.getCatename()!=null){
            holder.textview_title.setText(dataBean.getCatename());
        }
        if (dataBean.getAlias()!=null){

            holder.textView_content.setText(dataBean.getAlias());
        }

        if (dataBean.getIcon()!=null){
            String url=  dataBean.getIcon();

            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .showImageForEmptyUri(R.mipmap.ic_launcher)
                    .showImageOnFail(R.mipmap.ic_launcher)
                    .showImageOnLoading(R.mipmap.ic_launcher).build();


            ImageLoader.getInstance().displayImage(url,
                    holder.imageView_channel,
                    options);
        }


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class  ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView_channel;
        private TextView textview_title,textView_content;

        public ViewHolder(View itemView) {
            super(itemView);


            imageView_channel=((ImageView) itemView.findViewById(R.id.imageview_channel_item));

           textview_title= ((TextView) itemView.findViewById(R.id.textview_titles));
            textView_content= ((TextView) itemView.findViewById(R.id.textview_contents));

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            itemClickListener.onItemClick(getLayoutPosition(),v);

        }
    }
    public interface  ItemClickListener{

        public void onItemClick(int position, View view);

    }
    public void addAll(List<ChannelEntity.DataBean>data){
        datas.addAll(data);
        notifyDataSetChanged();
    }
    public void clear(){

        datas.clear();
        notifyDataSetChanged();


    }


}

