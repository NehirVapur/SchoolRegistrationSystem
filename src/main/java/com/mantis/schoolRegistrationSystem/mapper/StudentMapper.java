package com.mantis.schoolRegistrationSystem.mapper;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateStudentRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.StudentResponse;
import com.mantis.schoolRegistrationSystem.entity.Course;
import com.mantis.schoolRegistrationSystem.entity.Manager;
import com.mantis.schoolRegistrationSystem.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public StudentMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    // CreateStudentRequest -> Student
    public Student toEntity(CreateStudentRequest request){
        return modelMapper.map(request, Student.class);

    }

    //Student -> StudentResponse
    public StudentResponse toResponse(Student student){
        return modelMapper.map(student, StudentResponse.class);
    }
}
