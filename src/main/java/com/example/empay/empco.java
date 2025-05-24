package com.example.empay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class empco {

    @Autowired
    private empser service;

    @GetMapping("/data")
    public List<empdata> info() {
        return service.getAllEmployees();
    }

    @GetMapping("/data/get/{id}")
    public String infoid(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @PostMapping("/data/create")
    public String addid(@RequestBody EmpDTO dto) {
        return service.addEmployee(dto);
    }

    @PutMapping("/data/update/{id}")
    public String updateid(@PathVariable int id, @RequestBody EmpDTO dto) {
        return service.updateEmployee(id, dto);
    }

    @DeleteMapping("/data/delete/{id}")
    public String deleteid(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
}
