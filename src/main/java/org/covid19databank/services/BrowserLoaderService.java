package org.covid19databank.services;

import org.covid19databank.datamodel.sequences.Browser;
import org.covid19databank.datamodel.sequences.SequenceType;
import org.covid19databank.payload.europepmc.Entry;
import org.covid19databank.payload.europepmc.ResearchData;
import org.covid19databank.repository.BrowserRepository;
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
public class BrowserLoaderService {

    private Logger log = LoggerFactory.getLogger(BrowserLoaderService.class);
    private RestTemplate restTemplate;
    private BrowserRepository browserRepository;
    private SequenceTypeRepository sequenceTypeRepository;

    public BrowserLoaderService(RestTemplate restTemplate, BrowserRepository browserRepository, SequenceTypeRepository sequenceTypeRepository) {
        this.restTemplate = restTemplate;
        this.browserRepository = browserRepository;
        this.sequenceTypeRepository = sequenceTypeRepository;
    }

    public void getBrowserData() {


        ResearchData data = restTemplate.getForObject(SequenceTypeEnum.BROWSER.getUrl(), ResearchData.class);
        List<Entry> entries = data.getEntries();

        loadBrowserData(entries, SequenceTypeEnum.BROWSER.getType());

    }

    public void loadBrowserData(List<Entry> entries, String sequenceTypeName) {

        SequenceType sequenceType = sequenceTypeRepository.findByName(sequenceTypeName);

        for (Entry entry : entries) {

            String sequenceId = entry.getId();

            Optional<List<String>> names = Optional.ofNullable(entry.getFields().getScientificName());
            String name = join(names.orElse(new ArrayList<>()));

            Optional<List<String>> assemblies = Optional.ofNullable(entry.getFields().getAssemblyName());
            String assembly = join(assemblies.orElse(new ArrayList<>()));

            Browser browser = new Browser(sequenceId, name, assembly, sequenceType);
            browserRepository.save(browser);

            log.info("Loaded Publication : {}", sequenceId);


        }

    }

    public String join(List<String> list) {
        return String.join(",", list);
    }
}
