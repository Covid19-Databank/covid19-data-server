package org.covid19databank.datamodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ISO",
        "Name",
        "Nice Name",
        "ISO3",
        "Num Code",
        "Phone Code"
})
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String iso;
    private String name;
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

    @JsonProperty("ISO")
    public String getIso() {
        return iso;
    }

    @JsonProperty("ISO")
    public void setIso(String iso) {
        this.iso = iso;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Nice Name")
    public String getNiceName() {
        return niceName;
    }

    @JsonProperty("Nice Name")
    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    @JsonProperty("ISO3")
    public String getIso3() {
        return iso3;
    }

    @JsonProperty("ISO3")
    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    @JsonProperty("numCode")
    public String getNumCode() {
        return numCode;
    }

    @JsonProperty("Num Code")
    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    @JsonProperty("Phone Code")
    public String getPhoneCode() {
        return phoneCode;
    }

    @JsonProperty("Phone Code")
    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }


}
