package org.covid19databank.repository;

import org.covid19databank.datamodel.sequences.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestController
public interface SequenceRepository extends JpaRepository<Sequence, Integer> {
}
