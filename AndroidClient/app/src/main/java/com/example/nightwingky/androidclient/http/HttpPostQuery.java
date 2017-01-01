package com.example.nightwingky.androidclient.http;

import com.example.nightwingky.androidclient.constant.MyConstant;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by nightwingky on 17-1-1.
 */

public class HttpPostQuery {

    public static String getQueryContent(String URL, String title) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        FormBody formBody = new FormBody.Builder()
                .add("itemTitle", title)
                .build();

        Request request = new Request.Builder()
                .url(URL)
                .post(formBody)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        if(response.isSuccessful()) {
            return response.body().string();
        } else {
            return null;
        }
    }

}
