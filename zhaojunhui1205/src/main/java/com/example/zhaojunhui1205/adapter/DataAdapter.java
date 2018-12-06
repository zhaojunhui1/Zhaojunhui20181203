package com.example.zhaojunhui1205.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhaojunhui1205.R;
import com.example.zhaojunhui1205.bean.VideoBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends BaseAdapter {

    private List<VideoBean.DataBean> mData;
    private Context mContext;

    public DataAdapter(Context mContext) {
        this.mContext = mContext;
        mData = new ArrayList<>();
    }
    public void setDatas(List<VideoBean.DataBean> data) {
        this.mData = data;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public VideoBean.DataBean getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataHolder mHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.data_item, parent, false);
            mHolder = new DataHolder(convertView);
        }else {
            mHolder = (DataHolder) convertView.getTag();
        }
        mHolder.bindData(getItem(position));
        return convertView;
    }

    class DataHolder{
        TextView textView;
        ImageView imageView1, imageView2, imageView3;

        public DataHolder(View itemView){
            textView = itemView.findViewById(R.id.text);
            imageView1 = itemView.findViewById(R.id.image1);
            imageView2 = itemView.findViewById(R.id.image2);
            imageView3 = itemView.findViewById(R.id.image3);
            itemView.setTag(this);
        }

        public void bindData(VideoBean.DataBean item) {
            textView.setText(item.getAuthor_name());
            if (imageView1 != null && imageView2 != null && imageView3 != null) {
                ImageLoader.getInstance().displayImage(item.getThumbnail_pic_s(), imageView1);
                ImageLoader.getInstance().displayImage(item.getThumbnail_pic_s02(), imageView2);
                ImageLoader.getInstance().displayImage(item.getThumbnail_pic_s03(), imageView3);
            }
        }
    }
}
