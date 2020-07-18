package org.covid19databank.repository;

import org.covid19databank.datamodel.sequences.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Integer> {
}
