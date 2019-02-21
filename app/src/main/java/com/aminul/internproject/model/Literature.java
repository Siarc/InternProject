package com.aminul.internproject.model;

import com.google.gson.annotations.SerializedName;

public class Literature {

    @SerializedName("id")
    private int id;
    @SerializedName("literature")
    private String literatureName;

    public Literature(int id, String literatureName) {
        this.id = id;
        this.literatureName = literatureName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLiteratureName() {
        return literatureName;
    }

    public void setLiteratureName(String literatureName) {
        this.literatureName = literatureName;
    }

    @Override
    public String toString() {
        return literatureName;
    }
}
