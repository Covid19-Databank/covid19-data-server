package org.covid19databank.repository;

import org.covid19databank.datamodel.expressions.ExpressionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpressionTypeRepository extends JpaRepository<ExpressionType, Integer> {

    ExpressionType findByName(String name);

}
