package com.college.repositories;

/*
  CollegeRepository interface for better scalability and by using JpaRepository
  it auto creates some finder methods.
 */

import com.college.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CollegeRepository extends JpaRepository<College,Integer> {

}
