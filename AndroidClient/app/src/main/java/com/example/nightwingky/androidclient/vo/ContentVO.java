package com.example.nightwingky.androidclient.vo;

/**
 * Created by nightwingky on 16-12-30.
 */

public class ContentVO {

    private String newsIconUrl;
    private String newsTitle;
    private String newsContent;

    public String getNewsIconUrl() {
        return newsIconUrl;
    }

    public void setNewsIconUrl(String newsIconUrl) {
        this.newsIconUrl = newsIconUrl;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ContentVO{" +
                "newsIconUrl='" + newsIconUrl + '\'' +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                '}');

        return stringBuilder.toString();
    }
}
