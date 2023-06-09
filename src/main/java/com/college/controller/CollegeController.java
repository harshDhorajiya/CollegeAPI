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

    /*
     AddCollege() controller for getting responce from web and creates new college.
     */
    @PostMapping("/add")
    public ResponseEntity<CollegeDTO> AddCollege (@RequestBody CollegeDTO collegeDTO){
        CollegeDTO newCollege = this.collegeService.addNewCollege(collegeDTO);
       return new ResponseEntity<>(newCollege, HttpStatus.CREATED);
    }

    /*
    getCollegeById() controller for give responce of requested college-id.
     */
    @GetMapping ("/{collegeid}")
    public ResponseEntity<CollegeDTO> getCollegeById (@PathVariable Integer collegeid) throws Exception {
        return ResponseEntity.ok(collegeService.getCollgeDetailsById(collegeid));
    }

    /*
    getAllCollege() controller for giving responce as all college details along with courses.
     */
    @GetMapping("/")
    public ResponseEntity<List<CollegeDTO>> getAllCollege () {
        return ResponseEntity.ok( collegeService.getAllCollegeDetails());
    }

}
