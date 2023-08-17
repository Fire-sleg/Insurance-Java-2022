package com.example.termpaper;

public class MotorLiability {
    private String car_number;
    private String car_brand;
    private String car_model;
    private int year_of_manufacture_of_the_car;
    private String body_number;

    public MotorLiability(String car_number, String car_brand, String car_model, int year_of_manufacture_of_the_car, String body_number) {
        this.car_number = car_number;
        this.car_brand = car_brand;
        this.car_model = car_model;
        this.year_of_manufacture_of_the_car = year_of_manufacture_of_the_car;
        this.body_number = body_number;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public int getYear_of_manufacture_of_the_car() {
        return year_of_manufacture_of_the_car;
    }

    public void setYear_of_manufacture_of_the_car(int year_of_manufacture_of_the_car) {
        this.year_of_manufacture_of_the_car = year_of_manufacture_of_the_car;
    }

    public String getBody_number() {
        return body_number;
    }

    public void setBody_number(String body_number) {
        this.body_number = body_number;
    }

    @Override
    public String toString() {
        return "MotorLiability{" +
                "car_number='" + car_number + '\'' +
                ", car_brand='" + car_brand + '\'' +
                ", car_model='" + car_model + '\'' +
                ", year_of_manufacture_of_the_car=" + year_of_manufacture_of_the_car +
                ", body_number='" + body_number + '\'' +
                '}';
    }
}
