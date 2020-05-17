package org.covid19databank.datamodel;

import javax.persistence.*;

@Entity
public class TotalCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Region region;

    private Integer confirmed;
    private Integer dailyConfirmed;
    private Integer recovered;
    private Integer deaths;
    private Integer dailyDeaths;
    private Integer critical;
    private Integer tests;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getDailyConfirmed() {
        return dailyConfirmed;
    }

    public void setDailyConfirmed(Integer dailyConfirmed) {
        this.dailyConfirmed = dailyConfirmed;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
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
