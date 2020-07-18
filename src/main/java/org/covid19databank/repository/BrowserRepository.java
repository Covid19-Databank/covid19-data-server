package org.covid19databank.repository;

import org.covid19databank.datamodel.sequences.Browser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrowserRepository extends JpaRepository<Browser, Integer> {
}
