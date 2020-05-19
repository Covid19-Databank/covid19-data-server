package org.covid19databank.datamodel;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "region")
    private List<TotalCase> totalCases;

    @ManyToMany(mappedBy = "regions")
    private Set<Country> countries;


    public Region() {
        // Default Constructor
    }

    public Region(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
