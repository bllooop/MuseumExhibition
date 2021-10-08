
package com.example.museumrouteapp.Domain.Model;

import androidx.room.TypeConverters;

import com.example.museumrouteapp.Presentation.Repository.Model.ImagesConverter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Route {
    public String name;
    public String description;
   @TypeConverters({ImagesConverter.class})
    private List<String> images;
   @NotNull
    private String id;

    public Route() {id = UUID.randomUUID().toString();}
    public Route(String name, String description) {
        this.name = name;
        id = UUID.randomUUID().toString();
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
    public String getId() {
        return id;
    }

    public void setId(@NotNull String id) {
        this.id = id;
    }

}
