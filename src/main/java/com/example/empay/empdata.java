package com.example.empay;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.CollectionTable; 
import jakarta.persistence.Column;          
import jakarta.persistence.ElementCollection; 
import jakarta.persistence.Entity;         
import jakarta.persistence.GeneratedValue;   
import jakarta.persistence.GenerationType;    
import jakarta.persistence.Id;             
import jakarta.persistence.JoinColumn;     
import jakarta.persistence.Table;           

import lombok.Data;

@Entity
@Table(name = "employee_payroll")
public @Data class empdata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private long salary;

    @Column(name = "gender")
    private String gender;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "note")
    private String note;

    @Column(name = "profile_pic")
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;

    public empdata() { }

    public empdata(int empId, EmpDTO empPayrollDTO) {
        this.employeeId = empId;
        this.name = empPayrollDTO.name;
        this.salary = empPayrollDTO.salary;
        this.gender = empPayrollDTO.gender;
        this.note = empPayrollDTO.note;
        this.startDate = empPayrollDTO.startDate;
        this.profilePic = empPayrollDTO.profilePic;
        this.departments = empPayrollDTO.department;
    }

    public empdata(EmpDTO empPayrollDTO) {
        this.name = empPayrollDTO.name;
        this.salary = empPayrollDTO.salary;
        this.gender = empPayrollDTO.gender;
        this.note = empPayrollDTO.note;
        this.startDate = empPayrollDTO.startDate;
        this.profilePic = empPayrollDTO.profilePic;
        this.departments = empPayrollDTO.department;
    }
}