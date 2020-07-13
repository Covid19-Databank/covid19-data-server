package org.covid19databank.datamodel.sequences;

import javax.persistence.*;

@Entity
public class RawReads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sequenceId;

    @Column(columnDefinition = "Text")
    private String description;

    @ManyToOne
    @JoinColumn(name = "sequence_type_id")
    private SequenceType sequenceType;

    public RawReads() {
    }

    public RawReads(String sequenceId, String description, SequenceType sequenceType) {
        this.sequenceId = sequenceId;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
