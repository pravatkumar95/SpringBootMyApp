package com.centroxy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.centroxy.constant.MessageConstant;
import com.centroxy.model.Employee;
import com.centroxy.repo.EmployeeRepo;

@Controller
@RequestMapping("/centroxy")
public class EmployeeController {
	
    @Autowired
	private EmployeeRepo repo;
	
	@GetMapping("/getEmployee")
	public String getEmployee(Model model) {
		
		Employee employee=new Employee();
		model.addAttribute("employee",employee);
		
		return "employeeRegister";
		
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee emp,Model model){
		
		String message=null;
		System.out.println("hello centroxy");
		
//		Optional<Employee> emp1=repo.findById(emp.getId());
//		if(emp1.get()!=null) {
//			String  msg=MessageConstant.message1;
//			 model.addAttribute("messages",msg);
//			 message="errorDetails";
//			 
//			
//		}
		
			repo.save(emp);
			Iterable<Employee> listEmp=repo.findAll();
			model.addAttribute("listEmployee",listEmp);
			message="employeeDetails";
	
		return message;
		
		
	}

}
