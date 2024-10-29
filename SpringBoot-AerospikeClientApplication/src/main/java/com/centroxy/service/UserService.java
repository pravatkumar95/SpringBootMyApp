package com.centroxy.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroxy.model.Employee;
import com.centroxy.repo.AerospikeUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	@Autowired
	AerospikeUserRepository aerospikeUserRepository;
    public Employee readUserById(int id) {
       Optional<Employee> user=aerospikeUserRepository.findById(id);
////        System.out.println(aerospikeUserRepository.findAll().toString());
      return user.get();
       
    }
    public void addUser(Employee user) {
    	//aerospikeUserRepository.
    }
    public void removeUserById(int id) {
        aerospikeUserRepository.deleteById(id);
    }
    
    public List<Employee>  findEmployeeByDate(long fromDate, long toDate) {
    	
    	return aerospikeUserRepository.findAllByJoinTimeStampBetween(fromDate, toDate);
        
    }
    
    public Employee findByEmployeeByEmail(String email) {
    	return aerospikeUserRepository.findByEmail(email);
    	
    }
    
    public List<Employee> findByEmployeeByAge(Integer age1,Integer age2 ) {
    	return aerospikeUserRepository.findByAgeBetween(age1,age2);
    	
    }

}
