package com.aminul.internproject.utils;

import com.aminul.internproject.model.DataModelResponse;

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
    Call<DataModelResponse> getData();

}
