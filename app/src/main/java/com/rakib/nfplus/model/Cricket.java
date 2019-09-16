package com.rakib.nfplus.model;

public class Cricket {
    private String status;
    private String overview;
    private String homeTeamShortName;
    private String awayTeamShortName;
    private String homeTeamName;
    private String awayTeamName;
    private String homeTeamScore;
    private String awayTeamScore;
    private String homeTeamLogo;
    private String awayTeamLogo;
    private String result;

    public Cricket() {
    }

    public Cricket(String status, String overview, String homeTeamLogo, String homeTeamShortName, String homeTeamName, String homeTeamScore, String awayTeamLogo, String awayTeamShortName, String awayTeamName, String awayTeamScore, String result) {
        this.status = status;
        this.overview = overview;
        this.homeTeamLogo = homeTeamLogo;
        this.homeTeamShortName = homeTeamShortName;
        this.homeTeamName = homeTeamName;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamLogo = awayTeamLogo;
        this.awayTeamShortName = awayTeamShortName;
        this.awayTeamName = awayTeamName;
        this.awayTeamScore = awayTeamScore;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public String getOverview() {
        return overview;
    }

    public String getHomeTeamLogo() {
        return homeTeamLogo;
    }

    public String getHomeTeamShortName() {
        return homeTeamShortName;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getHomeTeamScore() {
        return homeTeamScore;
    }

    public String getAwayTeamLogo() {
        return awayTeamLogo;
    }

    public String getAwayTeamShortName() {
        return awayTeamShortName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public String getAwayTeamScore() {
        return awayTeamScore;
    }

    public String getResult() {
        return result;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setHomeTeamLogo(String homeTeamLogo) {
        this.homeTeamLogo = homeTeamLogo;
    }

    public void setHomeTeamShortName(String homeTeamShortName) {
        this.homeTeamShortName = homeTeamShortName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public void setHomeTeamScore(String homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public void setAwayTeamLogo(String awayTeamLogo) {
        this.awayTeamLogo = awayTeamLogo;
    }

    public void setAwayTeamShortName(String awayTeamShortName) {
        this.awayTeamShortName = awayTeamShortName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public void setAwayTeamScore(String awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
