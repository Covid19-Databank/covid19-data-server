package org.covid19databank.datamodel.sequences;

import javax.persistence.*;

@Entity
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sequenceId;

    @Column(columnDefinition = "Text")
    private String description;
    private String species;

    @ManyToOne
    @JoinColumn(name = "sequence_type_id")
    private SequenceType sequenceType;

    public Variant() {
    }

    public Variant(String sequenceId, String description, String species) {
        this.sequenceId = sequenceId;
        this.description = description;
        this.species = species;
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
}
