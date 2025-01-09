package com.mantis.schoolRegistrationSystem.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Student extends AuthenticationCredential {

    private String schoolNumber;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Manager manager;

    @Column(updatable = false)
    private LocalDateTime requestDate;

    @PrePersist
    protected void onCreate(){
        requestDate = LocalDateTime.now();

    }

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}


