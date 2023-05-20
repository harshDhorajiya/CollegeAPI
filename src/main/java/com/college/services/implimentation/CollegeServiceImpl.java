package com.college.services.implimentation;

import com.college.model.College;
import com.college.model.Course;
import com.college.payload.CollegeDTO;
import com.college.payload.CourseDTO;
import com.college.repositories.CollegeRepository;
import com.college.services.CollegeService;
import com.college.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollegeServiceImpl implements CollegeService {

      @Autowired
      private ModelMapper modelMapper;
      @Autowired
      private CollegeRepository collegeRepo;
      @Autowired
      private CourseService courseService;


    @Override
    public CollegeDTO addNewCollege(CollegeDTO collegeDTO) {
        College college = Dto_to_College(collegeDTO);
        College newcollge = collegeRepo.save(college);
        return college_to_Dto(newcollge);
    }

    @Override
    public CollegeDTO getCollgeDetailsById(Integer collegeID) throws Exception {
         College college =this.collegeRepo.findById(collegeID).orElseThrow( ()-> new Exception("College not found on given id") );
        return college_to_Dto(college);
    }

    @Override
    public List<CollegeDTO> getAllCollegeDetails() {
        List<College> collegeList = this.collegeRepo.findAll();
        List<CollegeDTO> collegeDTOS =  collegeList.stream().map(college -> college_to_Dto(college)).collect(Collectors.toList());
        return collegeDTOS;
    }




    //Method for convert College.class object to CollegeDTO.class object
    public CollegeDTO college_to_Dto (College college){
        CollegeDTO collegeDTO = this.modelMapper.map(college,CollegeDTO.class);
        return collegeDTO;
    }

    //Method for convert CollegeDTO.class object to College.class object
    public College Dto_to_College (CollegeDTO collegeDTO){
        College college = this.modelMapper.map(collegeDTO,College.class);
        return college;
    }
}
