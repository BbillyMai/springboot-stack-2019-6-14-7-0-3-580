package com.tw.apistackbase.Resposity;

import com.tw.apistackbase.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeesResposity {

    private static Map<String, Employee> employees = new HashMap<>();

    static {
        Employee employee1 = createEmployee("xiaoming", 17, "male");
        Employee employee2 = createEmployee("xiaohong", 19, "female");
        Employee employee3 = createEmployee("xiaowang", 15, "male");
        employees.put(employee1.getId(), employee1);
        employees.put(employee2.getId(), employee2);
        employees.put(employee3.getId(), employee3);
    }

    private static Employee createEmployee(String name, int age, String geander) {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setAge(age);
        employee.setGender(geander);
        employee.setName(name);
        return employee;
    }

    public static List<Employee> findAll() {
        return new ArrayList<Employee>(employees.values());
    }

    public static Employee findById(String employeeId) {
        return employees.get(employeeId);
    }

    public static Employee add(Employee employee) {
        Employee employee1 = createEmployee(employee.getName(), employee.getAge(), employee.getGender());
        employees.put(employee1.getId(), employee1);
        return employee1;
    }

    public static Employee updateById(String employeeId, Employee employee) {
        Employee employee1 = employees.get(employeeId);
        employee1.setName(employee.getName());
        employee1.setGender(employee.getGender());
        employee1.setAge(employee.getAge());
        return employee1;
    }

    public static Employee deleteById(String employeeId) {
        return employees.remove(employeeId);
    }

    public static List<Employee> findByAge(int age) {
        return new ArrayList<Employee>(employees.values()).stream().
                filter(employee -> employee.getAge() > age).collect(Collectors.toList());
    }
}
