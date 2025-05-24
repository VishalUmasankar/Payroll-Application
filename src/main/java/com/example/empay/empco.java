package com.example.empay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class empco {

    @Autowired
    empser service;

    @GetMapping("/data")
    public List<empdata> info() {
        return service.empinfo();
    }

    @GetMapping("/data/get/{id}")
    public String infoid(@PathVariable int id) {
        return service.empid(id);
    }

    @PostMapping("/data/create")
    public void addid(@RequestBody EmpDTO newid) {
        service.addid(newid);
    }

    @PutMapping("/data/update/{id}")
    public String updateid(@PathVariable int id, @RequestBody EmpDTO upid) {
        service.updatid(id, upid);
        return "Employee with ID " + id + " updated.";
    }

 
    @DeleteMapping("/data/delete/{id}")
    public String deleteid(@PathVariable int id) {
        service.deleteid(id);
        return "Employee with ID " + id + " deleted.";
    }
}
