package com.example.nightwingky.androidclient.fragment;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nightwingky.androidclient.R;
import com.example.nightwingky.androidclient.constant.MyConstant;
import com.example.nightwingky.androidclient.fragment.adapter.ShoppingCartListViewAdapter;
import com.example.nightwingky.androidclient.http.HttpQuery;
import com.example.nightwingky.androidclient.json.MyJsonConverter;
import com.example.nightwingky.androidclient.vo.CommodityVO;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by nightwingky on 16-12-29.
 */

public class FragmentShoppingCart extends Fragment {

    private ListView mListView;
    private TextView tv_TotalPrice;

    private ContentAsyncTask asyncTask;

    private static String URL= MyConstant.getShoppingCartInfoUrl();

    public FragmentShoppingCart() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shoppingcart_layout_fragment, container, false);
        mListView = (ListView) view.findViewById(R.id.lv_shoppingCart);
        tv_TotalPrice = (TextView) view.findViewById(R.id.tv_total_price);

        asyncTask = new FragmentShoppingCart.ContentAsyncTask();
        asyncTask.execute(URL);

        return view;
    }

    private List<CommodityVO> getJsonData() throws IOException, JSONException {
        String jsonString = HttpQuery.getQueryContent(URL);
        List<CommodityVO> commodityVOList = MyJsonConverter.convertSCJsonString(jsonString);

        return commodityVOList;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void invalidateListView() {
        asyncTask = new FragmentShoppingCart.ContentAsyncTask();
        asyncTask.execute(URL);
        this.mListView.invalidateViews();
    }

    class ContentAsyncTask extends AsyncTask<String, Void, List<CommodityVO>> {

        @Override
        protected List<CommodityVO> doInBackground(String... params) {
            try {
                return getJsonData();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<CommodityVO> commodityVOs) {
            super.onPostExecute(commodityVOs);

            ShoppingCartListViewAdapter adapter = new ShoppingCartListViewAdapter(FragmentShoppingCart.this.getActivity(), commodityVOs);
            mListView.setAdapter(adapter);

            tv_TotalPrice.setText(String.valueOf(adapter.getTotalPrice()));
        }
    }
}
