package com.example.nightwingky.androidclient.fragment.home;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nightwingky.androidclient.R;
import com.example.nightwingky.androidclient.activity.ListItemActivity;
import com.example.nightwingky.androidclient.constant.MyConstant;
import com.example.nightwingky.androidclient.http.HttpQuery;
import com.example.nightwingky.androidclient.json.MyJsonConverter;
import com.example.nightwingky.androidclient.vo.ContentVO;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by nightwingky on 16-12-29.
 */

public class FragmentHome extends Fragment {

    private ListView mListView;

    private static String URL= MyConstant.getHomeInfoUrl();

    public FragmentHome() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout_fragment, container, false);
        mListView = (ListView) view.findViewById(R.id.lv_home);

        new ContentAsyncTask().execute(URL);

        setListener();

        return view;
    }

    private void setListener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view.findViewById(R.id.tv_commodity_list_item_title);
                String s = String.valueOf(tv.getText());

                Intent intent = new Intent(FragmentHome.this.getActivity(), ListItemActivity.class);
                intent.putExtra("title", s);
                startActivity(intent);
            }
        });
    }

    private List<ContentVO> getJsonData() throws IOException, JSONException {

        String jsonString = HttpQuery.getQueryContent(URL);
        List<ContentVO> contentVOList = MyJsonConverter.convertHomeJsonString(jsonString);

        return contentVOList;
    }

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

        @Override
        protected void onPostExecute(List<ContentVO> contentVOs) {
            super.onPostExecute(contentVOs);

            HomeListViewAdapter adapter = new HomeListViewAdapter(FragmentHome.this.getActivity(), contentVOs);
            mListView.setAdapter(adapter);
        }
    }
}
