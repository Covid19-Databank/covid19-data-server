package org.covid19databank.datamodel;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ReportedCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private String state;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    private String lastUpdated;
    private Integer dailyConfirmed;
    private Integer dailyDeaths;
    private Integer critical;
    private Integer tests;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public Integer getDailyConfirmed() {
        return dailyConfirmed;
    }

    public Integer getDailyDeaths() {
        return dailyDeaths;
    }

    public Integer getCritical() {
        return critical;
    }

    public Integer getTests() {
        return tests;
    }


    public ReportedCase setCountry(Country country) {
        this.country = country;
        return this;
    }

    public ReportedCase setState(String state) {
        this.state = state;
        return this;
    }

    public ReportedCase setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
        return this;
    }

    public ReportedCase setDeaths(Integer deaths) {
        this.deaths = deaths;
        return this;
    }

    public ReportedCase setRecovered(Integer recovered) {
        this.recovered = recovered;
        return this;
    }

    public ReportedCase setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public ReportedCase setDailyConfirmed(Integer dailyConfirmed) {
        this.dailyConfirmed = dailyConfirmed;
        return this;
    }

    public ReportedCase setDailyDeaths(Integer dailyDeaths) {
        this.dailyDeaths = dailyDeaths;
        return this;
    }

    public ReportedCase setCritical(Integer critical) {
        this.critical = critical;
        return this;
    }

    public ReportedCase setTests(Integer tests) {
        this.tests = tests;
        return this;
    }

    public ReportedCase build() {
        return this;
    }

}
