package com.college.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CollegeDTO {

    private Integer collegeID;
    private String collegeName;
    private String accommodation;
    private Integer accomodationFee;
     private CourseDTO courseDTO;
}
