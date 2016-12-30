package com.example.nightwingky.androidclient.http;

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

    public static List<ContentVO> convertJsonString(String jsonString) throws JSONException {
        List<ContentVO> contentVOList = new ArrayList<ContentVO>();
        ContentVO contentVO;

        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray jsonArray = jsonObject.getJSONArray("data");

        for(int i = 0; i < jsonArray.length(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            contentVO = new ContentVO();
            contentVO.setContentImageURL(jsonObject.getString("picSmall"));
            contentVO.setContentTitle(jsonObject.getString("name"));
            contentVO.setContentPrice(jsonObject.getString("description"));

            contentVOList.add(contentVO);
        }

        return contentVOList;
    }
}
