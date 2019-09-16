package com.rakib.nfplus.model.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BackdropList implements Serializable {

    @SerializedName("backdrop")
    @Expose
    private String backdrop;

    /**
     * No args constructor for use in serialization
     *
     */
    public BackdropList() {
    }

    /**
     *
     * @param backdrop
     */
    public BackdropList(String backdrop) {
        super();
        this.backdrop = backdrop;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

}