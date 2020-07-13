package org.covid19databank.repository;

import org.covid19databank.datamodel.literatures.LiteratureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteratureTypeRepository extends JpaRepository<LiteratureType, Integer> {

    LiteratureType findByName(String name);

}
