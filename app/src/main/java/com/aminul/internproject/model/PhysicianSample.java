package com.aminul.internproject.model;

import com.google.gson.annotations.SerializedName;

public class PhysicianSample {

    @SerializedName("id")
    private int id;
    @SerializedName("sample")
    private String sampleName;

    public PhysicianSample(int id, String sampleName) {
        this.id = id;
        this.sampleName = sampleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }
}
