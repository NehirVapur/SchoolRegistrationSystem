package com.mantis.schoolRegistrationSystem.entity;

import jakarta.persistence.Embeddable;


@Embeddable
public class Adress {
    private String country;
    private String city;
    private String distriet;
    private String street;
    private String number;

    //Getter and Setter

    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country=country;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city=city;
    }

    public String getDistriet(){
        return distriet;
    }
    public void setDistriet(String distriet){
        this.distriet=distriet;
    }

    public String getStreet(){
        return street;
    }
    public void setStreet(String street){
        this.street=street;
    }

    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        this.number = number;
    }
}
