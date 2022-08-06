package com.dk.controller;

import com.dk.model.Employee;
import com.dk.repo.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
