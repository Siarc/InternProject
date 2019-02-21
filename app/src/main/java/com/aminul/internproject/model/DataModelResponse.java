package com.aminul.internproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataModelResponse {

    @SerializedName("product_group_list")
    @Expose
    private ArrayList<ProductGroup> productGroupList = null;
    @SerializedName("literature_list")
    @Expose
    private ArrayList<Literature> literatureList = null;
    @SerializedName("physician_sample_list")
    @Expose
    private ArrayList<PhysicianSample> physicianSampleList = null;
    @SerializedName("gift_list")
    @Expose
    private ArrayList<Gift> giftList = null;

    public ArrayList<ProductGroup> getProductGroupList() {
        return productGroupList;
    }

    public void setProductGroupList(ArrayList<ProductGroup> productGroupList) {
        this.productGroupList = productGroupList;
    }

    public ArrayList<Literature> getLiteratureList() {
        return literatureList;
    }

    public void setLiteratureList(ArrayList<Literature> literatureList) {
        this.literatureList = literatureList;
    }

    public ArrayList<PhysicianSample> getPhysicianSampleList() {
        return physicianSampleList;
    }

    public void setPhysicianSampleList(ArrayList<PhysicianSample> physicianSampleList) {
        this.physicianSampleList = physicianSampleList;
    }

    public ArrayList<Gift> getGiftList() {
        return giftList;
    }

    public void setGiftList(ArrayList<Gift> giftList) {
        this.giftList = giftList;
    }
}
