package com.app.base;

import com.app.base.ErrorMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.plugins.main.services.ServiceException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.concurrent.CompletableFuture;

public class MainServiceCallback<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public MainServiceCallback(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.isSuccessful()) {

            future.complete(response.body());

        } else {

            Gson gson = new GsonBuilder().create();

            try {

                ErrorMessage message = gson.fromJson(response.errorBody().string(), ErrorMessage.class);

                future.completeExceptionally(new ServiceException(message.getMessage()));

            } catch (Exception e) {

                e.printStackTrace();

                future.completeExceptionally(
                        new ServiceException("Unknown error accessing server"));
            }
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

        t.printStackTrace();

        future.completeExceptionally(new ServiceException("Server is not available"));

    }
}

