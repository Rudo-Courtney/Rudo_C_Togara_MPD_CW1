package com.example.practice_coursework.m_DataObject;

public class Roadwork {
    private String title;
    private String description;
    private String road;
    private String pubDate;
    private String region;
    private String county;
    private String latitude;
    private String longitude;
    private String startDate;
    private String endDate;

    // Default Constructor
    public Roadwork(String title, String description, String road, String pubDate,String region, String county, String latitude, String longitude, String startDate, String endDate)
    {
        this.title="";
        this.description="";
        this.road="";
        this.pubDate="";
        this.region="";
        this.county="";
        this.latitude="";
        this.longitude="";
        this.startDate="";
        this.endDate="";
    }
    public Roadwork(){
        this.title="";
        this.description="";
        this.road="";
        this.pubDate="";
        this.region="";
        this.county="";
        this.latitude="";
        this.longitude="";
        this.startDate="";
        this.endDate="";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String road) {
        this.pubDate = pubDate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String road) {
        this.region = region;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String road) {
        this.county = county;
    }


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEventEnd() {
        return endDate;
    }

    public void setEndDate(String eventEnd) {
        this.endDate = eventEnd;
    }

    public String toString()
    {
        String roadwork= "";
        roadwork+= "========NewData=========" + "\n"
                +title + "\n"
                +"==========================" + "\n"
                +description     + "\n"
                +"==========================" + "\n"
                +road     + "\n"
                +"==========================" + "\n"
                +pubDate     + "\n"
                +"==========================" + "\n"
                +region    + "\n"
                +"==========================" + "\n"
                +county     + "\n"
                +"==========================" + "\n"
                +latitude     + "\n"
                +"==========================" + "\n"
                +longitude     + "\n"
                +"==========================" + "\n"
                +startDate     + "\n"
                +"==========================" + "\n"
                +endDate + "\n"
                +"==========================" + "\n";

        return roadwork;
    }
}