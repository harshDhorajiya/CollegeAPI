package com.college.controller;

import com.college.payload.CourseDTO;
import com.college.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

      @Autowired
     private CourseService courseService;

    /*
     AddCourse() controller for getting responce from web and creates new course related to any college.
     */
    @PostMapping("/add/{collegeid}")
    public ResponseEntity<CourseDTO> AddCourse (@RequestBody CourseDTO courseDTO ,@PathVariable Integer collegeid ) throws Exception {
        CourseDTO newCourse = courseService.addNewCourse(courseDTO,collegeid);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    /*
     getCourseById() controller for give responce of requested course-id.
   */
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDTO> getCourseById (@PathVariable Integer courseId) throws Exception {
        return ResponseEntity.ok(courseService.getCourseDetailById(courseId));
    }

    /*
     getAllCourse() controller for giving responce as all course details.
    */
    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourse (){
        return ResponseEntity.ok(courseService.getAllCourseDetail());
    }
}
