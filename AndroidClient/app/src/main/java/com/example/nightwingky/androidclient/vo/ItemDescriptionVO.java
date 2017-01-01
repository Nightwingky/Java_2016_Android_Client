package com.example.nightwingky.androidclient.vo;

/**
 * Created by nightwingky on 17-1-1.
 */
public class ItemDescriptionVO {

    private String itemContentTitle;
    private String itemPicURL;
    private String itemDescription;
    private String itemPrice;

    public ItemDescriptionVO() {
    }

    public ItemDescriptionVO(String itemContentTitle, String itemPicURL, String itemDescirption, String itemPrice) {
        this.itemContentTitle = itemContentTitle;
        this.itemPicURL = itemPicURL;
        this.itemDescription = itemDescirption;
        this.itemPrice = itemPrice;
    }

    public String getItemContentTitle() {
        return itemContentTitle;
    }

    public void setItemContentTitle(String itemContentTitle) {
        this.itemContentTitle = itemContentTitle;
    }

    public String getItemPicURL() {
        return itemPicURL;
    }

    public void setItemPicURL(String itemPicURL) {
        this.itemPicURL = itemPicURL;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ItemDescriptionVO{" +
                "itemContentTitle='" + itemContentTitle + '\'' +
                ", itemPicURL='" + itemPicURL + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemPrice='" + itemPrice + '\'' +
                '}');

        return stringBuilder.toString();
    }
}
