package org.covid19databank.repository;

import org.covid19databank.datamodel.sequences.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceRepository extends JpaRepository<Sequence, Integer> {
}
