package com.example.museumrouteapp.Domain.Model;

import com.google.gson.annotations.SerializedName;

public class News {
    public String getText() {
        return text;
    }


    @SerializedName("body")
    private String text;
}
