package com.college.services;

import com.college.payload.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO addNewCourse(CourseDTO courseDTO);
    CourseDTO getCourseDetailById(Integer courseId);
    List<CourseDTO> getAllCourseDetail();
}
