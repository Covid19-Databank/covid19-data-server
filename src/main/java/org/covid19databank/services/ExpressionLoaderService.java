package org.covid19databank.services;

import org.covid19databank.datamodel.Expression;
import org.covid19databank.datamodel.ExpressionType;
import org.covid19databank.payload.europepmc.Entry;
import org.covid19databank.payload.europepmc.ResearchData;
import org.covid19databank.repository.ExpressionRepository;
import org.covid19databank.repository.ExpressionTypeRepository;
import org.covid19databank.services.constant.ExpressionTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ExpressionLoaderService {
    private Logger log = LoggerFactory.getLogger(ExpressionLoaderService.class);
    private RestTemplate restTemplate;
    private ExpressionRepository expressionRepository;
    private ExpressionTypeRepository expressionTypeRepository;

    public ExpressionLoaderService(RestTemplate restTemplate, ExpressionRepository expressionRepository, ExpressionTypeRepository expressionTypeRepository) {
        this.restTemplate = restTemplate;
        this.expressionRepository = expressionRepository;
        this.expressionTypeRepository = expressionTypeRepository;
    }

    public void getExpressionData() {

        List<ExpressionTypeEnum> typeEnums = Arrays.asList(ExpressionTypeEnum.values());
        typeEnums.forEach(typeEnum -> {

            String url = typeEnum.getUrl();
            String expressionTypeName = typeEnum.getType();

            log.info(url);
            ResearchData data = restTemplate.getForObject(url, ResearchData.class);
            List<Entry> entries = data.getEntries();

            loadExpressionData(entries, expressionTypeName);

        });
    }

    public void loadExpressionData(List<Entry> entries, String expressionTypeName) {

        ExpressionType expressionType = expressionTypeRepository.findByName(expressionTypeName);

        for (Entry entry : entries) {


            String expressionId = entry.getId();
            String name = entry.getFields().getName().get(0);

            Optional<List<String>> taxonomies = Optional.ofNullable(entry.getFields().getTaxonomy());

            String taxonomy = join(taxonomies.orElse(new ArrayList<>()));


            Optional<List<String>> publicationDates = Optional.ofNullable(entry.getFields().getPublicationDate());

            String publicationDate = join(publicationDates.orElse(new ArrayList<>()));


            Optional<List<String>> descriptions = Optional.ofNullable(entry.getFields().getDescription());

            String description = join(descriptions.orElse(new ArrayList<>()));


            Optional<List<String>> species = Optional.ofNullable(entry.getFields().getSpecie());

            String specie = join(descriptions.orElse(new ArrayList<>()));


            log.info(name);


            Expression expression = new Expression(expressionId, name, taxonomy, publicationDate, description, specie, expressionType);
            expressionRepository.save(expression);

            log.info("Loaded Publication : {}", expressionId);


        }

    }

    public String join(List<String> list) {
        return String.join(",", list);
    }

}
