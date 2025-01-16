package com.mantis.schoolRegistrationSystem.service;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateCourseRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.CourseResponse;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.StudentResponse;
import com.mantis.schoolRegistrationSystem.entity.Course;
import com.mantis.schoolRegistrationSystem.entity.Student;
import com.mantis.schoolRegistrationSystem.entity.Teacher;
import com.mantis.schoolRegistrationSystem.mapper.CourseMapper;
import com.mantis.schoolRegistrationSystem.mapper.StudentMapper;
import com.mantis.schoolRegistrationSystem.repository.CourseRepository;

import com.mantis.schoolRegistrationSystem.repository.StudentRepository;
import com.mantis.schoolRegistrationSystem.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final TeacherRepository teacherRepository;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper, StudentRepository studentRepository, StudentMapper studentMapper, TeacherRepository teacherRepository){
        this.courseMapper = courseMapper;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.teacherRepository = teacherRepository;
    }
    // Yeni kurs oluşturma
    public CourseResponse create(CreateCourseRequest request){
        Course course = courseMapper.toEntity(request);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toResponse(savedCourse);
    }

    //ID'ye göre kurs getirme
    public CourseResponse getById(Long id){
        //TODO = throw exception
        Course course = courseRepository.findById(id).orElseThrow();
        return courseMapper.toResponse(course);
    }
    // Tüm kursları getirme
    public List<CourseResponse> getAll(){
        return courseRepository.findAll().stream().
                map(courseMapper::toResponse).
                collect(Collectors.toList());
    }
    //Kurs güncelleme
    public CourseResponse update(Long id, CreateCourseRequest request){
        //TODO = throw exception
        Course existCourse = courseRepository.findById(id).orElseThrow();
        Course secondCourse = courseMapper.toEntity(request);
        secondCourse.setId(existCourse.getId());
        courseRepository.save(secondCourse);
        return courseMapper.toResponse(secondCourse);
    }

    // Kursa öğrenci ekleme metodu
    public void addStudent(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        Student student = studentRepository.findById(studentId).orElseThrow();

        course.getStudents().add(student);
        courseRepository.save(course);
    }

    // Kurstan öğrenci çıkarma metodu
    public void removeStudent(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        course.getStudents().removeIf(student -> student.getId().equals(studentId));
        courseRepository.save(course);
    }

    // Kursun öğrencilerini getirme metodu
    public List<StudentResponse> getCourseStudents(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        return course.getStudents().stream()
                .map(studentMapper::toResponse)
                .collect(Collectors.toList());
    }

    // Kursa öğretmen atama metodu
    public void assignTeacher(Long courseId, Long teacherId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow();

        // Öğretmeni kursa ata
        course.setTeacher(teacher);
        courseRepository.save(course);
    }


    //Kursu silme
    public void delete(Long id){
        courseRepository.deleteById(id);
    }
}
