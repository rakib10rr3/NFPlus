package com.rakib.nfplus.model.ex_series;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Director implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = 1950633676174735026L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Director() {
    }

    /**
     *
     * @param name
     */
    public Director(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}