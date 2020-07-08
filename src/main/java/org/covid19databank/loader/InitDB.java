package org.covid19databank.loader;

import org.covid19databank.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class InitDB implements CommandLineRunner {

    private DataLoaderService dataLoaderService;
    private InitDataBaseService initDataBaseService;
    private LiteratureLoaderService literatureLoaderService;
    private TargetLoaderService targetLoaderService;
    private ExpressionLoaderService expressionLoaderService;

    @Value("${init.database}")
    private boolean iniitializeDatabase;

    public InitDB(DataLoaderService dataLoaderService, InitDataBaseService initDataBaseService, LiteratureLoaderService literatureLoaderService, TargetLoaderService targetLoaderService, ExpressionLoaderService expressionLoaderService) {
        this.dataLoaderService = dataLoaderService;
        this.initDataBaseService = initDataBaseService;
        this.literatureLoaderService = literatureLoaderService;
        this.targetLoaderService = targetLoaderService;
        this.expressionLoaderService = expressionLoaderService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (iniitializeDatabase) {
            initDataBaseService.loadRegions();
            initDataBaseService.loadLiteratureTypes();
            initDataBaseService.loadExpressionTypes();
           // initDataBaseService.loadCountries();
        }

        dataLoaderService.getCasesData();
        literatureLoaderService.getLiteratureData();
        targetLoaderService.getTargetData();
        expressionLoaderService.getExpressionData();


    }
}
