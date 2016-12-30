package com.example.nightwingky.androidclient.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nightwingky.androidclient.R;
import com.example.nightwingky.androidclient.fragment.imageloader.ImageLoader;
import com.example.nightwingky.androidclient.vo.ContentVO;

import java.util.List;

/**
 * Created by nightwingky on 16-12-30.
 */

public class HomeListViewAdapter extends BaseAdapter {

    private List<ContentVO> mList;
    private LayoutInflater mInflater;

    public HomeListViewAdapter(Context context, List<ContentVO> mList) {
        this.mList = mList;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.commodity_listview_item, null);
            viewHolder.ivIcon = (ImageView) convertView.findViewById(R.id.iv_commodity_list_item_icon);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_commodity_list_item_title);
            viewHolder.tvContent = (TextView) convertView.findViewById(R.id.tv_commodity_list_item_content);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.ivIcon.setImageResource(R.mipmap.ic_launcher);
//        多线程方式加载
//        new ImageLoader().showImageByThread(viewHolder.ivIcon, mList.get(position).getContentImageURL());

//        AsyscTask方式执行
        new ImageLoader().showImageByAsyncTask(viewHolder.ivIcon, mList.get(position).getContentImageURL());
        viewHolder.tvTitle.setText(mList.get(position).getContentTitle());
        viewHolder.tvContent.setText(mList.get(position).getContentPrice());

        return convertView;
    }

    class ViewHolder {
        public TextView tvTitle, tvContent;
        public ImageView ivIcon;
    }
}
