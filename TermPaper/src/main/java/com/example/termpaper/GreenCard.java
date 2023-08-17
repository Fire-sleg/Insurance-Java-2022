package com.example.termpaper;

public class GreenCard {
    private String region_of_stay;
    private String vehicle;

    public GreenCard(String region_of_stay, String vehicle) {
        this.region_of_stay = region_of_stay;
        this.vehicle = vehicle;
    }

    public String getRegion_of_stay() {
        return region_of_stay;
    }

    public void setRegion_of_stay(String region_of_stay) {
        this.region_of_stay = region_of_stay;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "GreenCard{" +
                "region_of_stay='" + region_of_stay + '\'' +
                ", vehicle='" + vehicle + '\'' +
                '}';
    }
}
