package com.mantis.schoolRegistrationSystem.mapper;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateTeacherRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.TeacherResponse;
import com.mantis.schoolRegistrationSystem.entity.Teacher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public TeacherMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Teacher toEntity(CreateTeacherRequest request){
        return modelMapper.map(request, Teacher.class);
    }

    public TeacherResponse toResponse(Teacher teacher){
        return modelMapper.map(teacher, TeacherResponse.class);
    }
}
