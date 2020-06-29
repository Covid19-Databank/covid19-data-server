package org.covid19databank.services;

import org.covid19databank.datamodel.Target;
import org.covid19databank.payload.europepmc.Entry;
import org.covid19databank.payload.europepmc.ResearchData;
import org.covid19databank.repository.TargetRepository;
import org.covid19databank.services.constant.GeneralEnum;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TargetLoaderService {

    private RestTemplate restTemplate;
    private TargetRepository targetRepository;

    public TargetLoaderService(RestTemplate restTemplate, TargetRepository targetRepository) {
        this.restTemplate = restTemplate;
        this.targetRepository = targetRepository;
    }


    public void getTargetData() {
        List<GeneralEnum> targetEnums = Arrays.asList(GeneralEnum.values());
        targetEnums.forEach(targetEnum -> {
            String url = targetEnum.Target_URL.get();

            ResearchData data = restTemplate.getForObject(url, ResearchData.class);
            List<Entry> entries = data.getEntries();

            LoadTargetData(entries);

        });
    }


    public void LoadTargetData(List<Entry> entries) {
        entries.forEach(entry -> {
            String targetId = entry.getId();
            String description = join(entry.getFields().getDescription());
            String organism = join(entry.getFields().getOrganism());
            String curatedComplex = join(entry.getFields().getCuratedComplex());

            Target target = new Target(targetId, description, organism, curatedComplex);
            targetRepository.save(target);

        });

    }

    public String join(List<String> list) {
        return String.join(",", list);
    }
}
