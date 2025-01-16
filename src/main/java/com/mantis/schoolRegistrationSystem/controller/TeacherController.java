package com.mantis.schoolRegistrationSystem.controller;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateAdressRequest;
import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateTeacherRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.CourseResponse;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.TeacherResponse;
import com.mantis.schoolRegistrationSystem.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    //Yeni öğretmen oluşturma
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherResponse createTeacher(@RequestBody @Valid CreateTeacherRequest request){
        return teacherService.create(request);
    }

    // ID'ye göre öğretmen getirme endpoint'i
    @GetMapping("/{id}")
    public TeacherResponse getTeacher(@PathVariable Long id){
        return teacherService.getById(id);
    }

    // Tüm öğretmenleri listeleme endpoint'i
    @GetMapping
    public List<TeacherResponse> getAllTeacher(){
        return teacherService.getAll();
    }

    // Öğretmen güncelleme endpoint'i
    @PostMapping("/{id}")
    public TeacherResponse updateTeacher(@PathVariable Long id, @RequestBody @Valid CreateTeacherRequest request){
        return teacherService.update(id, request);
    }

    // Öğretmen silme endpoint'i
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacher(@PathVariable Long id){
        teacherService.delete(id);
    }

    // Öğretmenin kurslarını listeleme endpoint'i
    @GetMapping("/{teacherId}/courses")
    public List<CourseResponse> getTeacherCourses(@PathVariable Long teacherId) {
        return teacherService.getTeacherCourses(teacherId);
    }



}
