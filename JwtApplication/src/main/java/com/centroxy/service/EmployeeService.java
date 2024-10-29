package com.centroxy.service;

import com.centroxy.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private List<Employee> listEmployee=new ArrayList<Employee>();
    public List<Employee> getEmployeeDetails(){

        Employee emp1=new Employee(101,"pravat",22,25000.00);
        Employee emp2=new Employee(102,"rajesh",23,34000.00);
        Employee emp3=new Employee(103,"shyam",25,50000.00);
        listEmployee.add(emp1);
        listEmployee.add(emp2);
        listEmployee.add(emp3);
        return listEmployee;

    }


    public Employee getEmployeeById(Integer id){


        Optional<Employee>  employee=listEmployee.stream().filter(emp -> emp.getId()==id).findFirst();
        return employee.get();

    }
}
