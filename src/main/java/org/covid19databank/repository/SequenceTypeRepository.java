package org.covid19databank.repository;

import org.covid19databank.datamodel.sequences.SequenceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceTypeRepository extends JpaRepository<SequenceType, Integer> {

    SequenceType findByName(String name);
}
