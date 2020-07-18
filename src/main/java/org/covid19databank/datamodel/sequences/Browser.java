package org.covid19databank.datamodel.sequences;

import javax.persistence.*;

@Entity
public class Browser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sequenceId;
    private String scientificName;
    private String assemblyName;

    @ManyToOne
    @JoinColumn(name = "sequence_type_id")
    private SequenceType sequenceType;

    public Browser() {
    }

    public Browser(String sequenceId, String scientificName, String assemblyName, SequenceType sequenceType) {
        this.sequenceId = sequenceId;
        this.scientificName = scientificName;
        this.assemblyName = assemblyName;
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

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getAssemblyName() {
        return assemblyName;
    }

    public void setAssemblyName(String assemblyName) {
        this.assemblyName = assemblyName;
    }
}
