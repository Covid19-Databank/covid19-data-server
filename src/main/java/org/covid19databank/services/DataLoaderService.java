package org.covid19databank.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.covid19databank.datamodel.Country;
import org.covid19databank.datamodel.Region;
import org.covid19databank.datamodel.ReportedCase;
import org.covid19databank.datamodel.TotalCase;
import org.covid19databank.payload.Report;
import org.covid19databank.payload.cov19cc.RegionData;
import org.covid19databank.repository.CountryRepository;
import org.covid19databank.repository.RegionRepository;
import org.covid19databank.repository.ReportedCaseRepository;
import org.covid19databank.repository.TotalCaseRepository;
import org.covid19databank.services.constant.Location;
import org.covid19databank.services.constant.Regions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class DataLoaderService {

    private ObjectMapper mapper = new ObjectMapper();
    private Logger log = LoggerFactory.getLogger(DataLoaderService.class);
    private RestTemplate restTemplate;

    private RegionRepository regionRepository;
    private TotalCaseRepository totalCaseRepository;
    private CountryRepository countryRepository;
    private ReportedCaseRepository reportedCaseRepository;

    public DataLoaderService(RegionRepository regionRepository,
                             RestTemplate restTemplate,
                             TotalCaseRepository totalCaseRepository,
                             CountryRepository countryRepository,
                             ReportedCaseRepository reportedCaseRepository) {
        this.regionRepository = regionRepository;
        this.restTemplate = restTemplate;
        this.totalCaseRepository = totalCaseRepository;
        this.countryRepository = countryRepository;
        this.reportedCaseRepository = reportedCaseRepository;
    }

    public void getCasesData() {

        JsonNode data = restTemplate.getForObject(Location.CASES_URL.get(), JsonNode.class);
        assert data != null;
        JsonNode dData = data.get("regions");
        String time = data.get("last_updated").asText();

        Arrays.asList(Regions.values()).forEach(regionData -> {
            String regionString = regionData.get();

            try {
                RegionData worldData = mapper.convertValue(dData.get(regionString), new TypeReference<RegionData>(){});
                List<Report> reports = worldData.getList();
                TotalCase worldTotal = worldData.getTotals();
                Region region = regionRepository.findByName(regionString);

                log.info("*** Region {} data loading commenced ***", regionString);
                boolean isLoaded = this.loadTotalCases(worldTotal, region, time);
                if (isLoaded){
                    this.loadCountryData(reports, region);
                    this.loadCasesData(reports);
                }
            }catch (Exception e){
                log.error("Failed: Region {} data could not be loaded", regionString);
            }

        });

    }

    private boolean loadTotalCases(TotalCase worldTotal, Region region, String time){
        boolean loaded = false;
        worldTotal.setRegion(region);
        worldTotal.setLatestUpdate(time);

        if (!totalCaseRepository.existsByLatestUpdateAndRegion(worldTotal.getLatestUpdate(), region)){
            totalCaseRepository.save(worldTotal);
            loaded = true;
        }else {
            log.info("Data was not saved, the feed is not updated yet");
        }
        return loaded;
    }

    private void loadCountryData(List<Report> reports, Region region){
        Set<Region> regions = new HashSet<>();
        regions.add(region);
        reports.forEach(report -> {
            Country country = new Country()
                    .setIso(report.getCountryCode())
                    .setIso3("")
                    .setName(report.getCountry())
                    .setNiceName(report.getCountry())
                    .setNumCode("")
                    .setPhoneCode("")
                    .setRegions(regions)
                    .build();
            if (!countryRepository.findByNiceName(report.getCountry()).isPresent()){
                countryRepository.save(country);
            }
        });
    }

    private void loadCasesData(List<Report> reports){
        List<ReportedCase> reportedCases = new ArrayList<>();
        reports.forEach(report->{
            Country country = countryRepository.findByNiceName(report.getCountry()).get();
            ReportedCase reportedCase = new ReportedCase()
                    .setState(report.getState())
                    .setConfirmed(report.getConfirmed())
                    .setDeaths(report.getDeaths())
                    .setRecovered(report.getRecovered())
                    .setLastUpdated(report.getLastUpdated())
                    .setDailyConfirmed(report.getDailyConfirmed())
                    .setDailyDeaths(report.getDailyDeaths())
                    .setCritical(report.getCritical())
                    .setTests(report.getTests())
                    .setCountry(country);
            reportedCases.add(reportedCase);
        });
        reportedCaseRepository.saveAll(reportedCases);
    }

}


/*
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
 */