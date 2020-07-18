package org.covid19databank.services;


import org.covid19databank.datamodel.sequences.Genes;
import org.covid19databank.datamodel.sequences.RawReads;
import org.covid19databank.datamodel.sequences.SequenceType;
import org.covid19databank.payload.europepmc.Entry;
import org.covid19databank.payload.europepmc.ResearchData;
import org.covid19databank.repository.GenesRepository;
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
public class GeneLoaderService {


    private Logger log = LoggerFactory.getLogger(GeneLoaderService.class);
    private RestTemplate restTemplate;
    private GenesRepository genesRepository;
    private SequenceTypeRepository sequenceTypeRepository;

    public GeneLoaderService(RestTemplate restTemplate, GenesRepository genesRepository, SequenceTypeRepository sequenceTypeRepository) {
        this.restTemplate = restTemplate;
        this.genesRepository = genesRepository;
        this.sequenceTypeRepository = sequenceTypeRepository;
    }

    public void getGenes() {

        List<SequenceTypeEnum> typeEnums = Arrays.asList(SequenceTypeEnum.values());
        typeEnums.forEach(typeEnum -> {

            String url = typeEnum.getUrl();
            String sequenceTypeName = typeEnum.getType();

            log.info(url);
            ResearchData data = restTemplate.getForObject(url, ResearchData.class);
            List<Entry> entries = data.getEntries();

            loadGenes(entries, sequenceTypeName);

        });
    }

    public void loadGenes(List<Entry> entries, String sequenceTypeName) {
        SequenceType sequenceType = sequenceTypeRepository.findByName(sequenceTypeName);

        for (Entry entry : entries) {


            String sequenceId = entry.getId();

            Optional<List<String>> names = Optional.ofNullable(entry.getFields().getName());
            String name = join(names.orElse(new ArrayList<>()));

            Optional<List<String>> descriptions = Optional.ofNullable(entry.getFields().getDescription());
            String description = join(descriptions.orElse(new ArrayList<>()));

            Optional<List<String>> species = Optional.ofNullable(entry.getFields().getSpecie());
            String specie = join(species.orElse(new ArrayList<>()));

            Optional<List<String>> locations = Optional.ofNullable(entry.getFields().getLocation());
            String location = join(locations.orElse(new ArrayList<>()));

            Genes genes = new Genes(sequenceId, name, description, specie, location, sequenceType);
            genesRepository.save(genes);


        }

    }

    public String join(List<String> list) {
        return String.join(",", list);
    }
}
