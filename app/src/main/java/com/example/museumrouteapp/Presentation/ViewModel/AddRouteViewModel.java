package com.example.museumrouteapp.Presentation.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.museumrouteapp.Domain.Model.Operations.RouteOperations;
import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.Presentation.Repository.Model.RouteDTO;
import com.example.museumrouteapp.Presentation.Repository.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AddRouteViewModel extends ViewModel {
    public void AddRoute(String name, String description, List<String> images) {
        Route route = RouteOperations.addRoute(
                name,
                description,
                images.stream().filter(Objects::nonNull).collect(Collectors.toList())
        );

        ServiceLocator.getInstance().getRepository().addParty(route);
    }
}
