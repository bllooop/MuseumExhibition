package com.example.museumrouteapp.Presentation.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.museumrouteapp.Domain.Model.Route;

public class RouteViewModel extends ViewModel {
    private Route mRoute;

    public Route getRoute() {
        return mRoute;
    }

    public void setRoute(Route Route) {
        mRoute = Route;
    }
}
