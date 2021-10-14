package com.example.museumrouteapp.Presentation.Repository.ApiWork;

import android.media.audiofx.DynamicsProcessing;
import android.util.Config;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {
    public static Retrofit retrofit;
    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.level(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
//                    .addInterceptor(interceptor)
                    .connectTimeout(30, TimeUnit.MINUTES)
                    .build();
            public static final String BASE_URL = "http://api.example.com/";
            retrofit = new Retrofit.Builder()
                    .baseUrl(DynamicsProcessing.Config.BASE_URL) //This is the only mandatory call on Builder object.
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create()) // Convertor library used to convert response into POJO
                    .build();

        }
        return retrofit;

    }

}
