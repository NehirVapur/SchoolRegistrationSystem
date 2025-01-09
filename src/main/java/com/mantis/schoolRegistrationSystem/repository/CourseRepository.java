package com.mantis.schoolRegistrationSystem.repository;

import com.mantis.schoolRegistrationSystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findBySchoolId(Long schoolId);
    List<Course> findByTeacherId(Long teacherId);
    List<Course> findByName(String name);
}
