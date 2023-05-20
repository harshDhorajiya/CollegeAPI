package com.college.repositories;

import com.college.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CollegeRepository extends JpaRepository<College,Integer> {

}
