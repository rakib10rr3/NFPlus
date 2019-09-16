package com.rakib.nfplus.model.ex_series;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EpisodeList implements Serializable
{

    @SerializedName("episodes_id")
    @Expose
    private String episodesId;
    @SerializedName("stream_key")
    @Expose
    private String streamKey;
    @SerializedName("videos_id")
    @Expose
    private String videosId;
    @SerializedName("seasons_id")
    @Expose
    private String seasonsId;
    @SerializedName("episodes_name")
    @Expose
    private String episodesName;
    @SerializedName("file_source")
    @Expose
    private String fileSource;
    @SerializedName("source_type")
    @Expose
    private String sourceType;
    @SerializedName("file_url")
    @Expose
    private String fileUrl;
    private final static long serialVersionUID = 5740946378337968460L;

    /**
     * No args constructor for use in serialization
     *
     */
    public EpisodeList() {
    }

    /**
     *
     * @param sourceType
     * @param episodesId
     * @param videosId
     * @param seasonsId
     * @param episodesName
     * @param streamKey
     * @param fileSource
     * @param fileUrl
     */
    public EpisodeList(String episodesId, String streamKey, String videosId, String seasonsId, String episodesName, String fileSource, String sourceType, String fileUrl) {
        super();
        this.episodesId = episodesId;
        this.streamKey = streamKey;
        this.videosId = videosId;
        this.seasonsId = seasonsId;
        this.episodesName = episodesName;
        this.fileSource = fileSource;
        this.sourceType = sourceType;
        this.fileUrl = fileUrl;
    }

    public String getEpisodesId() {
        return episodesId;
    }

    public void setEpisodesId(String episodesId) {
        this.episodesId = episodesId;
    }

    public String getStreamKey() {
        return streamKey;
    }

    public void setStreamKey(String streamKey) {
        this.streamKey = streamKey;
    }

    public String getVideosId() {
        return videosId;
    }

    public void setVideosId(String videosId) {
        this.videosId = videosId;
    }

    public String getSeasonsId() {
        return seasonsId;
    }

    public void setSeasonsId(String seasonsId) {
        this.seasonsId = seasonsId;
    }

    public String getEpisodesName() {
        return episodesName;
    }

    public void setEpisodesName(String episodesName) {
        this.episodesName = episodesName;
    }

    public String getFileSource() {
        return fileSource;
    }

    public void setFileSource(String fileSource) {
        this.fileSource = fileSource;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

}
