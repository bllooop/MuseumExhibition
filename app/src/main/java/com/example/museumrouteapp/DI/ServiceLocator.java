package com.example.museumrouteapp.DI;
import android.app.Application;

import com.example.museumrouteapp.Presentation.Repository.Mock.MockBase;
import com.example.museumrouteapp.Presentation.Repository.RepositoryTasks;
import com.example.museumrouteapp.Presentation.Repository.Room.RouteRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ServiceLocator {
    private static ServiceLocator instance = null;

    private ServiceLocator() {};

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new ServiceLocator();
        }
        return instance;
    }

    private RepositoryTasks mRepository;



    public void initBase(Application app) {
        if (mRepository == null) {
            mRepository = new RouteRepository(app);
        }
    }

    public RepositoryTasks getRepository() {
        if (mRepository == null) {
            mRepository = new MockBase();
        }
        return mRepository;
    }

}
