package com.example.museumrouteapp.Presentation.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.museumrouteapp.Domain.Model.JsonObjectsPath.News;
import com.example.museumrouteapp.Presentation.Repository.ApiWork.NetworkClient;


public class NewsListViewModel extends ViewModel {
    public LiveData<News> getNewsList() {
            return new NetworkClient().getNewsListFromVk();
    }
}
