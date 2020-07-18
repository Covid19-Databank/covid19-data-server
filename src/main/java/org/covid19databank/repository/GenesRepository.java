package org.covid19databank.repository;

import org.covid19databank.datamodel.sequences.Genes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenesRepository extends JpaRepository<Genes, Integer> {
}
