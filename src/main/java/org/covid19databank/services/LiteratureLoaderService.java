package org.covid19databank.services;

import org.covid19databank.datamodel.Literature;
import org.covid19databank.datamodel.LiteratureType;
import org.covid19databank.payload.europepmc.Entry;
import org.covid19databank.payload.europepmc.ResearchData;
import org.covid19databank.repository.LiteratureRepository;
import org.covid19databank.repository.LiteratureTypeRepository;
import org.covid19databank.services.constant.LiteratureTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class LiteratureLoaderService {

    private Logger log = LoggerFactory.getLogger(LiteratureLoaderService.class);
    private RestTemplate restTemplate;
    private LiteratureRepository literatureRepository;
    private LiteratureTypeRepository literatureTypeRepository;

    public LiteratureLoaderService(LiteratureRepository literatureRepository, RestTemplate restTemplate, LiteratureTypeRepository literatureTypeRepository) {
        this.literatureRepository = literatureRepository;
        this.restTemplate = restTemplate;
        this.literatureTypeRepository = literatureTypeRepository;
    }

    public void getLiteratureData(){

        List<LiteratureTypeEnum> typeEnums = Arrays.asList(LiteratureTypeEnum.values());
        typeEnums.forEach(typeEnum -> {

            String url = typeEnum.getUrl();
            String literatureTypeName = typeEnum.getType();

            ResearchData data =  restTemplate.getForObject(url, ResearchData.class);
            List<Entry> entries = data.getEntries();

            loadLiteratureData(entries, literatureTypeName);

        });
    }


    public void loadLiteratureData(List<Entry> entries, String literatureTypeName) {

        LiteratureType literatureType = literatureTypeRepository.findByName(literatureTypeName);

        for(Entry entry : entries) {


            String europePmcId = entry.getId();
            String name = entry.getFields().getName().get(0);
            String author = join(entry.getFields().getAuthor());
            String displayAuthor = join(entry.getFields().getDisplayAuthor());
            String publication = entry.getFields().getPublicationDate().get(0);
            String journal = join( entry.getFields().getJournal());
            String volume = join(entry.getFields().getVolume());
            String issue = join(entry.getFields().getIssue());
            String pagination =  join(entry.getFields().getPagination());
            String pmcid = join(entry.getFields().getPmcid());
            String orcid = join(entry.getFields().getORCID());
            String source = join(entry.getFields().getSource());
            log.info(name);

            Literature literature = new Literature(europePmcId, name, author, displayAuthor, publication, journal, volume, issue, pagination, pmcid, orcid, source, literatureType);
            literatureRepository.save(literature);

            log.info("Loaded Publication : {}", europePmcId);

        }

    }


    public String join(List<String> list){
        return String.join(",", list);
    }

}
