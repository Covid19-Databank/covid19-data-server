package org.covid19databank.services;

import org.covid19databank.datamodel.sequences.RawReads;
import org.covid19databank.datamodel.sequences.SequenceType;
import org.covid19databank.payload.europepmc.Entry;
import org.covid19databank.payload.europepmc.ResearchData;
import org.covid19databank.repository.RawReadsRepository;
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
public class RawReadsLoaderService {

    private Logger log = LoggerFactory.getLogger(RawReadsLoaderService.class);
    private RestTemplate restTemplate;
    private RawReadsRepository rawReadsRepository;
    private SequenceTypeRepository sequenceTypeRepository;

    public RawReadsLoaderService(RestTemplate restTemplate, RawReadsRepository rawReadsRepository, SequenceTypeRepository sequenceTypeRepository) {
        this.restTemplate = restTemplate;
        this.rawReadsRepository = rawReadsRepository;
        this.sequenceTypeRepository = sequenceTypeRepository;
    }

    public void getRawReadsData() {

        List<SequenceTypeEnum> typeEnums = Arrays.asList(SequenceTypeEnum.values());
        typeEnums.forEach(typeEnum -> {

            String url = typeEnum.getUrl();
            String sequenceTypeName = typeEnum.getType();

            log.info(url);
            ResearchData data = restTemplate.getForObject(url, ResearchData.class);
            List<Entry> entries = data.getEntries();

            loadRawReadsData(entries, sequenceTypeName);

        });
    }

    public void loadRawReadsData(List<Entry> entries, String sequenceTypeName) {
        SequenceType sequenceType = sequenceTypeRepository.findByName(sequenceTypeName);

        for (Entry entry : entries) {


            String sequenceId = entry.getId();

            Optional<List<String>> descriptions = Optional.ofNullable(entry.getFields().getDescription());
            String description = join(descriptions.orElse(new ArrayList<>()));


            RawReads rawReads = new RawReads(sequenceId, description, sequenceType);
            rawReadsRepository.save(rawReads);


        }

    }

    public String join(List<String> list) {
        return String.join(",", list);
    }
}
