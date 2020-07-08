package org.covid19databank.datamodel;

import javax.persistence.*;
import java.util.List;

@Entity
public class ExpressionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "expressionType")
    private List<Expression> expressions;

    public ExpressionType() {
    }

    public ExpressionType(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

