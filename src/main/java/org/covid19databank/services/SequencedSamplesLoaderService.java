package org.covid19databank.services;

import org.covid19databank.datamodel.sequences.SequenceType;
import org.covid19databank.datamodel.sequences.SequencedSample;
import org.covid19databank.payload.europepmc.Entry;
import org.covid19databank.payload.europepmc.ResearchData;
import org.covid19databank.repository.SequenceTypeRepository;
import org.covid19databank.repository.SequencedSamplesRepository;
import org.covid19databank.services.constant.SequenceTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SequencedSamplesLoaderService {

    private Logger log = LoggerFactory.getLogger(SequencedSamplesLoaderService.class);
    private RestTemplate restTemplate;
    private SequencedSamplesRepository sequencedSamplesRepository;
    private SequenceTypeRepository sequenceTypeRepository;

    public SequencedSamplesLoaderService(RestTemplate restTemplate, SequencedSamplesRepository sequencedSamplesRepository, SequenceTypeRepository sequenceTypeRepository) {
        this.restTemplate = restTemplate;
        this.sequencedSamplesRepository = sequencedSamplesRepository;
        this.sequenceTypeRepository = sequenceTypeRepository;
    }

    public void getSequencedSampleData() {


        String url = SequenceTypeEnum.BROWSER.getUrl();
        String sequenceTypeName = SequenceTypeEnum.BROWSER.getType();

            log.info(url);
            ResearchData data = restTemplate.getForObject(url, ResearchData.class);
            List<Entry> entries = data.getEntries();

            loadSequencedSampleData(entries, sequenceTypeName);
    }

    public void loadSequencedSampleData(List<Entry> entries, String sequenceTypeName) {
        SequenceType sequenceType = sequenceTypeRepository.findByName(sequenceTypeName);

        for (Entry entry : entries) {

            String sequenceId = entry.getId();

            Optional<List<String>> names = Optional.ofNullable(entry.getFields().getName());
            String name = join(names.orElse(new ArrayList<>()));

            Optional<List<String>> centerNames = Optional.ofNullable(entry.getFields().getCenterName());
            String centerName = join(centerNames.orElse(new ArrayList<>()));

            Optional<List<String>> descriptions = Optional.ofNullable(entry.getFields().getDescription());
            String description = join(descriptions.orElse(new ArrayList<>()));

            SequencedSample sequencedSample = new SequencedSample(sequenceId, name, description, centerName, sequenceType);
            sequencedSamplesRepository.save(sequencedSample);

        }

    }

    public String join(List<String> list) {
        return String.join(",", list);
    }
}
