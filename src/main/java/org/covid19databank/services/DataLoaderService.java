package org.covid19databank.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.covid19databank.datamodel.Region;
import org.covid19databank.datamodel.TotalCase;
import org.covid19databank.repository.RegionRepository;
import org.covid19databank.repository.TotalCaseRepository;
import org.covid19databank.services.constant.Location;
import org.covid19databank.services.constant.RegionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataLoaderService {

    private ObjectMapper mapper = new ObjectMapper();
    private Logger log = LoggerFactory.getLogger(DataLoaderService.class);
    private RestTemplate restTemplate;

    private RegionRepository regionRepository;
    private TotalCaseRepository totalCaseRepository;

    public DataLoaderService(RegionRepository regionRepository,
                             RestTemplate restTemplate,
                             TotalCaseRepository totalCaseRepository) {
        this.regionRepository = regionRepository;
        this.restTemplate = restTemplate;
        this.totalCaseRepository = totalCaseRepository;
    }

    public void getCasesData() {

        JsonNode data = restTemplate.getForObject(Location.CASES_URL.get(), JsonNode.class);
        assert data != null;
        JsonNode dData = data.get("regions");
        String time = data.get("last_updated").asText();

        JsonNode worldData = dData.get(RegionData.WORLD.get());
        TotalCase worldTotal = mapper.convertValue(worldData.get("totals"), TotalCase.class);
        Region region = regionRepository.findByName(RegionData.WORLD.get());
        worldTotal.setRegion(region);
        worldTotal.setLatestUpdate(time);
        totalCaseRepository.save(worldTotal);

    }

}
