package com.example.nightwingky.androidclient.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nightwingky.androidclient.R;
import com.example.nightwingky.androidclient.constant.MyConstant;
import com.example.nightwingky.androidclient.fragment.imageloader.ImageLoader;
import com.example.nightwingky.androidclient.http.HttpPostQuery;
import com.example.nightwingky.androidclient.json.MyJsonConverter;
import com.example.nightwingky.androidclient.vo.ItemDescriptionVO;

import org.json.JSONException;

import java.io.IOException;

public class ListItemActivity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView tv_itemTitle;
    private TextView tv_itemDescription;
    private TextView tv_itemPrice;

    private Button btn_submit;

    private String queryTitle;

    private static String URL = MyConstant.getItemDescriptionUrl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        bindView();

        getParameter();

        new ListItemAsyncTask().execute(URL);
    }

    private void getParameter() {
        Intent intent = getIntent();

        queryTitle = intent.getStringExtra("title");
        Log.d("title", queryTitle);
    }

    private void bindView() {
        mImageView = (ImageView) findViewById(R.id.img_item_description_image);
        tv_itemTitle = (TextView) findViewById(R.id.tv_item_description_title);
        tv_itemDescription = (TextView) findViewById(R.id.tv_item_description_description);
        tv_itemPrice = (TextView) findViewById(R.id.tv_item_description_price);
        btn_submit = (Button) findViewById(R.id.btn_item_description_submit);
    }

    private ItemDescriptionVO getJsonData() throws IOException, JSONException {
        String jsonString = HttpPostQuery.getQueryContent(URL, queryTitle);

        ItemDescriptionVO item = MyJsonConverter.convertItemDescriptionJsonString(jsonString);

        return item;
    }

    class ListItemAsyncTask extends AsyncTask<String, Void, ItemDescriptionVO> {

        @Override
        protected ItemDescriptionVO doInBackground(String... params) {
            try {
                Log.d("itemitem", getJsonData().toString());
                return getJsonData();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(ItemDescriptionVO itemDescriptionVO) {
            super.onPostExecute(itemDescriptionVO);

            tv_itemTitle.setText(itemDescriptionVO.getItemContentTitle());
            tv_itemDescription.setText(itemDescriptionVO.getItemDescription());
            Log.d("price", itemDescriptionVO.getItemPrice());
            tv_itemPrice.setText(itemDescriptionVO.getItemPrice());

            new ImageLoader().showImageByAsyncTask(mImageView, itemDescriptionVO.getItemPicURL());
        }
    }
}
