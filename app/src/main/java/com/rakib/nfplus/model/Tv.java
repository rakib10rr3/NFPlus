package com.rakib.nfplus.model;

public class Tv {
    String name;
    String thumbnail;
    String link;

    public Tv() {}

    public Tv(String name, String thumbnail, String link) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getLink() {
        return link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
