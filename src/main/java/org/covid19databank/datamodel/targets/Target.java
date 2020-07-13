package org.covid19databank.datamodel.targets;

import javax.persistence.*;

@Entity
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String targetId;

    @Column(columnDefinition = "Text")
    private String curatedComplex;
    private String organism;

    @Column(columnDefinition = "Text")
    private String description;

    public Target() {
    }

    public Target(String targetId, String curatedComplex, String organism, String description) {
        this.targetId = targetId;
        this.curatedComplex = curatedComplex;
        this.organism = organism;
        this.description = description;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getCuratedComplex() {
        return curatedComplex;
    }

    public void setCuratedComplex(String curatedComplex) {
        this.curatedComplex = curatedComplex;
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
