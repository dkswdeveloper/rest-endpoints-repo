package com.dk.controller;

import com.dk.model.Employee;
import com.dk.repo.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeRespository empRepo;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getAll()
    {
        return empRepo.findAll();
    }

    @GetMapping(value = "/employees/{id}", produces = "application/json")
    public Employee getEmployee(@PathVariable("id") int id)
    {
        Optional<Employee> optEmp = empRepo.findById(id);
        return optEmp.orElse(new Employee(0, "no such employee "));
    }

}
