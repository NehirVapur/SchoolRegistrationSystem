package com.mantis.schoolRegistrationSystem.dto.RequestDTOs;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class CreateCourseRequest {
    @NotBlank(message = "İsim olmalı")
    private String name;

    @NotBlank(message = "İçerik olmalı.")
    private String description;

    @NotBlank(message = "Başlama zamanı olmalı.")
    private LocalDateTime startDate;

    @NotBlank(message = "Bitiş tarihi olmalı.")
    private LocalDateTime endDate;

    @NotBlank(message = "Öğrenci sayısı girilmeli.")
    @Min(value = 1, message = "Öğrenci sayısı minimum 1 olabilir.")
    @Max(value = 30, message = "Öğrenci sayısı maksimum 30 olabiliir.")
    private Integer capacity;

    @NotNull(message = "School ID olmalı.")
    private Long schoolId;

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
