package org.covid19databank.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.covid19databank.datamodel.Country;
import org.covid19databank.datamodel.Region;
import org.covid19databank.repository.CountryRepository;
import org.covid19databank.repository.RegionRepository;
import org.covid19databank.services.constant.Location;
import org.covid19databank.services.constant.RegionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

@Service
public class InitDataBaseService {

    private ObjectMapper mapper = new ObjectMapper();
    private Logger log = LoggerFactory.getLogger(InitDataBaseService.class);

    private RegionRepository regionRepository;
    private CountryRepository countryRepository;

    public InitDataBaseService(RegionRepository regionRepository, CountryRepository countryRepository) {
        this.regionRepository = regionRepository;
        this.countryRepository = countryRepository;
    }

    public void loadRegions(){
        Arrays.asList(RegionData.values()).forEach(regionData -> {
            try {
                regionRepository.save(new Region(regionData.get()));
            }catch (Exception e){
                log.warn("Region Data {} is existing already", regionData);
            }
        });
    }

    public void loadCountries() {
        JsonNode jsonNode = readJsonLocal(Location.COUNTRIES_URL.get());
        List<Country> countries = mapper.convertValue(jsonNode.get("data"), new TypeReference<List<Country>>(){});
        countryRepository.saveAll(countries);
    }

    private JsonNode readJsonLocal(String jsonFileLink) {

        JsonNode jsonNode = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(jsonFileLink));
            jsonNode = mapper.readTree(br);
        }catch (Exception e) {
            log.warn(e.getMessage());
        }
        return jsonNode;
    }
}
