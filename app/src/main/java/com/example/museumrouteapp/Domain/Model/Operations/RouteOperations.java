package com.example.museumrouteapp.Domain.Model.Operations;

import com.example.museumrouteapp.Domain.Model.Route;

import java.util.List;

public class RouteOperations {
    public static Route addParty(String name,
                                 String description,
                                 List<String> images) {
        Route route = new Route();
        route.setName(name);
        route.setDescription(description);
        route.setImages(images);
        return route;
    }
}
