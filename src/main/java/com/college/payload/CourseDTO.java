package com.college.payload;

import com.college.model.College;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseDTO {
    private Integer courseID;
    private String courseName;
    private Integer courseFee;
    private Integer duration;

}
