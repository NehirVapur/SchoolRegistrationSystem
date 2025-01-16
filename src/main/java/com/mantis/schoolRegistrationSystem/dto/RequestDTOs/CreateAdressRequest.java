package com.mantis.schoolRegistrationSystem.dto.RequestDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateAdressRequest {
    @NotBlank(message = "Adres olmalı.")
    private String country;
    @NotBlank(message = "Şehir olmalı.")
    private String city;
    @NotBlank(message = "Semt olmalı.")
    private String distriet;
    @NotBlank(message = "Sokak olmalı.")
    private String street;
    @NotBlank(message = "Numara olmalı.")
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

    public CreateAdressRequest getAdress() {
        return null;
    }
}
