package com.example.museumrouteapp.Domain.Model;

import com.google.gson.annotations.SerializedName;

public class Items {
    public Integer getId() {
        return id;
    }
    @SerializedName("id")
    private Integer id;

    public String getText() {
        return text;
    }


    @SerializedName("text")
    private String text;

    public Integer getMarked_as_ads() {
        return marked_as_ads;
    }

    public String getFrom_id() {
        return from_id;
    }

    public Integer getCan_pin() {
        return can_pin;
    }

    private String from_id;
    private Integer marked_as_ads;

    public String getPost_type() {
        return post_type;
    }

    private String post_type;
    private Integer can_pin;

    public long getDate() {
        return date;
    }
    private long date;
}
