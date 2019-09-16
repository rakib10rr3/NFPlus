package com.rakib.nfplus.model.series;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Series implements Serializable{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("TVposter")
    @Expose
    private String tVposter;
    @SerializedName("backdrop")
    @Expose
    private String backdrop;
    @SerializedName("TVcategory")
    @Expose
    private String tVcategory;
    @SerializedName("TVrelease")
    @Expose
    private String tVrelease;
    @SerializedName("TVgenre")
    @Expose
    private String tVgenre;
    @SerializedName("TVtitle")
    @Expose
    private String tVtitle;
    @SerializedName("TVID")
    @Expose
    private String tVID;
    @SerializedName("TVtrailer")
    @Expose
    private String tVtrailer;
    @SerializedName("TVRatings")
    @Expose
    private String tVRatings;
    @SerializedName("TVruntime")
    @Expose
    private String tVruntime;
    @SerializedName("TVlang")
    @Expose
    private String tVlang;
    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("TVstory")
    @Expose
    private String tVstory;
    @SerializedName("uploadedUser")
    @Expose
    private String uploadedUser;
    @SerializedName("uploadTime")
    @Expose
    private String uploadTime;
    @SerializedName("completed")
    @Expose
    private String completed;
    @SerializedName("missing")
    @Expose
    private String missing;
    @SerializedName("seasons")
    @Expose
    private List<Season> seasons = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Series() {
    }

    /**
     *
     * @param tVgenre
     * @param tVposter
     * @param tVRatings
     * @param tVtrailer
     * @param uploadedUser
     * @param tVID
     * @param tVrelease
     * @param backdrop
     * @param missing
     * @param id
     * @param tVtitle
     * @param tVlang
     * @param seasons
     * @param views
     * @param tVcategory
     * @param uploadTime
     * @param tVruntime
     * @param completed
     * @param tVstory
     */
    public Series(String id, String tVposter, String backdrop, String tVcategory, String tVrelease, String tVgenre, String tVtitle, String tVID, String tVtrailer, String tVRatings, String tVruntime, String tVlang, String views, String tVstory, String uploadedUser, String uploadTime, String completed, String missing, List<Season> seasons) {
        super();
        this.id = id;
        this.tVposter = tVposter;
        this.backdrop = backdrop;
        this.tVcategory = tVcategory;
        this.tVrelease = tVrelease;
        this.tVgenre = tVgenre;
        this.tVtitle = tVtitle;
        this.tVID = tVID;
        this.tVtrailer = tVtrailer;
        this.tVRatings = tVRatings;
        this.tVruntime = tVruntime;
        this.tVlang = tVlang;
        this.views = views;
        this.tVstory = tVstory;
        this.uploadedUser = uploadedUser;
        this.uploadTime = uploadTime;
        this.completed = completed;
        this.missing = missing;
        this.seasons = seasons;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTVposter() {
        return tVposter;
    }

    public void setTVposter(String tVposter) {
        this.tVposter = tVposter;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getTVcategory() {
        return tVcategory;
    }

    public void setTVcategory(String tVcategory) {
        this.tVcategory = tVcategory;
    }

    public String getTVrelease() {
        return tVrelease;
    }

    public void setTVrelease(String tVrelease) {
        this.tVrelease = tVrelease;
    }

    public String getTVgenre() {
        return tVgenre;
    }

    public void setTVgenre(String tVgenre) {
        this.tVgenre = tVgenre;
    }

    public String getTVtitle() {
        return tVtitle;
    }

    public void setTVtitle(String tVtitle) {
        this.tVtitle = tVtitle;
    }

    public String getTVID() {
        return tVID;
    }

    public void setTVID(String tVID) {
        this.tVID = tVID;
    }

    public String getTVtrailer() {
        return tVtrailer;
    }

    public void setTVtrailer(String tVtrailer) {
        this.tVtrailer = tVtrailer;
    }

    public String getTVRatings() {
        return tVRatings;
    }

    public void setTVRatings(String tVRatings) {
        this.tVRatings = tVRatings;
    }

    public String getTVruntime() {
        return tVruntime;
    }

    public void setTVruntime(String tVruntime) {
        this.tVruntime = tVruntime;
    }

    public String getTVlang() {
        return tVlang;
    }

    public void setTVlang(String tVlang) {
        this.tVlang = tVlang;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getTVstory() {
        return tVstory;
    }

    public void setTVstory(String tVstory) {
        this.tVstory = tVstory;
    }

    public String getUploadedUser() {
        return uploadedUser;
    }

    public void setUploadedUser(String uploadedUser) {
        this.uploadedUser = uploadedUser;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getMissing() {
        return missing;
    }

    public void setMissing(String missing) {
        this.missing = missing;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

}