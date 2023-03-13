package com.example.API_FOR_MANAGING_RESULT.Models;

import com.example.API_FOR_MANAGING_RESULT.ENUMS.BranchName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "college_student")
public class CollegeStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "rollNo", unique = true)
    private String rollNo;

    @Enumerated(EnumType.STRING)
    private BranchName branchName;

    private int marks;

    @ManyToOne
    @JoinColumn
    private Branch branch;

}
