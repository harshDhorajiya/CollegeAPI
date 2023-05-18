package com.college.controller;

import com.college.payload.CollegeDTO;
import com.college.services.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @PostMapping("/add")
    public ResponseEntity<CollegeDTO> AddCollege (@RequestBody CollegeDTO collegeDTO){
        CollegeDTO newCollege = this.collegeService.addNewCollege(collegeDTO);
       return new ResponseEntity<>(newCollege, HttpStatus.CREATED);
    }

    @GetMapping ("/{collegeid}")
    public ResponseEntity<CollegeDTO> getCollegeById (@PathVariable Integer collegeid) throws Exception {
        return ResponseEntity.ok(collegeService.getCollgeDetailsById(collegeid));
    }

    @GetMapping
    public ResponseEntity<List<CollegeDTO>> getAllCollege () {
        return ResponseEntity.ok( collegeService.getAllCollegeDetails());
    }

    @PutMapping("/add/course/{courseId}/{collegeId}")
    public ResponseEntity<CollegeDTO> addCourseToCollege(@PathVariable Integer courseId ,@PathVariable Integer collegeId) throws Exception {
        return ResponseEntity.ok(collegeService.addCoursetoCollege(courseId,collegeId));
    }
}
