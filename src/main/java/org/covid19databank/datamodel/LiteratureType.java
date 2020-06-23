package org.covid19databank.datamodel;

import javax.persistence.*;
import java.util.List;

@Entity
public class LiteratureType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;


    @OneToMany(mappedBy = "literatureType")
    private List<Literature> literatures;


    public LiteratureType() {
    }

    public LiteratureType(String name) {
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
