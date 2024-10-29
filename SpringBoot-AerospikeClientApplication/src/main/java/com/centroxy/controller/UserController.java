package com.centroxy.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.centroxy.model.Employee;
import com.centroxy.repo.AerospikeUserRepository;
import com.centroxy.service.UserService;

@RestController
public class UserController {
	  
	@Autowired
	UserService userService;
	
	@Autowired
	AerospikeUserRepository repo;
	
    @GetMapping("/users/{id}")
    public Employee readUserById(@PathVariable("id") Integer id) {
    	
        return userService.readUserById(id);
    }
    @PostMapping("/users")
    public Employee addUser(@RequestBody Employee user) {
    	
    	
    	user.setLeaveTimeStamp(user.getLeaveDate().toEpochSecond(LocalTime.MIN, ZoneOffset.UTC)*1000);
    	user.setJoinTimeStamp(user.getJoinDate().toEpochSecond(LocalTime.MIN, ZoneOffset.UTC)*1000);
        var x = repo.save(user);
        System.out.println(x.toString());
        return x;
    }
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Integer id) {
        userService.removeUserById(id);
    }
 
    
    @GetMapping("/findAllByDate")
    public List<Employee> getEmployeesByDateRange(
            @RequestParam Long  fromDate,
            @RequestParam Long toDate){

    	
        return userService.findEmployeeByDate(fromDate, toDate);
    }
    
    @GetMapping("/findByEmail/{email}")
    public Employee findEmployeeByEmail(@PathVariable("email") String email) {
    	
        return userService.findByEmployeeByEmail(email);
    }
    
    @GetMapping("/age")
    public List<Employee> findByEmployeeByAge(@RequestParam Integer  age1,@RequestParam Integer age2) {
    	return userService.findByEmployeeByAge(age1, age2);
    	
    }

}
