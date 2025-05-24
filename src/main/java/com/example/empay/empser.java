package com.example.empay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class empser {

    @Autowired
    private EmpRepository repository; 

    public List<empdata> empinfo() {
        return repository.findAll();  
    }

    public String empid(int id) {
        Optional<empdata> data = repository.findById(id); 
        if (data.isPresent()) {
            empdata emp = data.get();
            return emp.getId() + " " + emp.getName() + " " + emp.getSal();
        }
        return "Employee not found!";
    }

    public void addid(empdata newid) {
        repository.save(newid);  
    }

    public void updatid(int id, empdata upid) {
        Optional<empdata> existingEmp = repository.findById(id);  
        if (existingEmp.isPresent()) {
            empdata emp = existingEmp.get();
            emp.setName(upid.getName());
            emp.setSal(upid.getSal());
            repository.save(emp);  
        }
    }

    public void deleteid(int id) {
        repository.deleteById(id); 
    }
}
