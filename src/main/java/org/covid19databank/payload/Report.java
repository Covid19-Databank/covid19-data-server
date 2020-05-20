package org.covid19databank.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Report {

    private String country;
    private String state;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;

    @JsonProperty("last_updated")
    private String lastUpdated;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("daily_confirmed")
    private Integer dailyConfirmed;

    @JsonProperty("daily_deaths")
    private Integer dailyDeaths;
    private Integer critical;
    private Integer tests;


    public Report() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getDailyConfirmed() {
        return dailyConfirmed;
    }

    public void setDailyConfirmed(Integer dailyConfirmed) {
        this.dailyConfirmed = dailyConfirmed;
    }

    public Integer getDailyDeaths() {
        return dailyDeaths;
    }

    public void setDailyDeaths(Integer dailyDeaths) {
        this.dailyDeaths = dailyDeaths;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public Integer getTests() {
        return tests;
    }

    public void setTests(Integer tests) {
        this.tests = tests;
    }
}
