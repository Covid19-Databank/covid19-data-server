package org.covid19databank.services;

import org.covid19databank.datamodel.sequences.Sequence;
import org.covid19databank.datamodel.sequences.SequenceType;
import org.covid19databank.datamodel.sequences.Variant;
import org.covid19databank.payload.europepmc.Entry;
import org.covid19databank.payload.europepmc.ResearchData;
import org.covid19databank.repository.SequenceTypeRepository;
import org.covid19databank.repository.VariantRepository;
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
public class VariantLoaderService {
    private Logger log = LoggerFactory.getLogger(VariantLoaderService.class);
    private RestTemplate restTemplate;
    private VariantRepository variantRepository;
    private SequenceTypeRepository sequenceTypeRepository;

    public VariantLoaderService(RestTemplate restTemplate, VariantRepository variantRepository, SequenceTypeRepository sequenceTypeRepository) {
        this.restTemplate = restTemplate;
        this.variantRepository = variantRepository;
        this.sequenceTypeRepository = sequenceTypeRepository;
    }

    public void getVariantData() {


        String url = SequenceTypeEnum.BROWSER.getUrl();
        String sequenceTypeName = SequenceTypeEnum.BROWSER.getType();

            log.info(url);
            ResearchData data = restTemplate.getForObject(url, ResearchData.class);
            List<Entry> entries = data.getEntries();

            loadVariantData(entries, sequenceTypeName);
    }

    public void loadVariantData(List<Entry> entries, String sequenceTypeName) {

        SequenceType sequenceType = sequenceTypeRepository.findByName(sequenceTypeName);

        for (Entry entry : entries) {


            String sequenceId = entry.getId();

            Optional<List<String>> descriptions = Optional.ofNullable(entry.getFields().getDescription());
            String description = join(descriptions.orElse(new ArrayList<>()));

            Optional<List<String>> species = Optional.ofNullable(entry.getFields().getSpecie());
            String specie = join(species.orElse(new ArrayList<>()));


            Variant variant = new Variant(sequenceId, description, specie, sequenceType);
            variantRepository.save(variant);


        }

    }

    public String join(List<String> list) {
        return String.join(",", list);
    }
}
