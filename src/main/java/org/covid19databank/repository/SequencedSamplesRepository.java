package org.covid19databank.repository;

import org.covid19databank.datamodel.sequences.SequencedSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "sequenced-samples")
public interface SequencedSamplesRepository extends JpaRepository<SequencedSample, Integer> {
}
