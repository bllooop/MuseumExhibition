package com.example.museumrouteapp.Domain.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class News {
   private int count;
   @SerializedName("items")
   List<Items> items;

     /*   public class Attachments {
            private String type;
            public class Photo{
                private Integer id;
                private Integer album_id;
                private Integer owner_id;
                private Integer user_id;
                private String photo_75;
                private String photo_130;
                private String photo_604;
                private String photo_807;
                private String photo_1280;
                private Integer width;
                private Integer height;
                private String text;
                private long date;
                private String access_key;
            }
        }*/

    }

