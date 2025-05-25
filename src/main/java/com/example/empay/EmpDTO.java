package com.example.empay;

import java.time.LocalDate; // <-- ADDED THIS IMPORT for LocalDate
import java.util.List;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;

@ToString
public class EmpDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",
             message = "Employee name Invalid")
    public String name;

    @Min(value = 500,
         message = "Min Wage should be more than 500")
    public long salary;

    public String gender;

    public LocalDate startDate; 

    public String note;

    public String profilePic;

    public List<String> department;
}