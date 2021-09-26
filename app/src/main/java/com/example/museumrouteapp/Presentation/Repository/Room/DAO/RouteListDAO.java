package com.example.museumrouteapp.Presentation.Repository.Room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.museumrouteapp.Presentation.Repository.Model.RouteDTO;

import java.util.List;

@Dao
public interface RouteListDAO {
    @Insert
    void addRoute(RouteDTO route);
    @Delete
    void deleteRoute(RouteDTO route);
    @Query("SELECT * FROM route")
    LiveData<List<RouteDTO>> getAllRoutes();
}