package com.example.API_FOR_MANAGING_RESULT.Repositories;

import com.example.API_FOR_MANAGING_RESULT.ENUMS.BranchName;
import com.example.API_FOR_MANAGING_RESULT.Models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

        Branch findByBranchName(String branchName);

        }

