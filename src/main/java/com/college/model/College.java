package com.college.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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


<<<<<<< HEAD
=======


>>>>>>> origin/main
}
