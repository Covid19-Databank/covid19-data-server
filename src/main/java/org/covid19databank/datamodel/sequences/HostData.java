package org.covid19databank.datamodel.sequences;

import javax.persistence.*;

@Entity
public class HostData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sequenceId;
    private String name;

    @Column(columnDefinition = "Text")
    private String description;

    @ManyToOne
    @JoinColumn(name = "sequence_type_id")
    private SequenceType sequenceType;

    public HostData() {
    }

    public HostData(String sequenceId, String name, String description, SequenceType sequenceType) {
        this.sequenceId = sequenceId;
        this.name = name;
        this.description = description;
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
}

