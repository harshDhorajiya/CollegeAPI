package com.college.payload;

import com.college.model.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CollegeDTO {

    private Integer collegeID;
    private String collegeName;
    private String accommodation;
    private Integer accomodationFee;

    private List<Course> courses;

}
