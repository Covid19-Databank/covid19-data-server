package org.covid19databank.repository;

import org.covid19databank.datamodel.sequences.Genes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenesRepository extends JpaRepository<Genes, Integer> {
}
