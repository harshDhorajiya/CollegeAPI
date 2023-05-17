package com.college.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "College-ID")
    private Integer collegeID;
    @Column(name = "College-Name")
    private String collegeName;
    @Column(name = "Accommodation-Type")
    private String accommodation;
    @Column(name = "Accommodation-Fee")
    private Integer accomodationFee;

    @ManyToMany
    @JoinColumn(name = "course_id")
    private List <Course> courses = new ArrayList<>();

}
