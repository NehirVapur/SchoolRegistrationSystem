package com.mantis.schoolRegistrationSystem.dto.RequestDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateManagerRequest {
    @NotBlank(message = "İsim olmalı.")
    private String name;
    @NotBlank(message = "Soyisim olmalı.")
    private String surname;
    @NotNull(message = "Email boş olamaz.")
    private String email;
    @NotNull(message = "Şifre boş olamaz.")
    private String password;



    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank(message = "Okul ID'si olmalı.")
    private Long schoolId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }
}
