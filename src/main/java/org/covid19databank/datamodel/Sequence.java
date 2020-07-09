package org.covid19databank.datamodel;

import javax.persistence.*;

@Entity
public class Sequence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String accession;
    private String collectionDate;
    private String country;
    private String host;
    private String strain;
    private String isolate;
    private String location;

    @Column(columnDefinition = "Text")
    private String description;
    private String name;
    private String centerName;

    @Column(columnDefinition = "Text")
    private String longDescription;
    private String scientificName;
    private String taxonomy;
    private String species;
    private String assembly;

    @ManyToOne
    @JoinColumn(name = "expression_type_id")
    private SequenceType sequenceType;

    public Sequence() {
    }

    public Sequence(String accession, String collectionDate, String country, String host, String strain, String isolate, String location, String description, String name, String centerName, String longDescription, String scientificName, String taxonomy, String species, String assembly) {
        this.accession = accession;
        this.collectionDate = collectionDate;
        this.country = country;
        this.host = host;
        this.strain = strain;
        this.isolate = isolate;
        this.location = location;
        this.description = description;
        this.name = name;
        this.centerName = centerName;
        this.longDescription = longDescription;
        this.scientificName = scientificName;
        this.taxonomy = taxonomy;
        this.species = species;
        this.assembly = assembly;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccession() {
        return accession;
    }

    public void setAccession(String accession) {
        this.accession = accession;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getAssembly() {
        return assembly;
    }

    public void setAssembly(String assembly) {
        this.assembly = assembly;
    }
}
