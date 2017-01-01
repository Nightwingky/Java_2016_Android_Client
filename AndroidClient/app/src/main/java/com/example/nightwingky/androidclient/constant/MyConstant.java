package com.example.nightwingky.androidclient.constant;

/**
 * Created by nightwingky on 16-12-30.
 */

public class MyConstant {

    private static final String homeInfoUrl = "http://172.23.70.17:8080/AndroidServer/HomeListViewServlet";

    private static final String shoppingCartInfoUrl = "http://172.23.70.17:8080/AndroidServer/SCLvServlet";

    private static final String itemDescriptionUrl = "http://172.23.70.17:8080/AndroidServer/ItemServlet";

    private static final String itemInsertUrl = "http://172.23.70.17:8080/AndroidServer/SCAddServlet";

    public static String getHomeInfoUrl() {
        return homeInfoUrl;
    }

    public static String getShoppingCartInfoUrl() {
        return shoppingCartInfoUrl;
    }

    public static String getItemDescriptionUrl() {
        return itemDescriptionUrl;
    }

    public static String getItemInsertUrl() {
        return itemInsertUrl;
    }
}
