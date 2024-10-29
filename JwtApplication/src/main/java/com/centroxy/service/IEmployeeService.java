package com.centroxy.service;

import com.centroxy.model.Employee;

import java.util.List;

public interface IEmployeeService {

     String saveEmployee(Employee employee);
     List<Employee> getAllEmployee();
     Employee getEmployeeById(Integer id);
     




}
