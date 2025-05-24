package com.example.empay;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class empco {

    private List<empdata> employeeList = new ArrayList<>();
    private int nextId = 1;

    @GetMapping("/data")
    public List<empdata> info() {
        return employeeList;
    }

    @GetMapping("/data/get/{id}")
    public String infoid(@PathVariable int id) {
        for (empdata emp : employeeList) {
            if (emp.getId() == id) {
                return emp.toString();
            }
        }
        return "Employee not found!";
    }

    @PostMapping("/data/create")
    public String addid(@RequestBody EmpDTO dto) {
        empdata emp = new empdata(nextId++, dto.getName(), dto.getSal());
        employeeList.add(emp);
        return "Employee added: " + emp.toString();
    }

    @PutMapping("/data/update/{id}")
    public String updateid(@PathVariable int id, @RequestBody EmpDTO dto) {
        for (empdata emp : employeeList) {
            if (emp.getId() == id) {
                emp.setName(dto.getName());
                emp.setSal(dto.getSal());
                return "Employee updated: " + emp.toString();
            }
        }
        return "Employee not found!";
    }

    @DeleteMapping("/data/delete/{id}")
    public String deleteid(@PathVariable int id) {
        for (empdata emp : employeeList) {
            if (emp.getId() == id) {
                employeeList.remove(emp);
                return "Employee deleted with ID: " + id;
            }
        }
        return "Employee not found!";
    }
}
