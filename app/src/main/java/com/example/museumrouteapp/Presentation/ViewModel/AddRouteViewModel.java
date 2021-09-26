package com.example.museumrouteapp.Presentation.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.museumrouteapp.Presentation.Repository.Model.RouteDTO;
import com.example.museumrouteapp.Presentation.Repository.Repository;

public class AddRouteViewModel extends ViewModel {
    public void AddRoute(String name, String description) {
        RouteDTO route = new RouteDTO();
        route.setName(name);
        route.setDescription(description);
        Repository.getRepository().addRoute(route);
    }
}
