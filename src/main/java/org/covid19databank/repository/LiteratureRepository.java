package org.covid19databank.repository;

import org.covid19databank.datamodel.literatures.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestController
public interface LiteratureRepository extends JpaRepository<Literature, Integer> {


}
