package com.example.empay;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class empser {

    private List<empdata> employeeList = new ArrayList<>();
    private int nextId = 1;

    public List<empdata> getAllEmployees() {
        return employeeList;
    }

    public String getEmployeeById(int id) {
        for (empdata emp : employeeList) {
            if (emp.getId() == id) {
                return emp.toString();
            }
        }
        return "Employee not found!";
    }

    public String addEmployee(EmpDTO dto) {
        empdata emp = new empdata(nextId++, dto.getName(), dto.getSal());
        employeeList.add(emp);
        return "Employee added: " + emp.toString();
    }

    public String updateEmployee(int id, EmpDTO dto) {
        for (empdata emp : employeeList) {
            if (emp.getId() == id) {
                emp.setName(dto.getName());
                emp.setSal(dto.getSal());
                return "Employee updated: " + emp.toString();
            }
        }
        return "Employee not found!";
    }

    public String deleteEmployee(int id) {
        for (empdata emp : employeeList) {
            if (emp.getId() == id) {
                employeeList.remove(emp);
                return "Employee deleted with ID: " + id;
            }
        }
        return "Employee not found!";
    }
}
