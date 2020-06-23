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
        "source"
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
    public List<String> getORCID() {
        return oRCID;
    }

    @JsonProperty("ORCID")
    public void setORCID(List<String> oRCID) {
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

}