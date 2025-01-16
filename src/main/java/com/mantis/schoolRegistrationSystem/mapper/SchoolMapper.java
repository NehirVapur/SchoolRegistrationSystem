package com.mantis.schoolRegistrationSystem.mapper;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateSchoolRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.AdressResponse;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.SchoolResponse;
import com.mantis.schoolRegistrationSystem.entity.Adress;
import com.mantis.schoolRegistrationSystem.entity.School;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SchoolMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public SchoolMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;

    }

    // CreateSchoolRequest -> School
    public School toEntity(CreateSchoolRequest request) {
        Adress address = modelMapper.map(request.getAdress(), Adress.class);
        School school = modelMapper.map(request, School.class);
        school.setAdress(address);
        return school;
    }

    //School -> SchoolResponse
    public SchoolResponse toResponse(School school){
        SchoolResponse response = modelMapper.map(school,SchoolResponse.class);
        response.setAdress(modelMapper.map(school.getAdress(), AdressResponse.class));
        return response;
    }


}
