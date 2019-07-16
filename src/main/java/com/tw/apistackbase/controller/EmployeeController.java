package com.tw.apistackbase.controller;

import com.tw.apistackbase.Resposity.EmployeesRepository;
import com.tw.apistackbase.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeesRepository employeesRepository;

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeesRepository.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable String employeeId){
        return employeesRepository.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee add(@RequestBody Employee employee){
        return employeesRepository.add(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateById(@PathVariable String employeeId,@RequestBody Employee employee){
        return employeesRepository.updateById(employeeId,employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public Employee deleteById(@PathVariable String employeeId){
        return employeesRepository.deleteById(employeeId);
    }

    @GetMapping("/employees/age/{age}")
    public List<Employee> findByAge(@PathVariable int age){
        return employeesRepository.findByAge(age);
    }

    @GetMapping(value = "/employees",params = "ageMini")
    public List<Employee> findAgeAbove(@RequestParam int ageMini){
        return employeesRepository.findByAge(ageMini);
    }

}
