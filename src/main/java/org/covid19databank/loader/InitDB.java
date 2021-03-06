package org.covid19databank.loader;

import org.covid19databank.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class InitDB implements CommandLineRunner {

    private Logger log = LoggerFactory.getLogger(InitDB.class);

    private DataLoaderService dataLoaderService;
    private InitDataBaseService initDataBaseService;
    private LiteratureLoaderService literatureLoaderService;
    private TargetLoaderService targetLoaderService;
    private ExpressionLoaderService expressionLoaderService;
    private BrowserLoaderService browserLoaderService;
    private GeneLoaderService geneLoaderService;
    private HostDataLoaderService hostDataLoaderService;
    private RawReadsLoaderService rawReadsLoaderService;
    private SequencedSamplesLoaderService sequencedSamplesLoaderService;
    private SequenceLoaderService sequenceLoaderService;
    private StudiesLoaderService studiesLoaderService;
    private VariantLoaderService variantLoaderService;

    @Value("${init.database}")
    private boolean iniitializeDatabase;

    @Value("${load.data}")
    private boolean loadData;


    public InitDB(DataLoaderService dataLoaderService,
                  InitDataBaseService initDataBaseService,
                  LiteratureLoaderService literatureLoaderService,
                  TargetLoaderService targetLoaderService,
                  ExpressionLoaderService expressionLoaderService,
                  BrowserLoaderService browserLoaderService,
                  GeneLoaderService geneLoaderService,
                  HostDataLoaderService hostDataLoaderService,
                  RawReadsLoaderService rawReadsLoaderService,
                  SequencedSamplesLoaderService sequencedSamplesLoaderService,
                  SequenceLoaderService sequenceLoaderService,
                  StudiesLoaderService studiesLoaderService,
                  VariantLoaderService variantLoaderService) {
        this.dataLoaderService = dataLoaderService;
        this.initDataBaseService = initDataBaseService;
        this.literatureLoaderService = literatureLoaderService;
        this.targetLoaderService = targetLoaderService;
        this.expressionLoaderService = expressionLoaderService;
        this.browserLoaderService = browserLoaderService;
        this.geneLoaderService = geneLoaderService;
        this.hostDataLoaderService = hostDataLoaderService;
        this.rawReadsLoaderService = rawReadsLoaderService;
        this.sequencedSamplesLoaderService = sequencedSamplesLoaderService;
        this.sequenceLoaderService = sequenceLoaderService;
        this.studiesLoaderService = studiesLoaderService;
        this.variantLoaderService = variantLoaderService;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("System successfuly initialized, Is Database initializing ? User set it as: " + iniitializeDatabase);

        if (iniitializeDatabase) {
            log.info("Database intitialization commenced");
            initDataBaseService.loadRegions();
            initDataBaseService.loadLiteratureTypes();
            initDataBaseService.loadExpressionTypes();
            // initDataBaseService.loadCountries();
            initDataBaseService.loadSequenceTypes();

            log.info("Database intialization success");
        }


        if (loadData) {
            log.info("Data Loading starting now");
            //dataLoaderService.getCasesData();
            literatureLoaderService.getLiteratureData();
            targetLoaderService.getTargetData();
            expressionLoaderService.getExpressionData();
            browserLoaderService.getBrowserData();
            geneLoaderService.getGenes();
            hostDataLoaderService.getHostData();
            rawReadsLoaderService.getRawReadsData();
            sequencedSamplesLoaderService.getSequencedSampleData();
            sequenceLoaderService.getSequenceData();
            studiesLoaderService.getStudies();
            variantLoaderService.getVariantData();

            log.info("Data Loading successfuly done");
        }


    }
}
