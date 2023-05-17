package com.college.services.implimentation;

import com.college.model.College;
import com.college.payload.CollegeDTO;
import com.college.repositories.CollegeRepository;
import com.college.services.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

      @Autowired
      private ModelMapper modelMapper;
      @Autowired
      private CollegeRepository collegeRepo;

    @Override
    public CollegeDTO addNewCollege(CollegeDTO collegeDTO) {
        College college = Dto_to_College(collegeDTO);
        College newcollge = collegeRepo.save(college);
        return college_to_Dto(newcollge);
    }

    @Override
    public CollegeDTO getCollgeDetailsById(Integer collegeID) throws Exception {
         College college =this.collegeRepo.findById(collegeID).orElseThrow( ()-> new Exception() );
        return college_to_Dto(college);
    }

    @Override
    public List<CollegeDTO> getAllCollegeDetails() {

        return null;
    }


    //Method for convert college class object to collegeDTO class object
    public CollegeDTO college_to_Dto (College college){
        CollegeDTO collegeDTO = this.modelMapper.map(college,CollegeDTO.class);
        return collegeDTO;
    }

    //Method for convert collegeDTO.class object to college.class object
    public College Dto_to_College (CollegeDTO collegeDTO){
        College college = this.modelMapper.map(collegeDTO,College.class);
        return college;
    }


}
