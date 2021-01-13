package org.covid19databank.services.constant;

import java.util.HashMap;
import java.util.Map;

public enum ExpressionTypeEnum {

    GENES_EXPRESSION_EXPERIMENT("Gene Expression Experiment", "https://www.ebi.ac.uk/ebisearch/ws/rest/atlas-experiments/?query=coronavirus OR SARS OR coronaviruses OR icSARS OR id:(E-GEOD-27973 OR E-GEOD-34205 OR E-GEOD-36287 OR E-GEOD-52405)&size=15&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=name,description,publication_date,TAXONOMY&entryattrs=score&facetfields=publication_date,TAXONOMY"),

    GENE_EXPRESSION("Gene Expression", "https://www.ebi.ac.uk/ebisearch/ws/rest/atlas-genes/?query=name:(ACE2^1.1 OR TMPRSS2^1.1 OR CTSB OR CTSL) TAXONOMY:9606&size=15&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=name,description,TAXONOMY&entryattrs=score"),

    //SINGLE_CELL_EXPRESSION_EXPERIMENT("Single Cell Expression Experiment", ""),

    //SINGLE_CELL_EXPRESSION("Single Cell Expression", ""),

    PROTEIN_EXPRESSION_EXPERIMENT("Protein Expression Experiment", "https://www.ebi.ac.uk/ebisearch/ws/rest/pride/?query=curator_keywords:Sars-cov-2&size=15&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=name,description,species,publication_date&entryattrs=score&facetfields=disease,tissue,publication_date,domain_source,TAXONOMY");


    private final String type;
    private final String url;

    private static final Map<String, String> MAP = new HashMap<>();

    static {
        for (ExpressionTypeEnum s : ExpressionTypeEnum.values()) {
            MAP.put(s.type, s.url);
        }
    }

    private ExpressionTypeEnum(String type, String url) {
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
