package io.ianclark226.coronavirustracker.models;

public class LocationStats {
    private String state;
    private String country;
    private int latestTotalCases;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String state) {
        this.state = state;
    }

    public String getLatestTotalCases() {
        return latestTotalCases;
    }

    public void setLatestTotalCases(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "LocationStats{" + 
        "state='" + country + '\'' +
        ", latestTotalCases=" + latestTotalCases +
        '}';
    }
}
