package com.example.termpaper;

import java.time.LocalDate;
import java.time.LocalTime;

public class CommonData {

    private LocalDate start_date;
    private int validity;
    private LocalDate finish_date;
    private String company;
    private double cost;

    public CommonData(LocalDate start_date, int validity, LocalDate finish_date, String company, double cost) {
        this.start_date = start_date;
        this.validity = validity;
        this.finish_date = finish_date;
        this.company = company;
        this.cost = cost;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(LocalDate finish_date) {
        this.finish_date = finish_date;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "CommonData{" +
                "start_date=" + start_date +
                ", validity=" + validity +
                ", finish_date=" + finish_date +
                ", company='" + company + '\'' +
                ", cost=" + cost +
                '}';
    }
}
