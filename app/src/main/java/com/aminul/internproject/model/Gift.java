package com.aminul.internproject.model;

import com.google.gson.annotations.SerializedName;

public class Gift {

    @SerializedName("id")
    private int id;
    @SerializedName("gift")
    private String giftName;

    public Gift(int id, String giftName) {
        this.id = id;
        this.giftName = giftName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }
}
