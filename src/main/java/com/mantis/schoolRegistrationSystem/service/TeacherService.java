package com.mantis.schoolRegistrationSystem.service;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateTeacherRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.CourseResponse;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.TeacherResponse;
import com.mantis.schoolRegistrationSystem.entity.Course;
import com.mantis.schoolRegistrationSystem.entity.Teacher;
import com.mantis.schoolRegistrationSystem.mapper.CourseMapper;
import com.mantis.schoolRegistrationSystem.mapper.TeacherMapper;
import com.mantis.schoolRegistrationSystem.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final CourseMapper courseMapper;


    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper, CourseMapper courseMapper){
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
        this.courseMapper = courseMapper;
    }

    // Yeni öğretmen oluşturma
    public TeacherResponse create(CreateTeacherRequest request){
        Teacher teacher = teacherMapper.toEntity(request);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return teacherMapper.toResponse(savedTeacher);
    }

    // ID'ye göre öğretmen getirme
    public TeacherResponse getById(Long id){
        Teacher teacher = teacherRepository.findById(id).orElseThrow();
        return teacherMapper.toResponse(teacher);
    }

    //Öğretnmen güncelleme

    public TeacherResponse update(Long id, CreateTeacherRequest request){
        Teacher existTeacher = teacherRepository.findById(id).orElseThrow();
        Teacher secondTeacher = teacherMapper.toEntity(request);
        secondTeacher.setId(existTeacher.getId());
        teacherRepository.save(secondTeacher);
        return teacherMapper.toResponse(secondTeacher);
    }

    //Tüm öğretmenleri getirme
    public List<TeacherResponse> getAll(){
        return teacherRepository.findAll().stream().
                map(teacherMapper::toResponse)
                .collect(Collectors.toList());
    }
    public void delete(Long id){
        teacherRepository.deleteById(id);
    }

    public List<CourseResponse> getTeacherCourses(Long teacherId) {
        // Öğretmeni bul ve hata mesajı ver
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        // Öğretmenin kurslarını CourseResponse'a çevir ve listele
        return teacher.getCourses().stream().map(courseMapper::toResponse).toList();
    }
}
