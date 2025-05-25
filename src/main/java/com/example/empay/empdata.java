/** empdata.java */
package com.example.empay; // Changed package to com.example.empay

import java.time.LocalDate;
import java.util.List;

import com.example.empay.EmpDTO;
import lombok.Data;      

public @Data class empdata {

    private int employeeId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
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
}