package org.covid19databank.repository;

import org.covid19databank.datamodel.Target;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TargetRepository extends JpaRepository<Target, Integer> {
}
