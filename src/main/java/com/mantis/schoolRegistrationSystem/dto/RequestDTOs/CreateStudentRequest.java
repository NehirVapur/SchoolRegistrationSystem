package com.mantis.schoolRegistrationSystem.dto.RequestDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CreateStudentRequest {
    @NotBlank(message = "İsim olmalı.")
    private String name;

    @NotBlank(message = "Soyad olmalı.")
    private String surname;

    @NotBlank(message = "Email olmalı.")
    @NotNull(message = "Email boş olmamalı.")
    @Email(message = "Email doğru formatta olmalı.")
    private String email;

    @NotBlank(message = "Şifre olmalı.")
    @NotNull(message = "Şifre boş olamaz.")
    private String password;

    @NotBlank(message = "Okul numarası olmalı.")
    private String schoolNumber;

    @NotBlank(message = "Kurs ID'si olmalı.")
    private Long courseId;



    @NotBlank(message = "Başlama tarihi olmalı.")
    private LocalDateTime startDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
}
