package org.covid19databank.services;

import org.covid19databank.datamodel.sequences.Sequence;
import org.covid19databank.datamodel.sequences.SequenceType;
import org.covid19databank.payload.europepmc.Entry;
import org.covid19databank.payload.europepmc.ResearchData;
import org.covid19databank.repository.SequenceRepository;
import org.covid19databank.repository.SequenceTypeRepository;
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
public class SequenceLoaderService {

    private Logger log = LoggerFactory.getLogger(SequenceLoaderService.class);
    private RestTemplate restTemplate;
    private SequenceRepository sequenceRepository;
    private SequenceTypeRepository sequenceTypeRepository;

    public SequenceLoaderService(RestTemplate restTemplate, SequenceRepository sequenceRepository, SequenceTypeRepository sequenceTypeRepository) {
        this.restTemplate = restTemplate;
        this.sequenceRepository = sequenceRepository;
        this.sequenceTypeRepository = sequenceTypeRepository;
    }

    public void getSequenceData() {

        String url = SequenceTypeEnum.BROWSER.getUrl();
        String sequenceTypeName = SequenceTypeEnum.BROWSER.getType();

            log.info(url);
            ResearchData data = restTemplate.getForObject(url, ResearchData.class);
            List<Entry> entries = data.getEntries();

            loadSequenceData(entries, sequenceTypeName);

    }

    public void loadSequenceData(List<Entry> entries, String sequenceTypeName) {

        SequenceType sequenceType = sequenceTypeRepository.findByName(sequenceTypeName);

        for (Entry entry : entries) {


            String sequenceId = entry.getId();

            Optional<List<String>> collectionDates = Optional.ofNullable(entry.getFields().getCollectionDate());
            String collectionDate = join(collectionDates.orElse(new ArrayList<>()));

            Optional<List<String>> countries = Optional.ofNullable(entry.getFields().getCountry());
            String country = join(countries.orElse(new ArrayList<>()));

            Optional<List<String>> hosts = Optional.ofNullable(entry.getFields().getHost());
            String host = join(hosts.orElse(new ArrayList<>()));

            Optional<List<String>> strains = Optional.ofNullable(entry.getFields().getStrain());
            String strain = join(strains.orElse(new ArrayList<>()));

            Optional<List<String>> isolates = Optional.ofNullable(entry.getFields().getIsolate());
            String isolate = join(isolates.orElse(new ArrayList<>()));

            Optional<List<String>> locations = Optional.ofNullable(entry.getFields().getLocation());
            String location = join(locations.orElse(new ArrayList<>()));


            log.info(location);


            Sequence sequence = new Sequence(sequenceId, collectionDate, country, host, strain, isolate, location, sequenceType);
            sequenceRepository.save(sequence);

            log.info("Loaded Publication : {}", sequenceId);


        }

    }

    public String join(List<String> list) {
        return String.join(",", list);
    }
}
