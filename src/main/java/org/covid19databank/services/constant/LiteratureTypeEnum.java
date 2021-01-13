package org.covid19databank.services.constant;

import java.util.HashMap;
import java.util.Map;

public enum LiteratureTypeEnum {

    CORONA("Corona viruses", "https://www.ebi.ac.uk/ebisearch/ws/rest/europepmc/?query=2019-nCov OR 2019nCov OR COVID-19 OR (SARS CoV) OR coronavirus OR \"corona-virus\" OR \"corona-viruses\"&size=100&sort=publication_date:descending,_relevance:descending&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=name,author,display_author,publication_date,journal,volume,issue,pagination,pmcid,ORCID,source&entryattrs=score"),

    DISEASES("Diseases", "https://www.ebi.ac.uk/ebisearch/ws/rest/europepmc/?query=\"Severe Acute Respiratory Syndrome\" OR \"Middle East Respiratory Syndrome\" OR covid-19&size=100&sort=publication_date:descending,_relevance:descending&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=name,author,display_author,publication_date,journal,volume,issue,pagination,pmcid,ORCID,source&entryattrs=score"),

    RELATED_VIRUSES("Related Viruses And Diseases", "https://www.ebi.ac.uk/ebisearch/ws/rest/europepmc/?query=(\"SAR-Cov\" OR \"MERS-Cov\") (\"Severe Acute Respiratory Syndrome\" OR \"Middle East Respiratory Syndrome\")&size=100&sort=publication_date:descending,_relevance:descending&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=name,author,display_author,publication_date,journal,volume,issue,pagination,pmcid,ORCID,source&entryattrs=score"),

    GENES_RECEPTORS_AND_ANTIBODIES("Gene, Receptors And Antibodies", "https://www.ebi.ac.uk/ebisearch/ws/rest/europepmc/?query=\"coronavirus spike protein\" OR \"angiotensin-converting enzyme 2\" OR TMPRSS2&size=100&sort=publication_date:descending,_relevance:descending&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=name,author,display_author,publication_date,journal,volume,issue,pagination,pmcid,ORCID,source&entryattrs=score");


    private final String type;
    private final String url;

    private static final Map<String, String> MAP = new HashMap<>();

    static {
        for (LiteratureTypeEnum s : LiteratureTypeEnum.values()) {
            MAP.put(s.type, s.url);
        }
    }

    private LiteratureTypeEnum(String type, String url) {
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