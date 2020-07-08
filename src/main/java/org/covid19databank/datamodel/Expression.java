package org.covid19databank.datamodel;

import javax.persistence.*;

@Entity
public class Expression {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String expressionId;

    @Column(columnDefinition = "Text")
    private String name;
    private String taxonomy;
    private String publicationDate;

    @Column(columnDefinition = "Text")
    private String description;

    @Column(columnDefinition = "Text")
    private String specie;
    @ManyToOne
    @JoinColumn(name = "expression_type_id")
    private ExpressionType expressionType;

    public Expression() {
    }

    public Expression(String expressionId, String name, String taxonomy, String publicationDate, String description, String specie, ExpressionType expressionType) {
        this.expressionId = expressionId;
        this.name = name;
        this.taxonomy = taxonomy;
        this.publicationDate = publicationDate;
        this.expressionType = expressionType;
        this.description = description;
        this.specie = specie;

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public ExpressionType getExpressionType() {
        return expressionType;
    }

    public void setExpressionType(ExpressionType expressionType) {
        this.expressionType = expressionType;
    }
}
