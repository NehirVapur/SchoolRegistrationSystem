package com.mantis.schoolRegistrationSystem.dto.ResponseDTOs;

import java.time.LocalDateTime;
import java.util.List;

public class SchoolResponse {
    private Long id;
    private String name;
    private AdressResponse adress;
    private String managerName;
    private List<String> courseName;
    private LocalDateTime createdAt;

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

    public AdressResponse getAdress() {
        return adress;
    }

    public void setAdress(AdressResponse adress) {
        this.adress = adress;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public List<String> getCourseName() {
        return courseName;
    }

    public void setCourseName(List<String> courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
