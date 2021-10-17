
package com.example.museumrouteapp.Domain.Model.JsonObjectsPath;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Donut {

    @SerializedName("is_donut")
    @Expose
    private Boolean isDonut;

    public Boolean getIsDonut() {
        return isDonut;
    }

    public void setIsDonut(Boolean isDonut) {
        this.isDonut = isDonut;
    }

}
