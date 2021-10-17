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


    private String from_id;
    private Integer marked_as_ads;

    public String getPost_type() {
        return post_type;
    }

    private String post_type;

    public Integer getIs_pinned() {
        return is_pinned;
    }

    private Integer is_pinned;

    public long getDate() {
        return date;
    }
    private long date;
    public class Attachments {
        private String type;
        public class Photo{
            private Integer id;
            private Integer album_id;
            private Integer owner_id;
            private Integer user_id;
            private Integer width;
            private Integer height;
            private String text;
            private long date;
            private String has_tags;
            private String post_id;
            private String access_key;
            private Sizes sizes;
            public class Sizes{
                private Integer height;
                private String url;
                private String type;
                private Integer width;
            }
        }
    }
    private Comments comments;
    public class Comments {
        private Integer can_post;
        private Integer count;
    }
    private Post_source post_source;
    public class Post_source {
        private String type;
    }
    private Likes likes;
    public class Likes {
        private Integer can_like;
        private Integer count;
        private Integer user_likes;
        private Integer can_publish;
    }
    private Reposts reposts;
    public class Reposts {
        private Integer count;
        private Integer user_reposted;
    }
    private Views views;
    public class Views {
        private Integer count;
    }
    private Boolean is_favorite;
    private Donut donut;
    public class Donut{
        private Boolean is_donut;
    }
    private double short_text_rate;
    private Integer carousel_offset;
    private String hash;

}
