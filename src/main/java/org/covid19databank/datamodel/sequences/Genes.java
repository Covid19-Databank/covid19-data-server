package org.covid19databank.datamodel.sequences;

import javax.persistence.*;

@Entity
public class Genes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sequenceId;
    private String name;

    @Column(columnDefinition = "Text")
    private String description;
    private String species;
    private String location;

    @ManyToOne
    @JoinColumn(name = "sequence_type_id")
    private SequenceType sequenceType;

    public Genes() {
    }

    public Genes(String sequenceId, String name, String description, String species, String location, SequenceType sequenceType) {
        this.sequenceId = sequenceId;
        this.name = name;
        this.description = description;
        this.species = species;
        this.location = location;
        this.sequenceType = sequenceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
