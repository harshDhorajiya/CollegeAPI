package com.college.services.implimentation;

import com.college.model.College;
import com.college.model.Course;
import com.college.payload.CollegeDTO;
import com.college.payload.CourseDTO;
import com.college.repositories.CollegeRepository;
import com.college.repositories.CourseRepository;
import com.college.services.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private CollegeRepository collegeRepo;

    /*
     Here is service addNewCourse() that defines addition of new Course to their related College.
     */
    @Override
    public CourseDTO addNewCourse(CourseDTO courseDTO,Integer collegeId) throws Exception {
        College college = collegeRepo.findById(collegeId).orElseThrow(()-> new Exception("College not found with given College-Id"));
        Course course = (dto_to_Course(courseDTO));
        course.setCollege(college);
        courseRepo.save(course);
        return course_to_DTO(course);
    }

    /*
    Here is service getCourseDetailById() that defines responce for particulate
    requested id of Course.

     */
    @Override
    public CourseDTO getCourseDetailById(Integer courseId) throws Exception {
        Course course = courseRepo.findById(courseId).orElseThrow(()-> new Exception("Course for given id is not found"));
        return course_to_DTO(course);
    }

    /*
    Here is service getAllCourseDetail() that defines responce as all Course which is stored in database.
     */

    @Override
    public List<CourseDTO> getAllCourseDetail() {
        List<Course> courses = courseRepo.findAll();
        List<CourseDTO> collegeDTOS =  courses.stream().map( course -> course_to_DTO(course)).collect(Collectors.toList());
        return collegeDTOS;
    }


    //Method for convert Course.class object to CourseDTO.class object
    public CourseDTO course_to_DTO (Course course){
     CourseDTO courseDTO = modelMapper.map(course,CourseDTO.class);
     return courseDTO;
   }

    //Method for convert CourseDTO.class object to Course.class object
    public Course dto_to_Course (CourseDTO courseDTO){
        Course course = modelMapper.map(courseDTO,Course.class);
        return course;
    }

}
