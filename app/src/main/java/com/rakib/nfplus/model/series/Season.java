package com.rakib.nfplus.model.series;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Season implements Serializable{

    @SerializedName("season_number")
    @Expose
    private String seasonNumber;
    @SerializedName("episode")
    @Expose
    private List<Episode> episode = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Season() {
    }

    /**
     *
     * @param episode
     * @param seasonNumber
     */
    public Season(String seasonNumber, List<Episode> episode) {
        super();
        this.seasonNumber = seasonNumber;
        this.episode = episode;
    }

    public String getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public List<Episode> getEpisode() {
        return episode;
    }

    public void setEpisode(List<Episode> episode) {
        this.episode = episode;
    }

}