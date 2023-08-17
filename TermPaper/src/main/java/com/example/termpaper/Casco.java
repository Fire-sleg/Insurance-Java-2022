package com.example.termpaper;

public class Casco {
    private String car_brand;
    private String car_model;
    private int year_of_manufacture_of_the_car;
    private int car_price;

    public Casco(String car_brand, String car_model, int year_of_manufacture_of_the_car, int car_price) {
        this.car_brand = car_brand;
        this.car_model = car_model;
        this.year_of_manufacture_of_the_car = year_of_manufacture_of_the_car;
        this.car_price = car_price;
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

    public int getCar_price() {
        return car_price;
    }

    public void setCar_price(int car_price) {
        this.car_price = car_price;
    }

    @Override
    public String toString() {
        return "Casco{" +
                "car_brand='" + car_brand + '\'' +
                ", car_model='" + car_model + '\'' +
                ", year_of_manufacture_of_the_car=" + year_of_manufacture_of_the_car +
                ", car_price=" + car_price +
                '}';
    }
}
