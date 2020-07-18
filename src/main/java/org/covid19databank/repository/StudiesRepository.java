package org.covid19databank.repository;

import org.covid19databank.datamodel.sequences.Studies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudiesRepository extends JpaRepository<Studies, Integer> {

}

