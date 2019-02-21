package com.aminul.internproject.model;

import com.google.gson.annotations.SerializedName;

public class ProductGroup {

    @SerializedName("id")
    private int id;
    @SerializedName("product_group")
    private String productGroupName;

    public ProductGroup(int id, String productGroupName) {
        this.id = id;
        this.productGroupName = productGroupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String productGroupName) {
        this.productGroupName = productGroupName;
    }

    @Override
    public String toString() {
        return "ProductGroup{" +
                "id=" + id +
                ", productGroupName='" + productGroupName + '\'' +
                '}';
    }
}
