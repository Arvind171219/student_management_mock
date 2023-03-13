package com.example.API_FOR_MANAGING_RESULT.RequestDto;

import com.example.API_FOR_MANAGING_RESULT.ENUMS.BranchName;
import lombok.Data;


@Data
public class CollegeStudentRequestDto
{
      String rollNo;
      String  name;
      int marks;
      int branch_id;
}
