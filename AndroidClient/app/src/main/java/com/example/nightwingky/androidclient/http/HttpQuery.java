package com.example.nightwingky.androidclient.http;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.nightwingky.androidclient.constant.MyConstant;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by nightwingky on 16-12-30.
 */

public class HttpQuery {

    @NonNull
    public static String getQueryContent(String url) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

//        HttpUrl httpUrl = HttpUrl.parse(url)
//                .newBuilder()
//                .build();

        Request request = new Request
                .Builder()
                .url(url)
                .build();
        Response response = okHttpClient.newCall(request).execute();

        if(response == null) {
            Log.d("http", "No URL connection");
        }

        return response.body().string();
    }

}
