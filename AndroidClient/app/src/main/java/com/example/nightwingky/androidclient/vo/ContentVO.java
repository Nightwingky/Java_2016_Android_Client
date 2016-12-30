package com.example.nightwingky.androidclient.vo;

/**
 * Created by nightwingky on 16-12-30.
 */

public class ContentVO {

    private String contentImageURL;
    private String contentTitle;
    private String contentPrice;

    public String getContentImageURL() {
        return contentImageURL;
    }

    public void setContentImageURL(String contentImageURL) {
        this.contentImageURL = contentImageURL;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentPrice() {
        return contentPrice;
    }

    public void setContentPrice(String contentPrice) {
        this.contentPrice = contentPrice;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ContentVO{" +
                "contentImageURL='" + contentImageURL + '\'' +
                ", contentTitle='" + contentTitle + '\'' +
                ", contentPrice='" + contentPrice + '\'' +
                '}');

        return stringBuilder.toString();
    }
}
