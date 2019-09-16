package com.rakib.nfplus.model.series;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Episode implements Serializable{

    @SerializedName("episode_number")
    @Expose
    private String episodeNumber;
    @SerializedName("episode_data")
    @Expose
    private EpisodeData episodeData;

    /**
     * No args constructor for use in serialization
     *
     */
    public Episode() {
    }

    /**
     *
     * @param episodeData
     * @param episodeNumber
     */
    public Episode(String episodeNumber, EpisodeData episodeData) {
        super();
        this.episodeNumber = episodeNumber;
        this.episodeData = episodeData;
    }

    public String getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(String episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public EpisodeData getEpisodeData() {
        return episodeData;
    }

    public void setEpisodeData(EpisodeData episodeData) {
        this.episodeData = episodeData;
    }

}