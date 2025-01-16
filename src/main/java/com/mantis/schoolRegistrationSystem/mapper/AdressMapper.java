package com.mantis.schoolRegistrationSystem.mapper;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateAdressRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.AdressResponse;
import com.mantis.schoolRegistrationSystem.entity.Adress;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdressMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public AdressMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Adress toEntity(CreateAdressRequest request){
        return modelMapper.map(request, Adress.class);
    }

    public AdressResponse toResponse(Adress adress){
        return modelMapper.map(adress, AdressResponse.class);
    }
}
