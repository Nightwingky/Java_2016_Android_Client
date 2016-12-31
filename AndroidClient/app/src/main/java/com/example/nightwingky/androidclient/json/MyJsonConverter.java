package com.example.nightwingky.androidclient.json;

import android.util.Log;

import com.example.nightwingky.androidclient.vo.CommodityVO;
import com.example.nightwingky.androidclient.vo.ContentVO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nightwingky on 16-12-30.
 */

public class MyJsonConverter {

    public static List<ContentVO> convertHomeJsonString(String jsonString) throws JSONException {
        List<ContentVO> contentVOList = new ArrayList<ContentVO>();
        ContentVO contentVO;

        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray jsonArray = jsonObject.getJSONArray("data");

        for(int i = 0; i < jsonArray.length(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            contentVO = new ContentVO();
            contentVO.setContentImageURL(jsonObject.getString("contentImageURL"));
            contentVO.setContentTitle(jsonObject.getString("contentTitle"));
            contentVO.setContentPrice(jsonObject.getString("contentPrice"));

            contentVOList.add(contentVO);
        }

        Log.d("qky", String.valueOf(contentVOList));
        return contentVOList;
    }

    public static List<CommodityVO> convertSCJsonString(String jsonString) throws JSONException {
        List<CommodityVO> commodityVOList = new ArrayList<CommodityVO>();
        CommodityVO commodityVO;

        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray jsonArray = jsonObject.getJSONArray("data");

        for(int i = 0; i < jsonArray.length(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            commodityVO = new CommodityVO();
            commodityVO.setCommodityImageURL(jsonObject.getString("commodityImageURL"));
            commodityVO.setCommodityTitle(jsonObject.getString("commodityTitle"));
            commodityVO.setCommodityPrice(jsonObject.getString("commodityPrice"));
            commodityVO.setCommodityAmount(jsonObject.getString("commodityAmount"));

            commodityVOList.add(commodityVO);
        }

        Log.d("qky", String.valueOf(commodityVOList));
        return commodityVOList;
    }
}
