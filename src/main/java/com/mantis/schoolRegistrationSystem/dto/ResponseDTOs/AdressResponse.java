package com.mantis.schoolRegistrationSystem.dto.ResponseDTOs;

public class AdressResponse {
    private String country;
    private String city;
    private String distriet;
    private String street;
    private String number;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistriet() {
        return distriet;
    }

    public void setDistriet(String distriet) {
        this.distriet = distriet;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
