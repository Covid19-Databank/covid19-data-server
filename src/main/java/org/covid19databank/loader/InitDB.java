package org.covid19databank.loader;

import org.covid19databank.services.DataLoaderService;
import org.covid19databank.services.InitDataBaseService;
import org.covid19databank.services.LiteratureLoaderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class InitDB implements CommandLineRunner {

    private DataLoaderService dataLoaderService;
    private InitDataBaseService initDataBaseService;
    private LiteratureLoaderService literatureLoaderService;

    @Value("${init.database}")
    private boolean iniitializeDatabase;

    public InitDB(DataLoaderService dataLoaderService, InitDataBaseService initDataBaseService, LiteratureLoaderService literatureLoaderService) {
        this.dataLoaderService = dataLoaderService;
        this.initDataBaseService = initDataBaseService;
        this.literatureLoaderService = literatureLoaderService;
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
    }
}
