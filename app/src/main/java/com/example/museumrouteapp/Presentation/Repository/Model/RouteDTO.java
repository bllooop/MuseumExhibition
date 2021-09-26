package com.example.museumrouteapp.Presentation.Repository.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.museumrouteapp.Domain.Model.Route;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "route")
public class RouteDTO extends Route {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo
    public int id;
}