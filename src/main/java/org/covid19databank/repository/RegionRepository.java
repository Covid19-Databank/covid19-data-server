package org.covid19databank.repository;

import org.covid19databank.datamodel.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    Region findByName(String name);

}
