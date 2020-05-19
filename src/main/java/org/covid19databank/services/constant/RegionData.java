package org.covid19databank.services.constant;

public enum RegionData {

    WORLD("world"),
    UNITEDSTATE("unitedstates"),
    CANADA("canada"),
    CHINA("china"),
    AUSTRALIA("australia"),
    ASIA("asia"),
    EUROPE("europe"),
    ANTARCTICA("antarctica"),
    AFRICA("africa"),
    OCEANIA("oceania"),
    NORTHAMERICA("northamerica"),
    SOUTHAMERICA("southamerica"),
    SHIPA("ships"),
    ITALY("italy"),
    RUSSIA("russia"),
    IRELAND("ireland");

    private String value;

    private RegionData(String val) {
        value = val;
    }

    public String get() {
        return value;
    }

}
