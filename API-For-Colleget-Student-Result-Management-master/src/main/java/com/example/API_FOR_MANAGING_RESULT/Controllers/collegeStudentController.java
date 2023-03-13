package com.example.API_FOR_MANAGING_RESULT.Controllers;

import com.example.API_FOR_MANAGING_RESULT.Repositories.CollegeStudentRepository;
import com.example.API_FOR_MANAGING_RESULT.RequestDto.CollegeStudentRequestDto;
import com.example.API_FOR_MANAGING_RESULT.Services.CollegeStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.DecimalMin;
import java.util.List;
@RestController
@RequestMapping("/collegeStudent")
public class collegeStudentController {
    @Autowired
    private CollegeStudentService collegeStudentService;

    @PostMapping("/add_Student")
    public String addCollegeStudent(@RequestBody()CollegeStudentRequestDto collegeStudentRequestDto)
    {
        collegeStudentService.addCollegeStudents(collegeStudentRequestDto);
        return "Successfully Added";
    }

    @GetMapping("/recent_branch_roll_numbers")
    public ResponseEntity<List<String>> getRollNumbersOfStudentsInMostRecentBranch() {
        List<String> rollNumbers = collegeStudentService.findRollNumbersOfMostRecentBranch();
        return ResponseEntity.ok(rollNumbers);
    }

}
