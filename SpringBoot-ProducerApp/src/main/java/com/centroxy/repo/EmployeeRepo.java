package com.centroxy.repo;

import org.springframework.data.repository.CrudRepository;

import com.centroxy.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee,Integer> {

}
