package org.covid19databank.repository;

import org.covid19databank.datamodel.ReportedCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportedCaseRepository extends JpaRepository<ReportedCase, Integer> {


}
