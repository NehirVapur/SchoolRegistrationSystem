package com.mantis.schoolRegistrationSystem.repository;

import com.mantis.schoolRegistrationSystem.entity.Student;
import com.mantis.schoolRegistrationSystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail (String email);
    Optional<Student> findBySchoolNumber(String schoolNumber);
    List<Student> findByCourseId(Long courseId);
    List<Student> findByManagerId (Long managerId);
}
