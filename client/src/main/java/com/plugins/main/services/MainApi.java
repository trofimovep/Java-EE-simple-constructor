package com.plugins.main.services;

import com.plugins.main.dto.ExampleDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApi {

    @GET("message")
    Call<String> changeMessages(@Query("message") String message);

    @GET("dto")
    Call<ExampleDto> getExampleDto(@Query("id") long id);

}
