package com.rakib.nfplus.model.ex_movies;

import java.io.Serializable;

public class Actor implements Serializable {

    private String name;

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