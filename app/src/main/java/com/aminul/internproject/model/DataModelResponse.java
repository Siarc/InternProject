package com.aminul.internproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataModelResponse {

    @SerializedName("product_group_list")
    @Expose
    private List<ProductGroup> productGroupList = null;
    @SerializedName("literature_list")
    @Expose
    private List<Literature> literatureList = null;
    @SerializedName("physician_sample_list")
    @Expose
    private List<PhysicianSample> physicianSampleList = null;
    @SerializedName("gift_list")
    @Expose
    private List<Gift> giftList = null;

    public List<ProductGroup> getProductGroupList() {
        return productGroupList;
    }

    public void setProductGroupList(List<ProductGroup> productGroupList) {
        this.productGroupList = productGroupList;
    }

    public List<Literature> getLiteratureList() {
        return literatureList;
    }

    public void setLiteratureList(List<Literature> literatureList) {
        this.literatureList = literatureList;
    }

    public List<PhysicianSample> getPhysicianSampleList() {
        return physicianSampleList;
    }

    public void setPhysicianSampleList(List<PhysicianSample> physicianSampleList) {
        this.physicianSampleList = physicianSampleList;
    }

    public List<Gift> getGiftList() {
        return giftList;
    }

    public void setGiftList(List<Gift> giftList) {
        this.giftList = giftList;
    }
}
