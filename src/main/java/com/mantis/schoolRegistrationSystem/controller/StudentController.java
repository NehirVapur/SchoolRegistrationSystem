package com.mantis.schoolRegistrationSystem.controller;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateStudentRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.StudentResponse;
import com.mantis.schoolRegistrationSystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // Yeni öğrenci oluşturma
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse createStudent(@RequestBody @Valid CreateStudentRequest request){
        return studentService.create(request);
    }

    // ID'ye göre öğrenci getirme
    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id){
        return studentService.getById(id);
    }

    // Tüm öğrencileri getirme
    @GetMapping
    public List<StudentResponse> getAllStudents(){
        return studentService.getAll();
    }

    // Öğrenci güncelleme
    @PutMapping("/{id}")
    public StudentResponse updateStudent(@PathVariable Long id, @RequestBody @Valid CreateStudentRequest request){
        return studentService.update(id, request);
    }

    // Öğrenci silme
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudents(@PathVariable Long id){
        studentService.delete(id);
    }



}
