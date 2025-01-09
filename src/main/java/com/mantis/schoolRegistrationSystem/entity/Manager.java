package com.mantis.schoolRegistrationSystem.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Manager extends AuthenticationCredential {
    @OneToOne
    private School school;

    @OneToMany(mappedBy = "manager")
    private List<Student> students;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
