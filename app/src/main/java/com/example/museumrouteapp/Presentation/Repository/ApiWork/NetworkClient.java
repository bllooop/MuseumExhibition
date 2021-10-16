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
    public static final String BASE_URL = "http://api.vk.com/method";
    public static Retrofit getRetrofitClient()
    {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                   .addInterceptor(interceptor)
                    .connectTimeout(30, TimeUnit.MINUTES)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.vk.com/method/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create()) // Convertor library used to convert response into POJO
                    .build();

            api = retrofit.create(VkApi.class);


        }
        return retrofit;

    }

}
