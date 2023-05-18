package com.college.services.implimentation;

import com.college.model.Course;
import com.college.payload.CollegeDTO;
import com.college.payload.CourseDTO;
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

    @Override
    public CourseDTO addNewCourse(CourseDTO courseDTO) {
        Course course = courseRepo.save(dto_to_Course(courseDTO));
        return course_to_DTO(course);
    }

    @Override
    public CourseDTO getCourseDetailById(Integer courseId) throws Exception {
        Course course = courseRepo.findById(courseId).orElseThrow(()-> new Exception("Course for given id is not found"));
        return course_to_DTO(course);
    }

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
