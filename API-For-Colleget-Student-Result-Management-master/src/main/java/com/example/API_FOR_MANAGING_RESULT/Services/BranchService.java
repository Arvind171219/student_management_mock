package com.example.API_FOR_MANAGING_RESULT.Services;

import com.example.API_FOR_MANAGING_RESULT.Models.Branch;

import com.example.API_FOR_MANAGING_RESULT.Models.CollegeStudent;

import com.example.API_FOR_MANAGING_RESULT.Repositories.BranchRepository;
import com.example.API_FOR_MANAGING_RESULT.Repositories.CollegeStudentRepository;

import com.example.API_FOR_MANAGING_RESULT.RequestDto.BranchRequestDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BranchService {



    @Autowired
    private  CollegeStudentRepository collegeStudentRepository;

    @Autowired
    private  BranchRepository branchRepository;





    // ADD BRANCH API Implementation
    public void addBranch(BranchRequestDto branchRequestDto) {

        Branch branch = Branch.builder().branchName(branchRequestDto.getBranchName())
                .hodName(branchRequestDto.getHodName())
                .contactNo(branchRequestDto.getContactNo())
                .grants(branchRequestDto.getGrantFund()).build();

        branchRepository.save(branch);
    }




    // API - 1 Implementation getting HOD contact number


    public List<String> findContactNoOfHODWithMaxPassingStudents() {

        List<Branch> allBranchList = branchRepository.findAll();

        int PassStudentCount = Integer.MIN_VALUE;
        int id=0;
        for(Branch branch : allBranchList )
        {
            List<CollegeStudent> collegeStudentList =branch.getCollegeStudentList();

            int count =0;  // count Number student whom mark >=40

            for(CollegeStudent collegeStudent : collegeStudentList)
            {
                if(collegeStudent.getMarks()>=40)   count++;
            }

            if(count >=PassStudentCount)
            {
                PassStudentCount = count;
                id = branch.getId();
            }
        }

       //this is the branch which contains Most Passed Student
        Branch requiredBranch= branchRepository.findById(id).get();

        List<String> contactNoList = new ArrayList<>();

        // adding the HOD contact No of required Branch
        contactNoList.add(requiredBranch.getContactNo());

        return contactNoList;
    }





    // API - 3 Implementation for Getting Brant Associated with Required Branch


    public Integer findGrantGivenToDepartmentWithMaxPassingStudents() {


        List<Branch> allBranchList = branchRepository.findAll();

        int PassStudentCount = Integer.MIN_VALUE;
        int id=0;
        for(Branch branch : allBranchList )
        {
            List<CollegeStudent> collegeStudentList =branch.getCollegeStudentList();

            int count =0;  // count Number student whom mark >=40

            for(CollegeStudent collegeStudent : collegeStudentList)
            {
                if(collegeStudent.getMarks()>=40)   count++;
            }

            if(count >=PassStudentCount)
            {
                PassStudentCount = count;
                id = branch.getId();
            }
        }

        //this is the branch which contains Most Passed Student
        Branch requiredBranch = branchRepository.findById(id).get();


        // return the Grant of that Branch
        return requiredBranch.getGrants();
    }

}
