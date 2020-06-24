package org.covid19databank.payload.europepmc;

import java.util.List;

public class ResearchData {

    private int hitCount;
    private List<Entry> entries;
    private List facets;

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public List getFacets() {
        return facets;
    }

    public void setFacets(List facets) {
        this.facets = facets;
    }
}
