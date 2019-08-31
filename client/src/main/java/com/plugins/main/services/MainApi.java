package com.plugins.main.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApi {

    @GET("message")
    Call<String> changeMessages(@Query("message") String message);

}
