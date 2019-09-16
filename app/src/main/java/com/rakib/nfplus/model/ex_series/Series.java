package com.rakib.nfplus.model.ex_series;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Series implements Serializable
{

    @SerializedName("videos_id")
    @Expose
    private String videosId;
    @SerializedName("imdbid")
    @Expose
    private String imdbid;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("seo_title")
    @Expose
    private String seoTitle;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("stars")
    @Expose
    private String stars;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("writer")
    @Expose
    private String writer;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("release")
    @Expose
    private String release;
    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("genre")
    @Expose
    private String genre;
    @SerializedName("video_type")
    @Expose
    private Object videoType;
    @SerializedName("runtime")
    @Expose
    private String runtime;
    @SerializedName("video_quality")
    @Expose
    private String videoQuality;
    @SerializedName("publication")
    @Expose
    private String publication;
    @SerializedName("trailer")
    @Expose
    private String trailer;
    @SerializedName("enable_download")
    @Expose
    private String enableDownload;
    @SerializedName("focus_keyword")
    @Expose
    private String focusKeyword;
    @SerializedName("meta_description")
    @Expose
    private String metaDescription;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("imdb_rating")
    @Expose
    private String imdbRating;
    @SerializedName("is_tvseries")
    @Expose
    private String isTvseries;
    @SerializedName("total_rating")
    @Expose
    private String totalRating;
    @SerializedName("today_view")
    @Expose
    private String todayView;
    @SerializedName("weekly_view")
    @Expose
    private String weeklyView;
    @SerializedName("monthly_view")
    @Expose
    private String monthlyView;
    @SerializedName("total_view")
    @Expose
    private String totalView;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;
    @SerializedName("poster_url")
    @Expose
    private String posterUrl;
    @SerializedName("countries")
    @Expose
    private List<Country> countries = null;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;
    @SerializedName("directors")
    @Expose
    private List<Director> directors = null;
    @SerializedName("writers")
    @Expose
    private List<Writer> writers = null;
    @SerializedName("actors")
    @Expose
    private List<Actor> actors = null;
    @SerializedName("file_url")
    @Expose
    private Object fileUrl;
    @SerializedName("seasons")
    @Expose
    private List<Season> seasons = null;
    private final static long serialVersionUID = 1458979821810810551L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Series() {
    }

    /**
     *
     * @param genre
     * @param trailer
     * @param imdbid
     * @param genres
     * @param videosId
     * @param runtime
     * @param countries
     * @param monthlyView
     * @param seoTitle
     * @param imdbRating
     * @param title
     * @param enableDownload
     * @param description
     * @param thumbnailUrl
     * @param actors
     * @param totalRating
     * @param writer
     * @param todayView
     * @param tags
     * @param weeklyView
     * @param metaDescription
     * @param totalView
     * @param posterUrl
     * @param director
     * @param videoType
     * @param videoQuality
     * @param fileUrl
     * @param country
     * @param publication
     * @param isTvseries
     * @param seasons
     * @param stars
     * @param writers
     * @param slug
     * @param rating
     * @param focusKeyword
     * @param directors
     * @param release
     */
    public Series(String videosId, String imdbid, String title, String seoTitle, String slug, String description, String stars, String director, String writer, String rating, String release, Object country, String genre, Object videoType, String runtime, String videoQuality, String publication, String trailer, String enableDownload, String focusKeyword, String metaDescription, String tags, String imdbRating, String isTvseries, String totalRating, String todayView, String weeklyView, String monthlyView, String totalView, String thumbnailUrl, String posterUrl, List<Country> countries, List<Genre> genres, List<Director> directors, List<Writer> writers, List<Actor> actors, Object fileUrl, List<Season> seasons) {
        super();
        this.videosId = videosId;
        this.imdbid = imdbid;
        this.title = title;
        this.seoTitle = seoTitle;
        this.slug = slug;
        this.description = description;
        this.stars = stars;
        this.director = director;
        this.writer = writer;
        this.rating = rating;
        this.release = release;
        this.country = country;
        this.genre = genre;
        this.videoType = videoType;
        this.runtime = runtime;
        this.videoQuality = videoQuality;
        this.publication = publication;
        this.trailer = trailer;
        this.enableDownload = enableDownload;
        this.focusKeyword = focusKeyword;
        this.metaDescription = metaDescription;
        this.tags = tags;
        this.imdbRating = imdbRating;
        this.isTvseries = isTvseries;
        this.totalRating = totalRating;
        this.todayView = todayView;
        this.weeklyView = weeklyView;
        this.monthlyView = monthlyView;
        this.totalView = totalView;
        this.thumbnailUrl = thumbnailUrl;
        this.posterUrl = posterUrl;
        this.countries = countries;
        this.genres = genres;
        this.directors = directors;
        this.writers = writers;
        this.actors = actors;
        this.fileUrl = fileUrl;
        this.seasons = seasons;
    }

    public String getVideosId() {
        return videosId;
    }

    public void setVideosId(String videosId) {
        this.videosId = videosId;
    }

    public String getImdbid() {
        return imdbid;
    }

    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Object getVideoType() {
        return videoType;
    }

    public void setVideoType(Object videoType) {
        this.videoType = videoType;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getVideoQuality() {
        return videoQuality;
    }

    public void setVideoQuality(String videoQuality) {
        this.videoQuality = videoQuality;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getEnableDownload() {
        return enableDownload;
    }

    public void setEnableDownload(String enableDownload) {
        this.enableDownload = enableDownload;
    }

    public String getFocusKeyword() {
        return focusKeyword;
    }

    public void setFocusKeyword(String focusKeyword) {
        this.focusKeyword = focusKeyword;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getIsTvseries() {
        return isTvseries;
    }

    public void setIsTvseries(String isTvseries) {
        this.isTvseries = isTvseries;
    }

    public String getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(String totalRating) {
        this.totalRating = totalRating;
    }

    public String getTodayView() {
        return todayView;
    }

    public void setTodayView(String todayView) {
        this.todayView = todayView;
    }

    public String getWeeklyView() {
        return weeklyView;
    }

    public void setWeeklyView(String weeklyView) {
        this.weeklyView = weeklyView;
    }

    public String getMonthlyView() {
        return monthlyView;
    }

    public void setMonthlyView(String monthlyView) {
        this.monthlyView = monthlyView;
    }

    public String getTotalView() {
        return totalView;
    }

    public void setTotalView(String totalView) {
        this.totalView = totalView;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<Writer> getWriters() {
        return writers;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Object getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(Object fileUrl) {
        this.fileUrl = fileUrl;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

}
