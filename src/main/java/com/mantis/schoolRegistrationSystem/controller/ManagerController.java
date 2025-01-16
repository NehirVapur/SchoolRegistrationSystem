package com.mantis.schoolRegistrationSystem.controller;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateManagerRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.ManagerResponse;
import com.mantis.schoolRegistrationSystem.service.ManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    // Yeni manager oluşturma
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ManagerResponse createManagers(@RequestBody @Valid CreateManagerRequest request){
        return managerService.crate(request);
    }

    // Manager bilgilerini getirme
    @GetMapping("/{managerId}")
    public ManagerResponse getManager(@PathVariable Long managerId){
        return managerService.getById(managerId);
    }

    // Tüm managerları getirme
    @GetMapping
    private List<ManagerResponse> getAllManager(){
        return managerService.getAll();
    }

    @PutMapping("/{managerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteManager(@PathVariable Long managerId){
        managerService.delete(managerId);
    }
}
