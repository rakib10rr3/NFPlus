package com.rakib.nfplus.model.ex_series;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Actor implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = 1819222154784868482L;

    /**
     * No args constructor for use in serialization
     */
    public Actor() {
    }

    /**
     * @param name
     */
    public Actor(String name) {
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