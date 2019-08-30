package com.app.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitCreator {
    private static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient = null;
    private static final HttpLoggingInterceptor LOGGING = new HttpLoggingInterceptor();
    private static final Gson GSON = new GsonBuilder().create();

    static {
        LOGGING.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    public static <T> T create(Class<T> clazz) {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .addInterceptor(LOGGING)
                    .build();
        }

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(System.getProperty("server.uri"))
                    .addConverterFactory(new NullOnEmptyConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create(GSON))
                    .client(okHttpClient)
                    .build();
        }

        return retrofit.create(clazz);
    }
}
