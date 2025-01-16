package com.mantis.schoolRegistrationSystem.controller;


import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateAdressRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.AdressResponse;
import com.mantis.schoolRegistrationSystem.entity.Adress;
import com.mantis.schoolRegistrationSystem.entity.Teacher;
import com.mantis.schoolRegistrationSystem.mapper.AdressMapper;
import com.mantis.schoolRegistrationSystem.repository.TeacherRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher/{teacherId}/adress")
public class AddressController {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private AdressMapper adressMapper;

    // Adres ekleme endpoint'i
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addAdress(@PathVariable Long teacherId, @RequestBody @Valid CreateAdressRequest request){
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new RuntimeException("Teacher not found"));

        // Yeni adresi oluştur
        Adress newAdres = adressMapper.toEntity(request);
        teacher.setAdress(newAdres); // Teacher'a yeni adres
        teacherRepository.save(teacher);
    }

    // Adres güncelleme endpoint'i
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateAdress(@PathVariable Long teacherId, @RequestBody @Valid CreateAdressRequest request){
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new RuntimeException("Teacher not found"));

        // Eğer öğretmenin adresi yoksa yeni adres ekle
        if (teacher.getAdress() == null) {
            Adress newAdress = adressMapper.toEntity(request);
            teacher.setAdress(newAdress);
        } else {
            // Öğretmenin mevcut adresini güncelle
            Adress existAdress = teacher.getAdress();
            existAdress.setCountry(request.getCountry());
            existAdress.setCity(request.getCity());
            existAdress.setDistriet(request.getDistriet());
            existAdress.setStreet(request.getStreet());
            existAdress.setNumber(request.getNumber());
        }

        teacherRepository.save(teacher);


    }

    @GetMapping
    public AdressResponse getAdress(@PathVariable Long teacherId){
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new RuntimeException("Teacher not found"));
        return adressMapper.toResponse(teacher.getAdress());
    }
}
