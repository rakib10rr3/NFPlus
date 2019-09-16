package com.rakib.nfplus.model.ex_movies;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {

    private String videosId;
    private String imdbid;
    private String title;
    private String seoTitle;
    private String slug;
    private String description;
    private String stars;
    private String director;
    private String writer;
    private String rating;
    private String release;
    private String country;
    private String genre;
    private Object videoType;
    private String runtime;
    private String videoQuality;
    private String publication;
    private String trailer;
    private String enableDownload;
    private String focusKeyword;
    private String metaDescription;
    private String tags;
    private String imdbRating;
    private String isTvseries;
    private String totalRating;
    private String todayView;
    private String weeklyView;
    private String monthlyView;
    private String totalView;
    private String thumbnail_url;
    private String poster_url;
    private List<Country> countries = null;
    private List<Genre> genres = null;
    private List<Director> directors = null;
    private List<Writer> writers = null;
    private List<Actor> actors = null;
    private String file_url;

    /**
     * No args constructor for use in serialization
     *
     */
    public Movie() {
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
     * @param file_url
     * @param country
     * @param publication
     * @param isTvseries
     * @param stars
     * @param writers
     * @param slug
     * @param rating
     * @param focusKeyword
     * @param directors
     * @param release
     */
    public Movie(String videosId, String imdbid, String title, String seoTitle, String slug, String description, String stars, String director, String writer, String rating, String release, String country, String genre, Object videoType, String runtime, String videoQuality, String publication, String trailer, String enableDownload, String focusKeyword, String metaDescription, String tags, String imdbRating, String isTvseries, String totalRating, String todayView, String weeklyView, String monthlyView, String totalView, String thumbnailUrl, String posterUrl, List<Country> countries, List<Genre> genres, List<Director> directors, List<Writer> writers, List<Actor> actors, String file_url) {
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
        this.thumbnail_url = thumbnailUrl;
        this.poster_url = posterUrl;
        this.countries = countries;
        this.genres = genres;
        this.directors = directors;
        this.writers = writers;
        this.actors = actors;
        this.file_url = file_url;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
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

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
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

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

}