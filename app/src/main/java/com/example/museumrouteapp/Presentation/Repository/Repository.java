package com.example.museumrouteapp.Presentation.Repository;

import android.app.Application;

import com.example.museumrouteapp.Presentation.Repository.Mock.MockBase;
import com.example.museumrouteapp.Presentation.Repository.Room.RouteRepository;

public class Repository {
    static RepositoryTasks repository;

    static public void init(Application application) {
        if (repository == null) {
            repository = new RouteRepository(application);
        }
    }

    static public RepositoryTasks getRepository() {
        if (repository == null) {
            repository = new MockBase();
        }
        return repository;
    }
}
