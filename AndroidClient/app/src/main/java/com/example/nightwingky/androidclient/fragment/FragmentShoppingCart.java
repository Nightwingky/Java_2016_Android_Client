package com.example.nightwingky.androidclient.fragment;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.nightwingky.androidclient.R;
import com.example.nightwingky.androidclient.constant.MyConstant;
import com.example.nightwingky.androidclient.fragment.adapter.ShoppingCartListViewAdapter;
import com.example.nightwingky.androidclient.http.HttpQuery;
import com.example.nightwingky.androidclient.http.MyJsonConverter;
import com.example.nightwingky.androidclient.vo.CommodityVO;
import com.example.nightwingky.androidclient.vo.ContentVO;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by nightwingky on 16-12-29.
 */

public class FragmentShoppingCart extends Fragment {

    private ListView mListView;

    private static String URL= MyConstant.getShoppingCartInfoUrl();

    public FragmentShoppingCart() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shoppingcart_layout_fragment, container, false);
        mListView = (ListView) view.findViewById(R.id.lv_shoppingCart);

        new FragmentShoppingCart.ContentAsyncTask().execute(URL);

        return view;
    }

    // TODO: 16-12-30 服务器未传递json格式的CommodityVO对象
    private List<ContentVO> getJsonData() throws IOException, JSONException {
        String jsonString = HttpQuery.getQueryContent(MyConstant.getHomeInfoUrl());
        List<ContentVO> contentVOList = MyJsonConverter.convertJsonString(jsonString);

        return contentVOList;
    }

    // TODO: 16-12-30 服务器未传递json格式的CommodityVO对象
    class ContentAsyncTask extends AsyncTask<String, Void, List<ContentVO>> {

        @Override
        protected List<ContentVO> doInBackground(String... params) {
            try {
                return getJsonData();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        // TODO: 16-12-30 服务器未传递json格式的CommodityVO对象
        @Override
        protected void onPostExecute(List<ContentVO> contentVOs) {
            super.onPostExecute(contentVOs);
        }
    }
}
