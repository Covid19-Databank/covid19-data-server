package org.covid19databank.services.constant;

public enum GeneralEnum {

    Target_URL("https://www.ebi.ac.uk/ebisearch/ws/rest/complex-portal/?query=TAXONOMY:(2697049 OR 694009)&size=15&format=JSON&facetcount=10&fieldurl=true&viewurl=true&fields=name,description,organism,curated-complex&entryattrs=score");


    private String value;

    private GeneralEnum(String val) {
        value = val;
    }

    public String get() {
        return value;
    }
}
