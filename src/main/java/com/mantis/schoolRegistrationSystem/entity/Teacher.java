package com.mantis.schoolRegistrationSystem.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher extends AuthenticationCredential {

    @OneToMany
    private Course course;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses = new ArrayList<>();

    @Embedded
    private Adress adress;

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Course getCourse(){
        return course;
    }
    public void setCourse(Course course){
        this.course = course;
    }

}
