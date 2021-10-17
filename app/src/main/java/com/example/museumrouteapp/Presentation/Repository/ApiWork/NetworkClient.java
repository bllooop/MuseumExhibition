package com.example.museumrouteapp.Presentation.Repository.ApiWork;

import android.util.Config;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {
    public static Retrofit retrofit;
    private static VkApi api;
    public static Retrofit getRetrofitClient()
    {

        retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.vk.com/method/")
                    .addConverterFactory(GsonConverterFactory.create()) // Convertor library used to convert response into POJO
                    .build();

        return retrofit;

    }

}
