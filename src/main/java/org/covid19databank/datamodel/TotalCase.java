package org.covid19databank.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class TotalCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;


    private Integer confirmed;
    private Integer dailyConfirmed;
    private Integer recovered;
    private Integer deaths;
    private Integer dailyDeaths;
    private Integer critical;
    private Integer tests;

    @Column(unique = true)
    private String latestUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("confirmed")
    public Integer getConfirmed() {
        return confirmed;
    }

    @JsonProperty("daily_confirmed")
    public Integer getDailyConfirmed() {
        return dailyConfirmed;
    }

    @JsonProperty("recovered")
    public Integer getRecovered() {
        return recovered;
    }

    @JsonProperty("deaths")
    public Integer getDeaths() {
        return deaths;
    }

    @JsonProperty("daily_deaths")
    public Integer getDailyDeaths() {
        return dailyDeaths;
    }

    @JsonProperty("critical")
    public Integer getCritical() {
        return critical;
    }

    @JsonProperty("tests")
    public Integer getTests() {
        return tests;
    }

    public Region getRegion() {
        return region;
    }



    public void setLatestUpdate(String latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public void setDailyConfirmed(Integer dailyConfirmed) {
        this.dailyConfirmed = dailyConfirmed;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public void setDailyDeaths(Integer dailyDeaths) {
        this.dailyDeaths = dailyDeaths;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public void setTests(Integer tests) {
        this.tests = tests;
    }

    public String getLatestUpdate() {
        return latestUpdate;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
