package com.example.museumrouteapp.Presentation.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.museumrouteapp.DI.ServiceLocator;
import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.Presentation.Repository.Repository;

import java.util.List;

public class RouteListViewModel extends ViewModel {

    public LiveData<List<Route>> getRouteList() {
        return ServiceLocator.getInstance().getRepository().getAllRoutes();
    }

    public void deleteRoute(Route route) {
        ServiceLocator.getInstance().getRepository().deleteRoute(route);
    }
}
