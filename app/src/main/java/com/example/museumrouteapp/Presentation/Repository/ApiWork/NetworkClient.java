package com.example.museumrouteapp.Presentation.Repository.ApiWork;

import android.util.Config;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.museumrouteapp.Domain.Model.JsonObjectsPath.News;
import com.example.museumrouteapp.Presentation.View.Adapters.NewsListAdapter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {
    private VkApi api;

    public NetworkClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vk.com/")
                .addConverterFactory(GsonConverterFactory.create()) // Convertor library used to convert response into POJO
                .build();
        api = retrofit.create(VkApi.class);
    }

    public LiveData<News> getNewsListFromVk() {
        MutableLiveData<News> newss = new MutableLiveData<>();
        Call<News> call = api.getresponse("-39575430", "0", "30", "5.131", "0", "service key");
                call.enqueue(new Callback<News>() {
                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        if (!response.isSuccessful()) {
                            return;
                        }
                        if (response.isSuccessful()) {
                            newss.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {
                    }
                });
                return newss;
    }
}

