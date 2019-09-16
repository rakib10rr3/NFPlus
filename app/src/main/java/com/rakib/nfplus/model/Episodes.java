package com.rakib.nfplus.model;

public class Episodes {
    String name;
    String description;
    String thumbnail;
    int runTime;
    int episodeNo;

    public Episodes() {}

    public Episodes(int episodeNo, String name, String description, String thumbnail, int runTime) {
        this.episodeNo = episodeNo;
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.runTime = runTime;
    }

    public int getEpisodeNo() {
        return episodeNo;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public void setEpisodeNo(int episodeNo) {
        this.episodeNo = episodeNo;
    }
}
