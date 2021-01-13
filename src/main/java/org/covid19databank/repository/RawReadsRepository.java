package org.covid19databank.repository;

import org.covid19databank.datamodel.sequences.RawRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "raw-reads")
public interface RawReadsRepository extends JpaRepository<RawRead, Integer> {
}
