package com.mantis.schoolRegistrationSystem.controller;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateCourseRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.CourseResponse;

import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.StudentResponse;
import com.mantis.schoolRegistrationSystem.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    //Yeni kurs oluşturma endpoint'i
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse createCourse(@RequestBody @Valid CreateCourseRequest request){
        return courseService.create(request);
    }

    // ID'ye göre kurs getirme endpoint'i
    @GetMapping("/{id}")
    public CourseResponse getCourse(@PathVariable Long id) {
        return courseService.getById(id);
    }

    // Tüm kursları listeleme endpoint'i
    @GetMapping
    public List<CourseResponse> getAllCourses() {
        return courseService.getAll();
    }

    // Kurs güncelleme endpoint'i
    @PutMapping("/{id}")
    public CourseResponse updateCourse(@PathVariable Long id, @RequestBody @Valid CreateCourseRequest request) {
        return courseService.update(id, request);
    }

    // Kurs silme endpoint'i
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
    }

    // Kursa öğrenci ekleme endpoint'i
    @PutMapping("/{courseId}/students/{studentId}")
    public void addStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        courseService.addStudent(courseId, studentId);
    }

    // Kurstan öğrenci çıkarma endpoint'i
    @DeleteMapping("/{courseId}/students/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        courseService.removeStudent(courseId, studentId);
    }

    // Kursun öğrencilerini listeleme endpoint'i
    @GetMapping("/{courseId}/students")
    public List<StudentResponse> getCourseStudents(@PathVariable Long courseId) {
        return courseService.getCourseStudents(courseId);
    }

    // Kursa öğretmen atama endpoint'i
    @PutMapping("/{courseId}/teacher/{teacherId}")
    public void assignTeacher(@PathVariable Long courseId, @PathVariable Long teacherId) {
        courseService.assignTeacher(courseId, teacherId);
    }

}
