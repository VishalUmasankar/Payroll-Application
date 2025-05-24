package com.example.empay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class empco {

    @Autowired
    empser service;

    @GetMapping("/data")
    public List<empdata>  info() {
        return service.empinfo();
    }

    @GetMapping("/data/{id}")
    public String infoid(@PathVariable int id) {
        return service.empid(id);
    }

    @PostMapping("/data")
    public void addid(@RequestBody empdata newid) {
        service.addid(newid);
        
    }

    @PutMapping("/data/{id}")
    public String updateid(@PathVariable int id, @RequestBody empdata upid) {
        service.updatid(id, upid);
        return "Employee with ID " + id + " updated.";
    }

    @DeleteMapping("/data/{id}")
    public String deleteid(@PathVariable int id) {
        service.deleteid(id);
        return "Employee with ID " + id + " deleted.";
    }
}
