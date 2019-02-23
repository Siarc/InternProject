package com.aminul.internproject.utils;

import com.aminul.internproject.model.DataModelResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {


    /**
     * Gets all the data from the given url
     */
    @GET("data.json")
    Call<DataModelResponse> getData();

}
