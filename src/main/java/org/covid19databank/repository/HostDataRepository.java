package org.covid19databank.repository;

import org.covid19databank.datamodel.sequences.HostData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostDataRepository extends JpaRepository<HostData, Integer> {
}
