
package com.example.museumrouteapp.Domain.Model;

public class Route {
    public String name;
    public String description;

    public Route() {}
    public Route(String name, String description) {
        this.name = name;

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
}
