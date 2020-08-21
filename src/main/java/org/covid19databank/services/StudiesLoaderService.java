package org.covid19databank.services;

import org.covid19databank.datamodel.sequences.SequenceType;
import org.covid19databank.datamodel.sequences.Studies;
import org.covid19databank.payload.europepmc.Entry;
import org.covid19databank.payload.europepmc.ResearchData;
import org.covid19databank.repository.SequenceTypeRepository;
import org.covid19databank.repository.StudiesRepository;
import org.covid19databank.services.constant.SequenceTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudiesLoaderService {

    private Logger log = LoggerFactory.getLogger(StudiesLoaderService.class);
    private RestTemplate restTemplate;
    private StudiesRepository studiesRepository;
    private SequenceTypeRepository sequenceTypeRepository;

    public StudiesLoaderService(RestTemplate restTemplate, StudiesRepository studiesRepository, SequenceTypeRepository sequenceTypeRepository) {
        this.restTemplate = restTemplate;
        this.studiesRepository = studiesRepository;
        this.sequenceTypeRepository = sequenceTypeRepository;
    }

    public void getStudies() {


        String url = SequenceTypeEnum.BROWSER.getUrl();
        String sequenceTypeName = SequenceTypeEnum.BROWSER.getType();

            log.info(url);
            ResearchData data = restTemplate.getForObject(url, ResearchData.class);
            List<Entry> entries = data.getEntries();

            loadStudies(entries, sequenceTypeName);

    }

    public void loadStudies(List<Entry> entries, String sequenceTypeName) {
        SequenceType sequenceType = sequenceTypeRepository.findByName(sequenceTypeName);

        for (Entry entry : entries) {


            String sequenceId = entry.getId();

            Optional<List<String>> longDescriptions = Optional.ofNullable(entry.getFields().getLongDescription());
            String longDescription = join(longDescriptions.orElse(new ArrayList<>()));

            Optional<List<String>> scientificNames = Optional.ofNullable(entry.getFields().getScientificName());
            String scientificName = join(scientificNames.orElse(new ArrayList<>()));

            Optional<List<String>> taxonomies = Optional.ofNullable(entry.getFields().getTaxon());
            String taxonomy = join(taxonomies.orElse(new ArrayList<>()));


            Studies studies = new Studies(sequenceId, longDescription, scientificName, taxonomy, sequenceType);
            studiesRepository.save(studies);


        }

    }

    public String join(List<String> list) {
        return String.join(",", list);
    }
}
