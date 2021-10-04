package com.example.museumrouteapp.Presentation.Repository.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.museumrouteapp.Domain.Model.Route;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity(tableName = "route")
public class RouteDTO extends Route {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo
    public int id;
    @TypeConverters({ImagesConverter.class})
    public List<String> imagesDTO;

    /*public String getImagesDTO() {
        return imagesDTO;
    }


    public void setImagesDTO(String imagesDTO) {
        this.imagesDTO = imagesDTO;
        super.setImages(new Gson().fromJson(this.imagesDTO, List.class));
    }

    @Override
    public List<String> getImages() {
        if (super.getImages() == null || super.getImages().isEmpty()) {
            super.setImages(new Gson().fromJson(this.imagesDTO, List.class));
        }
        return super.getImages();
    }

    @Override
    public void setImages(List<String> images) {
        super.setImages(images);
        this.imagesDTO = new Gson().toJson(images);
    }
*/
    public static RouteDTO convertFromRoute(Route route) {
        RouteDTO dto = new RouteDTO();
        dto.setImages(route.getImages());
        dto.setName(route.getName());
        dto.setDescription(route.getDescription());
        dto.setId(route.getId());
        return dto;
    }

}