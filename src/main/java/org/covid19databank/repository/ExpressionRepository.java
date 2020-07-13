package org.covid19databank.repository;

import org.covid19databank.datamodel.expressions.Expression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpressionRepository extends JpaRepository<Expression, Integer> {
}
