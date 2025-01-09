package com.mantis.schoolRegistrationSystem.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Teacher extends AuthenticationCredential {

    @OneToMany
    private Course course;

    public Course getCourse(){
        return course;
    }
    public void setCourse(Course course){
        this.course = course;
    }

}
