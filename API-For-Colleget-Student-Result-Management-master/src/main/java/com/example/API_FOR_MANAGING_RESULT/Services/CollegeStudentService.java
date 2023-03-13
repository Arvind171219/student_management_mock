package com.example.API_FOR_MANAGING_RESULT.Services;

import com.example.API_FOR_MANAGING_RESULT.Models.Branch;
import com.example.API_FOR_MANAGING_RESULT.Models.CollegeStudent;
import com.example.API_FOR_MANAGING_RESULT.Repositories.BranchRepository;
import com.example.API_FOR_MANAGING_RESULT.Repositories.CollegeStudentRepository;
import com.example.API_FOR_MANAGING_RESULT.RequestDto.CollegeStudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollegeStudentService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private CollegeStudentRepository collegeStudentRepository;



    // Add Student in Their Respective Branch


    public void addCollegeStudents(CollegeStudentRequestDto collegeStudentRequestDto) {

        Branch branch =branchRepository.findById(collegeStudentRequestDto.getBranch_id()).get();
        CollegeStudent collegeStudent = CollegeStudent.builder().name(collegeStudentRequestDto.getName())
                                                              .rollNo(collegeStudentRequestDto.getRollNo())
                                                            .branchName(branch.getBranchName())
                                                          .marks(collegeStudentRequestDto.getMarks()).build();

        collegeStudent.setBranch(branch);

        branch.getCollegeStudentList().add(collegeStudent);

        collegeStudentRepository.save(collegeStudent);

        branchRepository.save(branch);

       // just checking the size of  student list
        System.out.println( "StudentList  "+ branch.getCollegeStudentList().size());
    }




    // API - 2   List of Student Roll No. of recent Branch


    public List<String> findRollNumbersOfMostRecentBranch() {

        Map<Integer, Integer> yearByBranch = new HashMap<>();
        yearByBranch.put(1, 2022); // id 1 for CSE
        yearByBranch.put(2, 2021); // id 2 for IT
        yearByBranch.put(3, 2020); // id 3 for EE
        yearByBranch.put(4, 2019); // id 4 for ME
        yearByBranch.put(5, 2018); // id 5 for BT

        //finding recent Batch  Year which was Recently Added
        int max =0;

        Branch branch =null;

        for(int id : yearByBranch.keySet())
        {
            if(yearByBranch.get(id)>max)
            {
                max = yearByBranch.get(id);
                branch = branchRepository.findById(id).get();
            }
        }


        //Contains List of RollNumbers of Recent Branch Students
        List<String> rollNoList = new ArrayList<>();

        assert branch != null;
        for(CollegeStudent collegeStudent : branch.getCollegeStudentList())
        {
            rollNoList.add(collegeStudent.getRollNo());
        }

        //return the final list of Student Roll Numbers
        return  rollNoList;
    }

}
