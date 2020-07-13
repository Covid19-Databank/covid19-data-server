package org.covid19databank.datamodel.sequences;

import javax.persistence.*;

@Entity
public class Sequence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sequenceId;
    private String collectionDate;
    private String country;
    private String host;
    private String strain;
    private String isolate;
    private String location;


    @ManyToOne
    @JoinColumn(name = "sequence_type_id")
    private SequenceType sequenceType;

    public Sequence() {
    }

    public Sequence(String sequenceId, String collectionDate, String country, String host, String strain, String isolate, String location, SequenceType sequenceType) {
        this.sequenceId = sequenceId;
        this.collectionDate = collectionDate;
        this.country = country;
        this.host = host;
        this.strain = strain;
        this.isolate = isolate;
        this.location = location;
        this.sequenceType = sequenceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public String getIsolate() {
        return isolate;
    }

    public void setIsolate(String isolate) {
        this.isolate = isolate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}