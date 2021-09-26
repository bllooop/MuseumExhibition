package com.example.museumrouteapp.Presentation.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.Presentation.Repository.Repository;

import java.util.List;

public class RouteListViewModel extends ViewModel {

    public LiveData<List<Route>> getRouteList() {
        return Repository.getRepository().getAllRoutes();
    }

    public void deleteRoute(Route route) {
        Repository.getRepository().deleteRoute(route);
    }
}
