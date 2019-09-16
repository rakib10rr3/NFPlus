package com.rakib.nfplus.model.series;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EpisodeData implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("TVID")
    @Expose
    private String tVID;
    @SerializedName("episode_number")
    @Expose
    private String episodeNumber;
    @SerializedName("season_number")
    @Expose
    private String seasonNumber;
    @SerializedName("EPIID")
    @Expose
    private String ePIID;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("still_path")
    @Expose
    private String stillPath;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("quality")
    @Expose
    private String quality;
    @SerializedName("watchlink")
    @Expose
    private String watchlink;
    @SerializedName("air_date")
    @Expose
    private String airDate;
    @SerializedName("up_time")
    @Expose
    private String upTime;
    @SerializedName("hit")
    @Expose
    private String hit;
    @SerializedName("upby")
    @Expose
    private String upby;
    @SerializedName("published")
    @Expose
    private String published;

    /**
     * No args constructor for use in serialization
     *
     */
    public EpisodeData() {
    }

    /**
     *
     * @param stillPath
     * @param seasonNumber
     * @param upby
     * @param tVID
     * @param episodeNumber
     * @param watchlink
     * @param id
     * @param airDate
     * @param overview
     * @param upTime
     * @param hit
     * @param name
     * @param ePIID
     * @param quality
     * @param published
     */
    public EpisodeData(String id, String tVID, String episodeNumber, String seasonNumber, String ePIID, String name, String stillPath, String overview, String quality, String watchlink, String airDate, String upTime, String hit, String upby, String published) {
        super();
        this.id = id;
        this.tVID = tVID;
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
        this.ePIID = ePIID;
        this.name = name;
        this.stillPath = stillPath;
        this.overview = overview;
        this.quality = quality;
        this.watchlink = watchlink;
        this.airDate = airDate;
        this.upTime = upTime;
        this.hit = hit;
        this.upby = upby;
        this.published = published;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTVID() {
        return tVID;
    }

    public void setTVID(String tVID) {
        this.tVID = tVID;
    }

    public String getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(String episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public String getEPIID() {
        return ePIID;
    }

    public void setEPIID(String ePIID) {
        this.ePIID = ePIID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStillPath() {
        return stillPath;
    }

    public void setStillPath(String stillPath) {
        this.stillPath = stillPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getWatchlink() {
        return watchlink;
    }

    public void setWatchlink(String watchlink) {
        this.watchlink = watchlink;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

    public String getUpby() {
        return upby;
    }

    public void setUpby(String upby) {
        this.upby = upby;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

}