package org.covid19databank.datamodel.sequences;

import javax.persistence.*;

@Entity
public class SequencedSample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sequenceId;
    private String name;

    @Column(columnDefinition = "Text")
    private String description;
    private String centerName;

    @ManyToOne
    @JoinColumn(name = "sequence_type_id")
    private SequenceType sequenceType;

    public SequencedSample() {
    }

    public SequencedSample(String sequenceId, String name, String description, String centerName, SequenceType sequenceType) {
        this.sequenceId = sequenceId;
        this.name = name;
        this.description = description;
        this.centerName = centerName;
        this.sequenceType = sequenceType;
    }

    public Integer getId() {
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

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }
}

