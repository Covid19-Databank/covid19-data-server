package org.covid19databank.repository;

import org.covid19databank.datamodel.Region;
import org.covid19databank.datamodel.TotalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalCaseRepository extends JpaRepository<TotalCase, Integer> {

    boolean existsByLatestUpdateAndRegion(String latestUpdateTime, Region region);
}
