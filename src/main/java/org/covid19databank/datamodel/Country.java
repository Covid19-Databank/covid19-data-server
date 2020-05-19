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


    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToMany(cascade = CascadeType.ALL)
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

    public Country(String iso, String name, String niceName, String iso3, String numCode, String phoneCode) {
        this.iso = iso;
        this.name = name;
        this.niceName = niceName;
        this.iso3 = iso3;
        this.numCode = numCode;
        this.phoneCode = phoneCode;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }


}
