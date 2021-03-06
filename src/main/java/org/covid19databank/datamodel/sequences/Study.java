package org.covid19databank.datamodel.sequences;

import javax.persistence.*;

@Entity
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sequenceId;

    @Column(columnDefinition = "Text")
    private String longDescription;
    private String scientificName;
    private String taxonomy;

    @ManyToOne
    @JoinColumn(name = "sequence_type_id")
    private SequenceType sequenceType;

    public Study() {
    }

    public Study(String sequenceId, String longDescription, String scientificName, String taxonomy, SequenceType sequenceType) {
        this.sequenceId = sequenceId;
        this.longDescription = longDescription;
        this.scientificName = scientificName;
        this.taxonomy = taxonomy;
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
}
