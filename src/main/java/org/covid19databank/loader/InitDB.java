package org.covid19databank.loader;

import org.covid19databank.services.DataLoaderService;
import org.covid19databank.services.InitDataBaseService;
import org.covid19databank.services.LiteratureLoaderService;
import org.covid19databank.services.TargetLoaderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class InitDB implements CommandLineRunner {

    private DataLoaderService dataLoaderService;
    private InitDataBaseService initDataBaseService;
    private LiteratureLoaderService literatureLoaderService;
    private TargetLoaderService targetLoaderService;

    @Value("${init.database}")
    private boolean iniitializeDatabase;

    public InitDB(DataLoaderService dataLoaderService, InitDataBaseService initDataBaseService, LiteratureLoaderService literatureLoaderService, TargetLoaderService targetLoaderService) {
        this.dataLoaderService = dataLoaderService;
        this.initDataBaseService = initDataBaseService;
        this.literatureLoaderService = literatureLoaderService;
        this.targetLoaderService = targetLoaderService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (iniitializeDatabase) {
            initDataBaseService.loadRegions();
            initDataBaseService.loadLiteratureTypes();
           // initDataBaseService.loadCountries();
        }

        dataLoaderService.getCasesData();
        literatureLoaderService.getLiteratureData();
        targetLoaderService.getTargetData();

    }
}
