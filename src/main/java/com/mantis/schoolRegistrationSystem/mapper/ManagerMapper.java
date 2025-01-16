package com.mantis.schoolRegistrationSystem.mapper;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateManagerRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.ManagerResponse;
import com.mantis.schoolRegistrationSystem.entity.Manager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public ManagerMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Manager toEntity(CreateManagerRequest request){
        return modelMapper.map(request, Manager.class);
    }

    public ManagerResponse toResponse(Manager manager){
        return modelMapper.map(manager, ManagerResponse.class);
    }
}
