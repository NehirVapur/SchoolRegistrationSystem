package com.mantis.schoolRegistrationSystem.mapper;

import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateCourseRequest;
import com.mantis.schoolRegistrationSystem.dto.RequestDTOs.CreateSchoolRequest;
import com.mantis.schoolRegistrationSystem.dto.ResponseDTOs.CourseResponse;
import com.mantis.schoolRegistrationSystem.entity.Course;
import com.mantis.schoolRegistrationSystem.entity.School;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public CourseMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    // CreateCourseRequest -> Course
    public Course toEntity(CreateCourseRequest request){
        School school = new School();
        school.setId(request.getSchoolId());

        Course course = modelMapper.map(request, Course.class);
        course.setSchool(school);
        return course;
    }

    //Course -> CourseResponse
    public CourseResponse toResponse(Course course){
        CourseResponse response = modelMapper.map(course, CourseResponse.class);
        return response;
    }

}
