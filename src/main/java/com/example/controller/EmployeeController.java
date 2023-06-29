package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customException.BusinessException;
import com.example.customException.ControllerException;
import com.example.entity.Employee;
import com.example.repos.EmployeeCrudRepo;
import com.example.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/code")
public class EmployeeController {
	
	@Autowired
	EmployeeCrudRepo empCrudrepo;
	@Autowired
	private EmployeeServiceInterface employeServiceInterface;
	
	@GetMapping("/chk")
	public List<Employee> getAllEmployee(){
		System.out.println("Getting all the employee");
		return empCrudrepo.findAll();	
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
		try {
			Employee employeeSaved = employeServiceInterface.addEmployee(employee);
			HttpHeaders httpH = new HttpHeaders();
			httpH.add(null, null);
			return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("611","Somthing went wrong in contoller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
}
