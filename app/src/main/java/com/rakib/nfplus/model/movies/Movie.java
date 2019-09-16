package com.rakib.nfplus.model.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("MovieTitle")
    @Expose
    private String movieTitle;
    @SerializedName("MovieYear")
    @Expose
    private String movieYear;
    @SerializedName("MovieID")
    @Expose
    private String movieID;
    @SerializedName("MovieQuality")
    @Expose
    private String movieQuality;
    @SerializedName("MovieCategory")
    @Expose
    private String movieCategory;
    @SerializedName("MovieTrailer")
    @Expose
    private String movieTrailer;
    @SerializedName("MovieRatings")
    @Expose
    private String movieRatings;
    @SerializedName("MovieGenre")
    @Expose
    private String movieGenre;
    @SerializedName("MovieDate")
    @Expose
    private Object movieDate;
    @SerializedName("Movielang")
    @Expose
    private Object movieLang;
    @SerializedName("Moviehomepage")
    @Expose
    private Object movieHomePage;
    @SerializedName("MovieRuntime")
    @Expose
    private String movieRuntime;
    @SerializedName("MovieStory")
    @Expose
    private String movieStory;
    @SerializedName("MovieWatchLink")
    @Expose
    private String movieWatchLink;
    @SerializedName("MovieSubtitle")
    @Expose
    private Object movieSubtitle;
    @SerializedName("MovieActors")
    @Expose
    private String movieActors;
    @SerializedName("MovieSize")
    @Expose
    private String movieSize;
    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("uploadedUser")
    @Expose
    private String uploadedUser;
    @SerializedName("uploadTime")
    @Expose
    private Object uploadTime;
    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("published")
    @Expose
    private Object published;
    @SerializedName("DownHit")
    @Expose
    private Object downHit;
    @SerializedName("Poster_url")
    @Expose
    private String posterUrl;
    @SerializedName("backdrop_list")
    @Expose
    private List<BackdropList> backdropList = null;

    private final static long serialVersionUID = -1127281137886964491L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Movie() {
    }

    /**
     *
     * @param movieStory
     * @param movieSubtitle
     * @param movieTitle
     * @param movieGenre
     * @param id
     * @param movieWatchLink
     * @param downHit
     * @param movieRuntime
     * @param uploadTime
     * @param published
     * @param movieActors
     * @param movieID
     * @param movieCategory
     * @param movieHomePage
     * @param movieSize
     * @param movieDate
     * @param movieRatings
     * @param posterUrl
     * @param movieLang
     * @param uploadedUser
     * @param movieTrailer
     * @param movieYear
     * @param views
     * @param movieQuality
     * @param poster
     */
    public Movie(String id, String movieTitle, String movieYear, String movieID, String movieQuality, String movieCategory, String movieTrailer, String movieRatings, String movieGenre, Object movieDate, Object movieLang, Object movieHomePage, String movieRuntime, String movieStory, String movieWatchLink, Object movieSubtitle, String movieActors, String movieSize, String poster, String uploadedUser, Object uploadTime, String views, Object published, Object downHit, String posterUrl, List<BackdropList> backdropList) {
        super();
        this.id = id;
        this.movieTitle = movieTitle;
        this.movieYear = movieYear;
        this.movieID = movieID;
        this.movieQuality = movieQuality;
        this.movieCategory = movieCategory;
        this.movieTrailer = movieTrailer;
        this.movieRatings = movieRatings;
        this.movieGenre = movieGenre;
        this.movieDate = movieDate;
        this.movieLang = movieLang;
        this.movieHomePage = movieHomePage;
        this.movieRuntime = movieRuntime;
        this.movieStory = movieStory;
        this.movieWatchLink = movieWatchLink;
        this.movieSubtitle = movieSubtitle;
        this.movieActors = movieActors;
        this.movieSize = movieSize;
        this.poster = poster;
        this.uploadedUser = uploadedUser;
        this.uploadTime = uploadTime;
        this.views = views;
        this.published = published;
        this.downHit = downHit;
        this.posterUrl = posterUrl;
        this.backdropList = backdropList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getMovieQuality() {
        return movieQuality;
    }

    public void setMovieQuality(String movieQuality) {
        this.movieQuality = movieQuality;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public String getMovieTrailer() {
        return movieTrailer;
    }

    public void setMovieTrailer(String movieTrailer) {
        this.movieTrailer = movieTrailer;
    }

    public String getMovieRatings() {
        return movieRatings;
    }

    public void setMovieRatings(String movieRatings) {
        this.movieRatings = movieRatings;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public Object getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(Object movieDate) {
        this.movieDate = movieDate;
    }

    public Object getMovieLang() {
        return movieLang;
    }

    public void setMovieLang(Object movieLang) {
        this.movieLang = movieLang;
    }

    public Object getMovieHomePage() {
        return movieHomePage;
    }

    public void setMovieHomePage(Object movieHomePage) {
        this.movieHomePage = movieHomePage;
    }

    public String getMovieRuntime() {
        return movieRuntime;
    }

    public void setMovieRuntime(String movieRuntime) {
        this.movieRuntime = movieRuntime;
    }

    public String getMovieStory() {
        return movieStory;
    }

    public void setMovieStory(String movieStory) {
        this.movieStory = movieStory;
    }

    public String getMovieWatchLink() {
        return movieWatchLink;
    }

    public void setMovieWatchLink(String movieWatchLink) {
        this.movieWatchLink = movieWatchLink;
    }

    public Object getMovieSubtitle() {
        return movieSubtitle;
    }

    public void setMovieSubtitle(Object movieSubtitle) {
        this.movieSubtitle = movieSubtitle;
    }

    public String getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(String movieActors) {
        this.movieActors = movieActors;
    }

    public String getMovieSize() {
        return movieSize;
    }

    public void setMovieSize(String movieSize) {
        this.movieSize = movieSize;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getUploadedUser() {
        return uploadedUser;
    }

    public void setUploadedUser(String uploadedUser) {
        this.uploadedUser = uploadedUser;
    }

    public Object getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Object uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public Object getPublished() {
        return published;
    }

    public void setPublished(Object published) {
        this.published = published;
    }

    public Object getDownHit() {
        return downHit;
    }

    public void setDownHit(Object downHit) {
        this.downHit = downHit;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public List<BackdropList> getBackdropList() {
        return backdropList;
    }

    public void setBackdropList(List<BackdropList> backdropList) {
        this.backdropList = backdropList;
    }

}
