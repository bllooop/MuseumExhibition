package com.example.museumrouteapp.Domain.Model;

import com.google.gson.annotations.SerializedName;

public class Response2 {
        public int getCount() {
            return count;
        }

        @SerializedName("count")
        private int count;
        @SerializedName("items")
        private Items items;
    }

