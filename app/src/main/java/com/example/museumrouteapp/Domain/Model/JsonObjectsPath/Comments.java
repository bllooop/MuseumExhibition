
package com.example.museumrouteapp.Domain.Model.JsonObjectsPath;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Comments {

    @SerializedName("can_post")
    @Expose
    private Integer canPost;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("groups_can_post")
    @Expose
    private Boolean groupsCanPost;

    public Integer getCanPost() {
        return canPost;
    }

    public void setCanPost(Integer canPost) {
        this.canPost = canPost;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getGroupsCanPost() {
        return groupsCanPost;
    }

    public void setGroupsCanPost(Boolean groupsCanPost) {
        this.groupsCanPost = groupsCanPost;
    }

}
