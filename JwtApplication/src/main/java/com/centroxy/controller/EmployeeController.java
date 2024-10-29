package com.centroxy.controller;

import com.centroxy.model.Employee;
import com.centroxy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmployeeController {


    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){

        this.employeeService=employeeService;
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>>  getEmployeeDetails(){


       List<Employee> listEmployee=employeeService.getEmployeeDetails();
       return new ResponseEntity<>(listEmployee, HttpStatus.OK);

    }

    @GetMapping("/getEmployeeById")
    public ResponseEntity<Employee>  getEmployeeById(Integer id){

        Employee emp=employeeService.getEmployeeById(id);
        return new ResponseEntity<Employee>(emp,HttpStatus.OK);

    }
}
