package com.example.API_FOR_MANAGING_RESULT.Repositories;

import com.example.API_FOR_MANAGING_RESULT.ENUMS.BranchName;
import com.example.API_FOR_MANAGING_RESULT.Models.CollegeStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollegeStudentRepository extends JpaRepository<CollegeStudent, Integer> {

    List<CollegeStudent> findByBranchAndMarksGreaterThanEqual(Integer id, Integer marks);

}
