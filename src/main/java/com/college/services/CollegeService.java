package com.college.services;


import com.college.payload.CollegeDTO;

import java.util.List;

public interface CollegeService {

    CollegeDTO addNewCollege(CollegeDTO collegeDTO);
    CollegeDTO getCollgeDetailsById(Integer collegeID) throws Exception;
    List<CollegeDTO> getAllCollegeDetails();
    CollegeDTO addCoursetoCollege (Integer courseID,Integer collegeID) throws Exception;
}
