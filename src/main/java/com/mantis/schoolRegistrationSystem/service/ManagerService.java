package com.mantis.schoolRegistrationSystem.service;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateManagerRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.ManagerResponse;
import com.mantis.schoolRegistrationSystem.entity.Manager;
import com.mantis.schoolRegistrationSystem.mapper.ManagerMapper;
import com.mantis.schoolRegistrationSystem.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;
    public final ManagerMapper managerMapper;

    public ManagerService(ManagerRepository managerRepository, ManagerMapper managerMapper){
        this.managerMapper = managerMapper;
        this.managerRepository = managerRepository;
    }

    // Yeni müdür oluşturma
    public ManagerResponse crate(CreateManagerRequest request){
        Manager manager = managerMapper.toEntity(request);
        Manager savedManager = managerRepository.save(manager);
        return managerMapper.toResponse(savedManager);
    }

    // ID'ye göre müdür getirme
    public ManagerResponse getById(Long id) {

        Manager manager = managerRepository.findById(id)
                .orElseThrow();

        return managerMapper.toResponse(manager);
    }

    // Tüm müdürleri getirme
    public List<ManagerResponse> getAll() {

        return managerRepository.findAll().stream()
                .map(managerMapper::toResponse)
                .collect(Collectors.toList());
    }

    // Müdür güncelleme
    public ManagerResponse update(Long id, CreateManagerRequest request) {
        Manager existManager = managerRepository.findById(id).orElseThrow();
        Manager secondManager = managerMapper.toEntity(request);
        secondManager.setId(existManager.getId());
        managerRepository.save(secondManager);
        return managerMapper.toResponse(secondManager);
    }

    // Müdür silme
    public void delete(Long id) {
        managerRepository.deleteById(id);
    }
}
