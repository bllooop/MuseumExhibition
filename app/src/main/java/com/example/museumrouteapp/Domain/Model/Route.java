
package com.example.museumrouteapp.Domain.Model;

import androidx.room.TypeConverters;

import com.example.museumrouteapp.Presentation.Repository.Model.ImagesConverter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Route {
    public String name;
    public String description;
   @TypeConverters({ImagesConverter.class})
    private List<String> images;
   @NotNull
    private int id;
    private static final AtomicInteger count = new AtomicInteger(0);
    public Route() { id = count.incrementAndGet();}
    public Route(String name, String description) {
        this.name = name;
        id = count.incrementAndGet();
        images = new ArrayList<>();

        this.description = description;

    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public List<String> getImages() { return images; }
    public void setImages(List<String> images) { this.images = images; }
    public int getId() {
        return id;
    }

    public void setId(@NotNull int id) {
        this.id = id;
    }

}
