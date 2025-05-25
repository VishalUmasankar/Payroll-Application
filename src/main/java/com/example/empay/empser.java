package com.example.empay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Manual SLF4J logger imports (if @Slf4j is not working)
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
// Removed @Slf4j here, as we are using manual logger declaration
public class empser {

    // Manual SLF4J logger declaration
    private static final Logger log = LoggerFactory.getLogger(empser.class);

    @Autowired
    private EmpRepository repository;

    // Retrieve all employee data
    public List<empdata> empinfo() {
        log.info("Fetching all employee payroll data.");
        return repository.findAll();
    }

    // Retrieve employee by ID
    public empdata empid(int id) {
        log.info("Fetching employee with ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new EmployeePayrollException("Employee with ID " + id + " not found!"));
    }

    // Add a new employee
    public empdata addid(EmpDTO dto) {
        log.info("Adding new employee: {}", dto);
        empdata emp = new empdata(dto); // Use the constructor that takes EmpDTO
        return repository.save(emp);
    }

    // Update an existing employee
    public empdata updatid(int id, EmpDTO dto) {
        log.info("Updating employee with ID: {} and data: {}", id, dto);
        empdata existingEmp = repository.findById(id)
                .orElseThrow(() -> new EmployeePayrollException("Employee with ID " + id + " not found for update!"));

        existingEmp.setName(dto.name);
        existingEmp.setSalary(dto.salary);
        existingEmp.setGender(dto.gender);
        existingEmp.setStartDate(dto.startDate);
        existingEmp.setNote(dto.note);
        existingEmp.setProfilePic(dto.profilePic);
        existingEmp.setDepartments(dto.department); 

        return repository.save(existingEmp);
    }

    // Delete an employee by ID
    public void deleteid(int id) {
        log.info("Deleting employee with ID: {}", id);
        empdata empToDelete = repository.findById(id)
                .orElseThrow(() -> new EmployeePayrollException("Employee with ID " + id + " not found for deletion!"));
        repository.delete(empToDelete);
    }
}