package org.covid19databank.payload.cov19cc;

import org.covid19databank.datamodel.TotalCase;
import org.covid19databank.payload.Report;

import java.util.List;

public class RegionData {

    private String name;
    private TotalCase totals;
    private List<Report> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TotalCase getTotals() {
        return totals;
    }

    public void setTotals(TotalCase totals) {
        this.totals = totals;
    }

    public List<Report> getList() {
        return list;
    }

    public void setList(List<Report> list) {
        this.list = list;
    }
}
