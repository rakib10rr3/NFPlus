package com.rakib.nfplus.model;

public class Series {
    String name;
    String category;
    String poster;
    int numberOfSeasons;

    public Series() {}

    public Series(String name, String category, String poster, int numberOfSeasons) {
        this.name = name;
        this.category = category;
        this.poster = poster;
        this.numberOfSeasons = numberOfSeasons;
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

    public int getNumberOfSeasons() {
        return numberOfSeasons;
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

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }
}
