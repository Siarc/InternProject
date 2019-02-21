package com.aminul.internproject.utils;

import com.aminul.internproject.model.Gift;
import com.aminul.internproject.model.Literature;
import com.aminul.internproject.model.ModelLists;
import com.aminul.internproject.model.PhysicianSample;
import com.aminul.internproject.model.ProductGroup;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {


    /**
     * I do not know what to do here?
     * how do i get different objects?
     * it gets all the json in one go or it takes part of it?
     * @return
     */
    @GET("data.json")
    Call<ModelLists> getData();

}
