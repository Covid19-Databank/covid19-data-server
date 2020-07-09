package org.covid19databank.datamodel;

import javax.persistence.*;
import java.lang.reflect.Type;
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

