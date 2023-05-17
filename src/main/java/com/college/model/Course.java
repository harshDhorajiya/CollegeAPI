package com.college.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Course-ID")
    private Integer courseID;
    @Column(name = "Course-Name")
    private String courseName;
    @Column(name = "Course-Fee")
    private Integer courseFee;

}
