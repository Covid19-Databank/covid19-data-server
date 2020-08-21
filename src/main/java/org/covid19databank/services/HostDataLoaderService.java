package org.covid19databank.services;

import org.covid19databank.datamodel.sequences.HostData;
import org.covid19databank.datamodel.sequences.SequenceType;
import org.covid19databank.payload.europepmc.Entry;
import org.covid19databank.payload.europepmc.ResearchData;
import org.covid19databank.repository.HostDataRepository;
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
public class HostDataLoaderService {

    private Logger log = LoggerFactory.getLogger(HostDataLoaderService.class);
    private RestTemplate restTemplate;
    private HostDataRepository hostDataRepository;
    private SequenceTypeRepository sequenceTypeRepository;

    public HostDataLoaderService(RestTemplate restTemplate, HostDataRepository hostDataRepository, SequenceTypeRepository sequenceTypeRepository) {
        this.restTemplate = restTemplate;
        this.hostDataRepository = hostDataRepository;
        this.sequenceTypeRepository = sequenceTypeRepository;
    }

    public void getHostData() {

        String url = SequenceTypeEnum.BROWSER.getUrl();
        String sequenceTypeName = SequenceTypeEnum.BROWSER.getType();

            log.info(url);
            ResearchData data = restTemplate.getForObject(url, ResearchData.class);
            List<Entry> entries = data.getEntries();

            loadHostData(entries, sequenceTypeName);

    }

    public void loadHostData(List<Entry> entries, String sequenceTypeName) {
        SequenceType sequenceType = sequenceTypeRepository.findByName(sequenceTypeName);

        for (Entry entry : entries) {

            String sequenceId = entry.getId();

            Optional<List<String>> names = Optional.ofNullable(entry.getFields().getName());
            String name = join(names.orElse(new ArrayList<>()));

            Optional<List<String>> descriptions = Optional.ofNullable(entry.getFields().getDescription());
            String description = join(descriptions.orElse(new ArrayList<>()));

            HostData hostData = new HostData(sequenceId, name, description, sequenceType);
            hostDataRepository.save(hostData);

        }

    }

    public String join(List<String> list) {
        return String.join(",", list);
    }
}
