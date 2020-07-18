package org.covid19databank.repository;

import org.covid19databank.datamodel.sequences.Studies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudiesRepository extends JpaRepository<Studies, Integer> {

}

