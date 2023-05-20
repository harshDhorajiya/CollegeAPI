package com.college.services;

import com.college.model.Course;
import com.college.payload.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO addNewCourse(CourseDTO courseDTO,Integer collegeId) throws Exception;
    CourseDTO getCourseDetailById(Integer courseId) throws Exception;
    List<CourseDTO> getAllCourseDetail();

    CourseDTO course_to_DTO (Course course);

    Course dto_to_Course (CourseDTO courseDTO);
}
