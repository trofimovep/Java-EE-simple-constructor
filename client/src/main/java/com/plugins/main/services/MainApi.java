package com.plugins.main.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApi {

    @GET("server/message")
    Call<String> changeMessages(@Query("cleintMessage") String cleintMessage);

}
