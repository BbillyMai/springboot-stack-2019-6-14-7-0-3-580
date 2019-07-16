package com.tw.apistackbase.controller;

import com.tw.apistackbase.Resposity.EmployeesResposity;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return EmployeesResposity.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable String employeeId){
        return EmployeesResposity.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee add(@RequestBody Employee employee){
        return EmployeesResposity.add(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateById(@PathVariable String employeeId,@RequestBody Employee employee){
        return EmployeesResposity.updateById(employeeId,employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public Employee deleteById(@PathVariable String employeeId){
        return EmployeesResposity.deleteById(employeeId);
    }

    @GetMapping("/employees/age/{age}")
    public List<Employee> findByAge(@PathVariable int age){
        return EmployeesResposity.findByAge(age);
    }

    @GetMapping(value = "/employees",params = "ageMini")
    public List<Employee> findAgeAbove(@RequestParam int ageMini){
        return EmployeesResposity.findByAge(ageMini);
    }

}
