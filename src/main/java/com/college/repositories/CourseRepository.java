package com.college.repositories;


/*
  CourseRepository interface for better scalability and by using JpaRepository
  it auto creates some finder methods.
 */
import com.college.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
