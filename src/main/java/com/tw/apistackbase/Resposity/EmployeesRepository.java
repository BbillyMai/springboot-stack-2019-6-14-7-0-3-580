package com.tw.apistackbase.Resposity;

import com.tw.apistackbase.model.Employee;

import java.util.List;

public interface EmployeesRepository {
    List<Employee> findAll();

    Employee findById(String employeeId);

    Employee add(Employee employee);

    Employee updateById(String employeeId, Employee employee);

    Employee deleteById(String employeeId);

    List<Employee> findByAge(int age);
}
