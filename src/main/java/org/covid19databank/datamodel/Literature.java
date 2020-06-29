package org.covid19databank.datamodel;

import org.covid19databank.payload.europepmc.Fields;

import javax.persistence.*;

@Entity
@Table(name = "literature", uniqueConstraints = {@UniqueConstraint(columnNames = {"europePmcId", "literature_type_id"})})
public class Literature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String europePmcId;

    @Column(columnDefinition = "Text")
    private String name;

    @Column(columnDefinition="Text")
    private String author;

    @Column(columnDefinition="Text")
    private String displayAuthor;

    private String pmcid;
    private String publicationDate;
    private String journal;
    private String volume;
    private String issue;
    private String pagination;

    @Column(columnDefinition = "Text")
    private String oRCID;
    private String source;



    @ManyToOne
    @JoinColumn(name = "literature_type_id")
    private LiteratureType literatureType;

    public Literature() {
    }

    public Literature(String europePmcId,
                      String name,
                      String author,
                      String displayAuthor,
                      String publicationDate,
                      String journal,
                      String volume,
                      String issue,
                      String pagination,
                      String pmcid,
                      String oRCID,
                      String source,
                      LiteratureType literatureType) {
        this.europePmcId = europePmcId;
        this.name = name;
        this.author = author;
        this.displayAuthor = displayAuthor;
        this.publicationDate = publicationDate;
        this.journal = journal;
        this.volume = volume;
        this.issue = issue;
        this.pagination = pagination;
        this.pmcid = pmcid;
        this.oRCID = oRCID;
        this.source = source;
        this.literatureType = literatureType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEuropePmcId() {
        return europePmcId;
    }

    public void setEuropePmcId(String europePmcId) {
        this.europePmcId = europePmcId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDisplayAuthor() {
        return displayAuthor;
    }

    public void setDisplayAuthor(String displayAuthor) {
        this.displayAuthor = displayAuthor;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getPagination() {
        return pagination;
    }

    public void setPagination(String pagination) {
        this.pagination = pagination;
    }

    public String getPmcid() {
        return pmcid;
    }

    public void setPmcid(String pmcid) {
        this.pmcid = pmcid;
    }

    public String getoRCID() {
        return oRCID;
    }

    public void setoRCID(String oRCID) {
        this.oRCID = oRCID;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LiteratureType getLiteratureType() {
        return literatureType;
    }

    public void setLiteratureType(LiteratureType literatureType) {
        this.literatureType = literatureType;
    }
}