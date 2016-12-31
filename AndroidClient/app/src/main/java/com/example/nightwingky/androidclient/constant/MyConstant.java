package com.example.nightwingky.androidclient.constant;

/**
 * Created by nightwingky on 16-12-30.
 */

public class MyConstant {

    private static final String homeInfoUrl = "http://172.23.70.17:8080/AndroidServer/HomeListViewServlet";

    private static final String shoppingCartInfoUrl = "http://www.imooc.com/api/teacher?type=4&num=30";

    public static String getHomeInfoUrl() {
        return homeInfoUrl;
    }

    public static String getShoppingCartInfoUrl() {
        return shoppingCartInfoUrl;
    }
}
