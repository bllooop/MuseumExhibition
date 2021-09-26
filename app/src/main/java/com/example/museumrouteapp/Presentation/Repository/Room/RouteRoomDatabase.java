package com.example.museumrouteapp.Presentation.Repository.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.museumrouteapp.Presentation.Repository.Model.RouteDTO;
import com.example.museumrouteapp.Presentation.Repository.Room.DAO.RouteListDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {RouteDTO.class}, version = 1, exportSchema = false)
public abstract class RouteRoomDatabase extends RoomDatabase {
    public abstract RouteListDAO routeDao();

    private static volatile RouteRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static RouteRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RouteRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RouteRoomDatabase.class, "routesmuseum")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
