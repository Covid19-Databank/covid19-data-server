package org.covid19databank.datamodel;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String iso;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String niceName;

    private String iso3;
    private String numCode;
    private String phoneCode;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "country_region",
            joinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "region_id", referencedColumnName = "id")
    )
    private Set<Region> regions;

    @OneToMany(mappedBy = "country")
    private List<ReportedCase> reportedCases;

    @OneToMany(mappedBy = "country")
    private List<HeadLine> headLines;

    @OneToMany(mappedBy = "country")
    private List<Trend> trends;

    public Country() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIso() {
        return iso;
    }

    public String getName() {
        return name;
    }

    public String getNiceName() {
        return niceName;
    }

    public String getIso3() {
        return iso3;
    }

    public String getNumCode() {
        return numCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public Country setIso(String iso) {
        this.iso = iso;
        return this;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public Country setNiceName(String niceName) {
        this.niceName = niceName;
        return this;
    }

    public Country setIso3(String iso3) {
        this.iso3 = iso3;
        return this;
    }

    public Country setNumCode(String numCode) {
        this.numCode = numCode;
        return this;
    }

    public Country setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
        return this;
    }

    public Country setRegions(Set<Region> regions) {
        this.regions = regions;
        return this;
    }

    public Country build() {
        return this;
    }


}
