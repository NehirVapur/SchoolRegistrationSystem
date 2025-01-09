package com.mantis.schoolRegistrationSystem.repository;

import com.mantis.schoolRegistrationSystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByEmail (String email);
    List<Teacher> findByNameAndSurname(String name, String surname);
}
