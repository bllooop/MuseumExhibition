package com.example.museumrouteapp.Presentation.Repository.Room;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.museumrouteapp.Domain.Model.Route;
import com.example.museumrouteapp.Presentation.Repository.Model.RouteDTO;
import com.example.museumrouteapp.Presentation.Repository.RepositoryTasks;
import com.example.museumrouteapp.Presentation.Repository.Room.DAO.RouteListDAO;

import java.util.List;

public class RouteRepository implements RepositoryTasks {
    private RouteListDAO mRouteListDao;
    private LiveData<List<RouteDTO>> mAllRoute = new MutableLiveData<>();

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
        RouteRoomDatabase.databaseWriteExecutor.execute(() -> {
            mRouteListDao.addRoute(((RouteDTO) route));
        });
    }

    @Override
    public <T extends Route> void deleteRoute(T route) {
        RouteRoomDatabase.databaseWriteExecutor.execute(() -> {
            mRouteListDao.deleteRoute(((RouteDTO) route));
        });
    }
}
