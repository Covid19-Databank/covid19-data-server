package org.covid19databank.repository;

import org.covid19databank.datamodel.sequences.SequencedSamples;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequencedSamplesRepository extends JpaRepository<SequencedSamples, Integer> {
}
