package com.example.API_FOR_MANAGING_RESULT.RequestDto;

import com.example.API_FOR_MANAGING_RESULT.ENUMS.BranchName;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Data
public class BranchRequestDto {

   @Enumerated(EnumType.STRING)
   private BranchName branchName;

   private String  hodName;

   private String contactNo;

   private int grantFund;
}
