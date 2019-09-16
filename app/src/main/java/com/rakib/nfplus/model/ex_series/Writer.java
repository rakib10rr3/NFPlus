package com.rakib.nfplus.model.ex_series;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Writer implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = 7049181405404517092L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Writer() {
    }

    /**
     *
     * @param name
     */
    public Writer(String name) {
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
