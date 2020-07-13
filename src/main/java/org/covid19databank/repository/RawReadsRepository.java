package org.covid19databank.repository;

import org.covid19databank.datamodel.sequences.RawReads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawReadsRepository extends JpaRepository<RawReads, Integer> {
}
