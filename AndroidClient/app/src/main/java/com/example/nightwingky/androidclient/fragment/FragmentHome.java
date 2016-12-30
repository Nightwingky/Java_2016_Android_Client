package com.example.nightwingky.androidclient.fragment;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.nightwingky.androidclient.R;
import com.example.nightwingky.androidclient.constant.MyConstant;
import com.example.nightwingky.androidclient.fragment.adapter.MyListViewAdapter;
import com.example.nightwingky.androidclient.http.HttpQuery;
import com.example.nightwingky.androidclient.http.MyJsonConverter;
import com.example.nightwingky.androidclient.vo.ContentVO;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by nightwingky on 16-12-29.
 */

public class FragmentHome extends Fragment {

    private ListView mListView;

    private static String URL= MyConstant.getUrl();

    public FragmentHome() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout_fragment, container, false);
        mListView = (ListView) view.findViewById(R.id.lv_home);


        return view;
    }

    private List<ContentVO> getJsonData(String URL) throws IOException, JSONException {

//        JSONObject jsonObject;
//        ContentVO contentVO;
//
//        jsonObject = new JSONObject(jsonString);
//
//        JSONArray jsonArray = jsonObject.getJSONArray("data");
//
//        for(int i = 0; i < jsonArray.length(); i++) {
//            jsonObject = jsonArray.getJSONObject(i);
//            contentVO = new ContentVO();
//            contentVO.setNewsIconUrl(jsonObject.getString("picSmall"));
//            contentVO.setNewsTitle(jsonObject.getString("name"));
//            contentVO.setNewsContent(jsonObject.getString("description"));
//
//            contentVOList.add(contentVO);
//        }

        String jsonString = HttpQuery.getQueryContent();
        List<ContentVO> contentVOList = MyJsonConverter.convertJsonString(jsonString);

        return contentVOList;
    }


    class ContentAsyncTask extends AsyncTask<String, Void, List<ContentVO>> {

        @Override
        protected List<ContentVO> doInBackground(String... params) {
            try {
                return getJsonData(params[0]);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<ContentVO> contentVOs) {
            super.onPostExecute(contentVOs);

            /******************/
            MyListViewAdapter adapter = new MyListViewAdapter()
        }
    }
}
