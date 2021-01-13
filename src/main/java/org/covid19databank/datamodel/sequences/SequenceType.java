package org.covid19databank.datamodel.sequences;

import javax.persistence.*;
import java.util.List;

@Entity
public class SequenceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "sequenceType")
    private List<Sequence> sequences;

    @OneToMany(mappedBy = "sequenceType")
    private List<RawRead> rawReads;

    @OneToMany(mappedBy = "sequenceType")
    private List<SequencedSample> sequencedSamples;

    @OneToMany(mappedBy = "sequenceType")
    private List<Study> studies;

    @OneToMany(mappedBy = "sequenceType")
    private List<Gene> genes;

    @OneToMany(mappedBy = "sequenceType")
    private List<Browser> browsers;

    @OneToMany(mappedBy = "sequenceType")
    private List<Variant> variants;

    @OneToMany(mappedBy = "sequenceType" + "")
    private List<HostData> hostData;

    public SequenceType() {
    }

    public SequenceType(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

