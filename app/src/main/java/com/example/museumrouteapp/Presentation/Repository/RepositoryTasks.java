package com.example.museumrouteapp.Presentation.Repository;

import androidx.lifecycle.LiveData;

import com.example.museumrouteapp.Domain.Model.Route;

import java.util.List;

public interface RepositoryTasks {
    <T extends Route> LiveData<List<T>> getAllRoutes();
    <T extends Route> void addRoute(T route);
    <T extends Route> void deleteRoute(T route);
}
