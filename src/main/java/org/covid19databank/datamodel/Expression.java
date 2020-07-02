package org.covid19databank.datamodel;

import javax.persistence.*;

@Entity
public class Expression {
    @Id
    private Integer id;
    private String expressionId;

    @Column(columnDefinition = "Text")
    private String name;
    private String taxonomy;
    private String publicationDate;

    @ManyToOne
    @JoinColumn(name = "expression_type_id")
    private ExpressionType expressionType;

    public Expression() {
    }

    public Expression(Integer id, String expressionId, String name, String taxonomy, String publicationDate, ExpressionType expressionType) {
        this.id = id;
        this.expressionId = expressionId;
        this.name = name;
        this.taxonomy = taxonomy;
        this.publicationDate = publicationDate;
        this.expressionType = expressionType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpressionId() {
        return expressionId;
    }

    public void setExpressionId(String expressionId) {
        this.expressionId = expressionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public ExpressionType getExpressionType() {
        return expressionType;
    }

    public void setExpressionType(ExpressionType expressionType) {
        this.expressionType = expressionType;
    }
}
