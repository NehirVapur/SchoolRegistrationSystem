package com.mantis.schoolRegistrationSystem.dto.RequestDTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateSchoolRequest {
    @NotBlank(message = "İsim gerekli.")
    private String name;

    @Valid
    @NotNull(message = "Adres gerekli.")
    private CreateAdressRequest adress;
    private Long schoolId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateAdressRequest getAdress() {
        return adress;
    }

    public void setAdress(CreateAdressRequest adress) {
        this.adress = adress;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }
}
