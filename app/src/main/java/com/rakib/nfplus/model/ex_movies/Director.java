package com.rakib.nfplus.model.ex_movies;

import java.io.Serializable;

public class Director implements Serializable {

    private String name;

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