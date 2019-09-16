package com.rakib.nfplus.model.ex_series;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Season implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("season_name")
    @Expose
    private String seasonName;
    @SerializedName("episode_list")
    @Expose
    private List<EpisodeList> episodeList = null;
    private final static long serialVersionUID = -1167132292717619694L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Season() {
    }

    /**
     *
     * @param id
     * @param seasonName
     * @param episodeList
     */
    public Season(String id, String seasonName, List<EpisodeList> episodeList) {
        super();
        this.id = id;
        this.seasonName = seasonName;
        this.episodeList = episodeList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public List<EpisodeList> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(List<EpisodeList> episodeList) {
        this.episodeList = episodeList;
    }

}