package org.covid19databank.datamodel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String europePmcId;
    private String name;
    private String organism;
    private String description;

    public Target() {
    }

    public Target(String europePmcId, String name, String organism, String description) {
        this.europePmcId = europePmcId;
        this.name = name;
        this.organism = organism;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEuropePmcId() {
        return europePmcId;
    }

    public void setEuropePmcId(String europePmcId) {
        this.europePmcId = europePmcId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganism() {
        return organism;
    }

    public void setOrganism(String organism) {
        this.organism = organism;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
