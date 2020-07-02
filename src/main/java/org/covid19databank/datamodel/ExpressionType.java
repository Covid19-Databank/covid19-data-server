package org.covid19databank.datamodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ExpressionType {

    @Id
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "expressionType")
    private List<Expression> expressions;

    public ExpressionType() {
    }

    public ExpressionType(Integer id, String name, List<Expression> expressions) {
        this.id = id;
        this.name = name;
        this.expressions = expressions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }
}

