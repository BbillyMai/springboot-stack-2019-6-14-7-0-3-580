package com.tw.apistackbase.Service;

import com.tw.apistackbase.Resposity.EmployeesRepository;
import com.tw.apistackbase.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeesRepository employeesRepositoryImpl;

    public List<Employee> findAll() {
        return employeesRepositoryImpl.findAll();
    }

    public Employee findById(String employeeId) {
        return employeesRepositoryImpl.findById(employeeId);
    }

    public Employee add(Employee employee) {
        return employeesRepositoryImpl.add(employee);
    }

    public Employee updateById(String employeeId, Employee employee) {
        return employeesRepositoryImpl.updateById(employeeId, employee);
    }

    public Employee deleteById(String employeeId) {
        return employeesRepositoryImpl.deleteById(employeeId);
    }

    public List<Employee> findByAge(int age) {
        return employeesRepositoryImpl.findByAge(age);
    }
}
