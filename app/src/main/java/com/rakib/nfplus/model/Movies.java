package com.rakib.nfplus.model;

public class Movies {
    String name;
    String category;
    String poster;


    public Movies() {}

    public Movies(String name, String category, String poster) {
        this.name = name;
        this.category = category;
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPoster() {
        return poster;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
