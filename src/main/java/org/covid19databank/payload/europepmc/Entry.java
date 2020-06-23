package org.covid19databank.payload.europepmc;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "source",
        "score",
        "fields",
        "fieldURLs"
})
public class Entry {

    private String id;
    private String source;
    private String score;
    private Fields fields;
    private List<FieldURL> fieldURLs;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("score")
    public String getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(String score) {
        this.score = score;
    }

    @JsonProperty("fields")
    public Fields getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(Fields fields) {
        this.fields = fields;
    }

    @JsonProperty("fieldURLs")
    public List<FieldURL> getFieldURLs() {
        return fieldURLs;
    }

    @JsonProperty("fieldURLs")
    public void setFieldURLs(List<FieldURL> fieldURLs) {
        this.fieldURLs = fieldURLs;
    }

}