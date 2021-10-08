package com.example.museumrouteapp.Presentation.Repository.Mock;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.Presentation.Repository.Model.RouteDTO;
import com.example.museumrouteapp.Presentation.Repository.RepositoryTasks;

import java.util.ArrayList;
import java.util.List;
public class MockBase implements RepositoryTasks {//
    MutableLiveData<List<Route>> data;
    List<Route> list;

    public MutableLiveData<List<Route>> getAllRoutes() {
        return data;
    }

    public MockBase() {
        list = new ArrayList<>();
        Route route1 = new Route("Экспозиция земноводныss", "экспонаты земноводных");
        //list.add(route1);
        Route route2 = new Route("Экспонаты млекопитающихся", "экспонаты млекопитающихся");
        //list.add(route2);

        data = new MutableLiveData<>(list);
    }

    public <T extends Route> void addRoute(T route) {
        list.add(route);

        data.setValue(list);
    }

    @Override
    public <T extends Route> void deleteRoute(T route) {
        list.remove(route);

        data.setValue(list);
    }

    @Override
    public MutableLiveData<Route> findRoute(String id, LifecycleOwner owner) {
        MutableLiveData<Route> specificRoute = new MutableLiveData<>();

        data.observe(owner, (List<Route> routes) -> {
            specificRoute.setValue(routes.stream()
                    .filter(route -> id.equals(route.getId()))
                    .findAny()
                    .orElse(null)
            );
        });

        return specificRoute;
    }

}