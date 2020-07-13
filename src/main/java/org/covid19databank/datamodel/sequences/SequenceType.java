package org.covid19databank.datamodel.sequences;

import org.covid19databank.datamodel.sequences.Sequence;

import javax.persistence.*;
import java.util.List;

@Entity
public class SequenceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "SequenceType")
    private List<Sequence> sequences;

    @OneToMany(mappedBy = "SequenceType")
    private List<RawReads> rawReads;

    @OneToMany(mappedBy = "SequenceType")
    private List<SequencedSamples> sequencedSamples;

    @OneToMany(mappedBy = "SequenceType")
    private List<Studies> studies;

    @OneToMany(mappedBy = "SequenceType")
    private List<Genes> genes;

    @OneToMany(mappedBy = "SequenceType")
    private List<Browser> browsers;

    @OneToMany(mappedBy = "SequenceType")
    private List<Variant> variants;

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

