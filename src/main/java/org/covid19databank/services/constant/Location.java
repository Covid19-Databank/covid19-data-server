package org.covid19databank.services.constant;

public enum Location {

    CASES_URL("https://cov19.cc/report.json"),
    COUNTRIES_URL(System.getProperty("user.dir")+"/countries.json"),

    ONCO_MX_URL_PREFIX("...");


    private String value;

    private Location(String val) {
        value = val;
    }

    public String get() {
        return value;
    }
}
