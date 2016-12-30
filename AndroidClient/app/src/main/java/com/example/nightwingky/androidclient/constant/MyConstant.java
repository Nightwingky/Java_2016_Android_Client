package com.example.nightwingky.androidclient.constant;

/**
 * Created by nightwingky on 16-12-30.
 */

public class MyConstant {

    private static String url = "http://www.imooc.com/api/teacher?type=4&num=30";

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        MyConstant.url = url;
    }
}
