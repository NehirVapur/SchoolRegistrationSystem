package com.mantis.schoolRegistrationSystem.service;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateManagerRequest;
import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateStudentRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.ManagerResponse;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.StudentResponse;
import com.mantis.schoolRegistrationSystem.entity.Manager;
import com.mantis.schoolRegistrationSystem.entity.Student;
import com.mantis.schoolRegistrationSystem.mapper.StudentMapper;
import com.mantis.schoolRegistrationSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper= studentMapper;
    }

    // Yeni öğrenci oluşturma
    public StudentResponse create(CreateStudentRequest request){
        Student student = studentMapper.toEntity(request);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponse(savedStudent);
    }

    // ID'ye göre öğrenci getirme
    public StudentResponse getById(Long id){
        Student student = studentRepository.findById(id).orElseThrow();
        return studentMapper.toResponse(student);
    }

    //Tüm öğrencileri getirme
    public List<StudentResponse> getAll(){
        return studentRepository.findAll().stream().
                map(studentMapper::toResponse)
                .collect(Collectors.toList());
    }

    // Student güncelleme
    public StudentResponse update(Long id, CreateStudentRequest request) {
        Student existStudent = studentRepository.findById(id).orElseThrow();
        Student secondStudent = studentMapper.toEntity(request);
        secondStudent.setId(existStudent.getId());
        studentRepository.save(secondStudent);
        return studentMapper.toResponse(secondStudent);
    }

    //Öğrenci silme
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

}

