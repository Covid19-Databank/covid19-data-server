package org.covid19databank.repository;

import org.covid19databank.datamodel.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteratureRepository extends JpaRepository<Literature, Integer> {


}
