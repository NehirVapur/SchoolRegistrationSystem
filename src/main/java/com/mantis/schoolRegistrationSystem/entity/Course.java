package com.mantis.schoolRegistrationSystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer capacity;

    @ManyToOne
    private School school;

    @OneToMany(mappedBy = "course")
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    private List<Student> students;

    //Getter and setter
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public LocalDateTime getStartDate(){
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate){
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate(){
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate){
        this.endDate = endDate;
    }

    public Integer getCapacity(){
        return capacity;
    }
    public void setCapacity(Integer capacity){
        this.capacity = capacity;
    }

    public School getSchool(){
        return school;
    }
    public void setSchool(School school){
        this.school = school;
    }

    public Teacher getTeacher(){
        return teacher;
    }
    public void setTeacher(Teacher teacher){
        this.teacher=teacher;
    }

    public List<Student> getStudents(){
        return students;
    }
    public void setStudents(List<Student> students){
        this.students = students;
    }


}
