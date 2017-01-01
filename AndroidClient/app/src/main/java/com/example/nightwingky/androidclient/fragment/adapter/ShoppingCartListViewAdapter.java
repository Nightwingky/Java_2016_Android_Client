package com.example.nightwingky.androidclient.fragment.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nightwingky.androidclient.R;
import com.example.nightwingky.androidclient.fragment.imageloader.ImageLoader;
import com.example.nightwingky.androidclient.vo.CommodityVO;

import java.util.List;

/**
 * Created by nightwingky on 16-12-30.
 */

public class ShoppingCartListViewAdapter extends BaseAdapter {

    private List<CommodityVO> mList;
    private LayoutInflater mInflater;

    private double totalPrice = 0;

    public double getTotalPrice() {
        for (CommodityVO c : mList) {
            totalPrice += Double.valueOf(c.getCommodityPrice()) * Double.valueOf(c.getCommodityAmount());
        }

        return totalPrice;
    }

    public ShoppingCartListViewAdapter(Context context, List<CommodityVO> mList) {
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
        ShoppingCartViewHolder shoppingCartViewHolder = null;
        if(convertView == null) {
            shoppingCartViewHolder = new ShoppingCartViewHolder();
            convertView = mInflater.inflate(R.layout.shoppingcart_listview_item, null);
            shoppingCartViewHolder.ivIcon = (ImageView) convertView.findViewById(R.id.iv_shoppingcart_list_item_icon);
            shoppingCartViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_shoppingcart_list_item_title);
            shoppingCartViewHolder.tvPrice = (TextView) convertView.findViewById(R.id.tv_shoppingcart_list_item_price);
            shoppingCartViewHolder.tvAmount = (TextView) convertView.findViewById(R.id.tv_shoppingcart_list_item_amount);

            convertView.setTag(shoppingCartViewHolder);
        } else {
            shoppingCartViewHolder = (ShoppingCartViewHolder) convertView.getTag();
        }

        shoppingCartViewHolder.ivIcon.setImageResource(R.mipmap.ic_launcher);
        new ImageLoader().showImageByAsyncTask(shoppingCartViewHolder.ivIcon, mList.get(position).getCommodityImageURL());
        shoppingCartViewHolder.tvTitle.setText(mList.get(position).getCommodityTitle());
        shoppingCartViewHolder.tvPrice.setText("价格：" + mList.get(position).getCommodityPrice());
        shoppingCartViewHolder.tvAmount.setText("数量：" + mList.get(position).getCommodityAmount());

        return convertView;
    }

    class ShoppingCartViewHolder {
        public TextView tvTitle, tvPrice, tvAmount;
        public ImageView ivIcon;
    }
}
