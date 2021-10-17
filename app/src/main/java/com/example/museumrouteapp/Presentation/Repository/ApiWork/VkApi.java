package com.example.museumrouteapp.Presentation.Repository.ApiWork;


import com.example.museumrouteapp.Domain.Model.JsonObjectsPath.Item;
import com.example.museumrouteapp.Domain.Model.JsonObjectsPath.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VkApi {
    @GET("method/wall.get")
    Call<News> getresponse (@Query("owner_id") String OWNER_ID,
                                  @Query("offset") String OFFSET, @Query("count") String COUNT,
                                  @Query("v") String version, @Query("extended") String extended, @Query("access_token") String access_token);
}