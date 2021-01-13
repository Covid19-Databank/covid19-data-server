package org.covid19databank.services.constant;

import java.util.HashMap;
import java.util.Map;

public enum SequenceTypeEnum {


    SEQUENCES("Sequences", "https://www.ebi.ac.uk/ebisearch/ws/rest/embl/?query=TAXONOMY:2697049&size=15&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=collection_date,country,host,strain,isolate,lat_lon,molecule_type,TAXON&entryattrs=score"),

    RAW_READS("Raw Reads", "https://www.ebi.ac.uk/ebisearch/ws/rest/sra-experiment/?query=covid-19 OR sars-cov-2 OR ncov OR TAXON:2697049 OR (severe acute respiratory syndrome coronavirus 2) OR PROJECT:(PRJNA605247 OR PRJNA606159 OR PRJNA607948 OR PRJNA606165 OR PRJEB37886 OR PRJEB37966 OR PRJEB37513 OR PRJEB38351 OR PRJEB38388)&size=15&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=acc,description,TAXON&entryattrs=score"),

    SEQUENCED_SAMPLES("Sequenced Samples", "https://www.ebi.ac.uk/ebisearch/ws/rest/biosamples-covid19/?query=id:[* TO *]&size=15&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=name,description,insdc_center_name,collection_date,geographic_location_country_andor_sea,host,isolate,strain,TAXONOMY&entryattrs=score"),

    STUDIES("Study", "https://www.ebi.ac.uk/ebisearch/ws/rest/project/?query=TAXONOMY:(2697049) OR id:(PRJEB36487 OR PRJNA605247 OR PRJNA605927 OR PRJNA606159 OR PRJNA607948 OR PRJNA60615 OR PRJEB37039 OR PRJNA606165 OR PRJEB37886 OR PRJEB37966 OR PRJEB37513 OR PRJEB38351 OR PRJEB38388)&size=15&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=description,long_description,name,scientific_name,TAXON&entryattrs=score"),

    GENES("Gene", "https://www.ebi.ac.uk/ebisearch/ws/rest/ensemblGenomes-cv19_gene/?query=id:[* TO *]&size=15&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=name,description,species,location&entryattrs=score"),

    BROWSER("Browser", "https://www.ebi.ac.uk/ebisearch/ws/rest/ensemblGenomes-cv19_genome/?query=id:[* TO *]&size=15&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=scientific_name,assembly_name,assembly_accession&entryattrs=score"),

    VARIANTS("Variants", "https://www.ebi.ac.uk/ebisearch/ws/rest/ensemblGenomes-cv19_variant/?query=id%3A%5B*%20TO%20*%5D&size=15&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=name%2Cdescription%2Cspecies%2Clocation&entryattrs=score"),

    HOST_DATA("Host data", "https://www.ebi.ac.uk/ebisearch/ws/rest/ega/?query=OLS:\"MONDO:0100096\"&size=15&format=JSON&facetcount=11&fieldurl=true&viewurl=true&fields=name,description&entryattrs=score&facetfields=TAXONOMY");


    private final String type;
    private final String url;

    private static final Map<String, String> MAP = new HashMap<>();

    static {
        for (SequenceTypeEnum s : SequenceTypeEnum.values()) {
            MAP.put(s.type, s.url);
        }
    }

    private SequenceTypeEnum(String type, String url) {
        this.type = type;
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public static String getUrlByType(String type) {
        return MAP.get(type);
    }


}

