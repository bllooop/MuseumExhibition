package com.example.museumrouteapp.Presentation.Repository.Room;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.Presentation.Repository.Model.RouteDTO;
import com.example.museumrouteapp.Presentation.Repository.RepositoryTasks;
import com.example.museumrouteapp.Presentation.Repository.Room.DAO.RouteListDAO;

import java.util.List;

public class RouteRepository implements RepositoryTasks {
    private RouteListDAO mRouteListDao;
    private LiveData<List<RouteDTO>> mAllRoute;

    public RouteRepository(Application application) {
        RouteRoomDatabase db = RouteRoomDatabase.getDatabase(application);
        mRouteListDao = db.routeDao();
        mAllRoute = mRouteListDao.getAllRoutes();
    }

    public LiveData<List<RouteDTO>> getAllRoutes() {
        return mAllRoute;
    }

    @Override
    public <T extends Route> void addRoute(T route) {
        RouteDTO dto = RouteDTO.convertFromRoute(route);
        RouteRoomDatabase.databaseWriteExecutor.execute(() -> {
            mRouteListDao.addRoute(dto);
        });
    }

    @Override
    public <T extends Route> void deleteRoute(T route) {
        RouteDTO dto = RouteDTO.convertFromRoute(route);
        RouteRoomDatabase.databaseWriteExecutor.execute(() -> {
            mRouteListDao.deleteRoute(dto);
        });
    }
    @Override
    public MutableLiveData<RouteDTO> findRoute(String id, LifecycleOwner owner) {
        MutableLiveData<RouteDTO> specificRoute = new MutableLiveData<>();

        mAllRoute.observe(owner, (List<RouteDTO> routes) -> {
            specificRoute.setValue(routes.stream()
                    .filter(routeDTO -> id.equals(routeDTO.getId()))
                    .findAny()
                    .orElse(null)
            );
        });
        return specificRoute;
    }

}
