package com.example.museumrouteapp.Presentation.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.museumrouteapp.Domain.Model.Route;

public class RouteViewModel extends ViewModel {

    private Route nRoute;

    public Route getRoute() {
        return nRoute;
    }

    public void setRoute(Route route) {
        nRoute = Route;
    }
}
