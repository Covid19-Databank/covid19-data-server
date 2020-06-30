package org.covid19databank.payload.europepmc;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "author",
        "display_author",
        "publication_date",
        "journal",
        "volume",
        "issue",
        "pagination",
        "pmcid",
        "ORCID",
        "source",
        "description",
        "organism",
        "curated-complex",
        "species",
        "TAXONOMY"

})
public class Fields {

    private List<String> name;
    private List<String> author;
    private List<String> displayAuthor;
    private List<String> publicationDate;
    private List<String> journal;
    private List<String> volume;
    private List<String> issue;
    private List<String> pagination;
    private List<String> pmcid;
    private List<String> oRCID;
    private List<String> source;
    private List<String> description;
    private List<String> organism;
    private List<String> curatedComplex;
    private List<String> specie;
    private List<String> taxonomy;

    @JsonProperty("name")
    public List<String> getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(List<String> name) {
        this.name = name;
    }

    @JsonProperty("author")
    public List<String> getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(List<String> author) {
        this.author = author;
    }

    @JsonProperty("display_author")
    public List<String> getDisplayAuthor() {
        return displayAuthor;
    }

    @JsonProperty("display_author")
    public void setDisplayAuthor(List<String> displayAuthor) {
        this.displayAuthor = displayAuthor;
    }

    @JsonProperty("publication_date")
    public List<String> getPublicationDate() {
        return publicationDate;
    }

    @JsonProperty("publication_date")
    public void setPublicationDate(List<String> publicationDate) {
        this.publicationDate = publicationDate;
    }

    @JsonProperty("journal")
    public List<String> getJournal() {
        return journal;
    }

    @JsonProperty("journal")
    public void setJournal(List<String> journal) {
        this.journal = journal;
    }

    @JsonProperty("volume")
    public List<String> getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(List<String> volume) {
        this.volume = volume;
    }

    @JsonProperty("issue")
    public List<String> getIssue() {
        return issue;
    }

    @JsonProperty("issue")
    public void setIssue(List<String> issue) {
        this.issue = issue;
    }

    @JsonProperty("pagination")
    public List<String> getPagination() {
        return pagination;
    }

    @JsonProperty("pagination")
    public void setPagination(List<String> pagination) {
        this.pagination = pagination;
    }

    @JsonProperty("pmcid")
    public List<String> getPmcid() {
        return pmcid;
    }

    @JsonProperty("pmcid")
    public void setPmcid(List<String> pmcid) {
        this.pmcid = pmcid;
    }

    @JsonProperty("ORCID")
    public List<String> getoRCID() {
        return oRCID;
    }

    @JsonProperty("ORCID")
    public void setoRCID(List<String> oRCID) {
        this.oRCID = oRCID;
    }

    @JsonProperty("source")
    public List<String> getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(List<String> source) {
        this.source = source;
    }

    @JsonProperty("description")
    public List<String> getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(List<String> description) {
        this.description = description;
    }

    @JsonProperty("organism")
    public List<String> getOrganism() {
        return organism;
    }

    @JsonProperty("organism")
    public void setOrganism(List<String> organism) {
        this.organism = organism;
    }

    @JsonProperty("curated-complex")
    public List<String> getCuratedComplex() {
        return curatedComplex;
    }

    @JsonProperty("curated-complex")
    public void setCuratedComplex(List<String> curatedComplex) {
        this.curatedComplex = curatedComplex;
    }

    @JsonProperty("species")
    public List<String> getSpecie() {
        return specie;
    }

    @JsonProperty("species")
    public void setSpecie(List<String> specie) {
        this.specie = specie;
    }

    @JsonProperty("TAXONOMY")
    public List<String> getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(List<String> taxonomy) {
        this.taxonomy = taxonomy;
    }
}