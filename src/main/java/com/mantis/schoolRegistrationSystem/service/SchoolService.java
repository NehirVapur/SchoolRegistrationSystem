package com.mantis.schoolRegistrationSystem.service;


import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateAdressRequest;
import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateCourseRequest;
import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateSchoolRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.CourseResponse;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.SchoolResponse;
import com.mantis.schoolRegistrationSystem.entity.Adress;
import com.mantis.schoolRegistrationSystem.entity.Course;
import com.mantis.schoolRegistrationSystem.entity.Manager;
import com.mantis.schoolRegistrationSystem.entity.School;
import com.mantis.schoolRegistrationSystem.mapper.AdressMapper;
import com.mantis.schoolRegistrationSystem.mapper.CourseMapper;
import com.mantis.schoolRegistrationSystem.mapper.SchoolMapper;
import com.mantis.schoolRegistrationSystem.repository.CourseRepository;
import com.mantis.schoolRegistrationSystem.repository.ManagerRepository;
import com.mantis.schoolRegistrationSystem.repository.SchoolRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    // Repository ve mapper'ları inject ediyoruz
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;
    private final ManagerRepository managerRepository;
    private final AdressMapper addressMapper;
    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;

    // Constructor injection
    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper, ManagerRepository managerRepository, AdressMapper addressMapper, CourseMapper courseMapper, CourseRepository courseRepository){
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
        this.managerRepository = managerRepository;
        this.addressMapper = addressMapper;
        this.courseMapper = courseMapper;
        this.courseRepository = courseRepository;
    }
    // Yeni okul oluşturma
    public SchoolResponse create(CreateSchoolRequest request){
        School school = schoolMapper.toEntity(request);
        School savedSchool = schoolRepository.save(school);

        return schoolMapper.toResponse(savedSchool);
    }

    // ID'ye göre okul getirme
    public SchoolResponse getById(Long id){
//        TODO : throw exception
        School school = schoolRepository.findById(id).orElseThrow();
        return schoolMapper.toResponse(school);
    }

    // Tüm okulları getirme
    public List<SchoolResponse> getAll(){
        return schoolRepository.findAll().stream()
                .map(schoolMapper::toResponse)
                .collect(Collectors.toList());
    }

    // Müdür atama metodu
    public void assignManager(Long schoolId, Long managerId) {
        // TODO : throw exception
        School school = schoolRepository.findById(schoolId).orElseThrow();
        Manager manager = managerRepository.findById(managerId).orElseThrow();

        school.setManager(manager);
        schoolRepository.save(school);
    }

    // Adres güncelleme metodu
    public void updateAddress(Long schoolId, @Valid CreateAdressRequest request) {
        // TODO : throw exception
        School school = schoolRepository.findById(schoolId).orElseThrow();
        Adress address = addressMapper.toEntity(request.getAdress());
        school.setAdress(address);
        schoolRepository.save(school);
    }

    // Kurs ekleme metodu - CreateCourseRequest ile
    public void addCourse(Long schoolId, CreateCourseRequest request) {
        // TODO : throw exception
        School school = schoolRepository.findById(schoolId).orElseThrow();

        // Yeni kurs oluştur
        Course course = courseMapper.toEntity(request);
        course.setSchool(school);

        // Kursu okula ekle
        school.getCourses().add(course);

        // Kaydet
        schoolRepository.save(school);
    }
    //Okulları güncelleme
    public SchoolResponse update(Long id, CreateSchoolRequest request){
        //TODO : throw exception
        School existSchool = schoolRepository.findById(id).orElseThrow();
        School secondSchool = schoolMapper.toEntity(request);
        secondSchool.setId(existSchool.getId());
        schoolRepository.save(secondSchool);
        return schoolMapper.toResponse(secondSchool);
    }

    // Okulun kurslarını getirme metodu
    public List<CourseResponse> getSchoolCourses(Long schoolId) {
        // TODO : throw exception
        School school = schoolRepository.findById(schoolId).orElseThrow();
        return school.getCourses().stream()
                .map(courseMapper::toResponse)
                .collect(Collectors.toList());
    }

    // Kurs silme metodu
    public void removeCourse(Long schoolId, Long courseId) {
        // TODO : throw exception
        School school = schoolRepository.findById(schoolId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        // Kursun bu okula ait olup olmadığını kontrol et
        if (!course.getSchool().getId().equals(schoolId)) {
            throw new IllegalArgumentException("Course does not belong to this school");
        }

        // Kursu okuldan kaldır
        school.getCourses().remove(course);
        // Kursu veritabanından sil
        courseRepository.deleteById(courseId);
        // Okulu güncelle
        schoolRepository.save(school);
    }

    //Okul silme
    public void delete(Long id){
        schoolRepository.deleteById(id);
    }

}
