package com.example.nightwingky.androidclient.vo;

/**
 * Created by nightwingky on 16-12-30.
 */

public class CommodityVO {

    private String commodityImageURL;
    private String commodityTitle;
    private String commodityPrice;
    private String commodityAmount;

    public CommodityVO() {
    }

    public CommodityVO(String commodityImageURL, String commodityTitle, String commodityPrice, String commodityAmount) {
        this.commodityImageURL = commodityImageURL;
        this.commodityTitle = commodityTitle;
        this.commodityPrice = commodityPrice;
        this.commodityAmount = commodityAmount;
    }

    public String getCommodityImageURL() {
        return commodityImageURL;
    }

    public void setCommodityImageURL(String commodityImageURL) {
        this.commodityImageURL = commodityImageURL;
    }

    public String getCommodityTitle() {
        return commodityTitle;
    }

    public void setCommodityTitle(String commodityTitle) {
        this.commodityTitle = commodityTitle;
    }

    public String getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(String commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityAmount() {
        return commodityAmount;
    }

    public void setCommodityAmount(String commodityAmount) {
        this.commodityAmount = commodityAmount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CommodityVO{" +
                "commodityImageURL='" + commodityImageURL + '\'' +
                ", commodityTitle='" + commodityTitle + '\'' +
                ", commodityPrice='" + commodityPrice + '\'' +
                ", commodityAmount='" + commodityAmount + '\'' +
                '}');

        return stringBuilder.toString();
    }
}
