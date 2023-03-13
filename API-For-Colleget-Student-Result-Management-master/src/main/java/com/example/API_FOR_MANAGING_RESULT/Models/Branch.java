package com.example.API_FOR_MANAGING_RESULT.Models;



import com.example.API_FOR_MANAGING_RESULT.ENUMS.BranchName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "branch_Name")
    @Enumerated(EnumType.STRING)
    private BranchName branchName;

    private String contactNo;

    @Column(name = "grants")
    private int  grants;

    private String hodName;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<CollegeStudent> collegeStudentList =new ArrayList<>();

}