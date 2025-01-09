package com.mantis.schoolRegistrationSystem.dto.ResponseDTOs;

import com.mantis.schoolRegistrationSystem.entity.School;

import java.time.LocalDateTime;

public class ManagerResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private SchoolResponse schoolResponse;
    private String password;
    private LocalDateTime requestDate;
    private StudentResponse studentResponse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public SchoolResponse getSchoolResponse() {
        return schoolResponse;
    }

    public void setSchoolResponse(SchoolResponse schoolResponse) {
        this.schoolResponse = schoolResponse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public StudentResponse getStudentResponse() {
        return studentResponse;
    }

    public void setStudentResponse(StudentResponse studentResponse) {
        this.studentResponse = studentResponse;
    }
}
