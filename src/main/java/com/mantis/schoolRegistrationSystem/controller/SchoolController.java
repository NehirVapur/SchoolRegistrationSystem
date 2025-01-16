package com.mantis.schoolRegistrationSystem.controller;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateAdressRequest;
import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateCourseRequest;
import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateSchoolRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.CourseResponse;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.SchoolResponse;
import com.mantis.schoolRegistrationSystem.entity.School;
import com.mantis.schoolRegistrationSystem.service.SchoolService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")

public class SchoolController {

    private final SchoolService schoolService;

    //Constructor injection
    public SchoolController (SchoolService schoolService){
        this.schoolService = schoolService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public SchoolResponse createSchool(@RequestBody @Valid CreateSchoolRequest request){
        return schoolService.create(request);
    }

    @GetMapping("/{id}")
    public SchoolResponse getSchool(@PathVariable Long id){
        return schoolService.getById(id);
    }

    @GetMapping
    public List<SchoolResponse> getAllSchool(){
        return schoolService.getAll();
    }

    @PutMapping("/{id}")
    public SchoolResponse updateSchool(
            @PathVariable Long id,
            @RequestBody @Valid CreateSchoolRequest request){
        return schoolService.update(id, request);
    }

    @PutMapping("/{schoolId}/manager/{managerId}")
    public void assignManager(
            @PathVariable Long schoolId,
            @PathVariable Long managerId){
        schoolService.assignManager(schoolId, managerId);
    }
    @PostMapping("/{schoolId}/address")
    public void updateAdress(
            @PathVariable Long schoolId,
            @RequestBody @Valid CreateAdressRequest request){
        schoolService.updateAddress(schoolId, request);
    }

    @PostMapping("/{schoolId}/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCourse(
            @PathVariable Long schoolId,
            @RequestBody @Valid CreateCourseRequest request) { // CreateSchoolRequest yerine CreateCourseRequest
        schoolService.addCourse(schoolId, request);
    }

    // Okulun kurslarını listeleme endpoint'i
    @GetMapping("/{schoolId}/courses")
    public List<CourseResponse> getSchoolCourses(@PathVariable Long schoolId) {
        return schoolService.getSchoolCourses(schoolId);
    }

    // Okuldan kurs silme endpoint'i
    @DeleteMapping("/{schoolId}/courses/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCourse(
            @PathVariable Long schoolId,
            @PathVariable Long courseId) {
        schoolService.removeCourse(schoolId, courseId);
    }



}
