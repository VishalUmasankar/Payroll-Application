package com.example.empay;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank; 
import jakarta.validation.constraints.NotNull; 
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern; 

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString; 

@ToString
public class EmpDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",
             message = "Employee name Invalid")
    public String name;

    @Min(value = 500,
         message = "Min Wage should be more than 500")
    public long salary;

    @Pattern(regexp = "male|female", 
             message = "Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy") 
    @NotNull(message = "startDate should Not Be Empty") 
    @PastOrPresent(message = "startDate should be past or todays date") 
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be Empty") 
    public String note;

    @NotBlank(message = "profilePic cannot be Empty") 
    public String profilePic;

    @NotNull(message = "department should Not Be Empty") 
    public List<String> department;
}