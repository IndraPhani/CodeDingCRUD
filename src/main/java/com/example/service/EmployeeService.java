package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customException.BusinessException;
import com.example.entity.Employee;
import com.example.repos.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	
	@Autowired
	private EmployeeCrudRepo crudRepo;

	@Override
	public Employee addEmployee(Employee emp) {
		if(emp.getName().isEmpty()||emp.getName().length()==0)
			throw new BusinessException("601","Please send the proper name it is blank");
		try {
			 Employee savedEmpl= crudRepo.save(emp);
			 return savedEmpl;
		}catch(IllegalArgumentException  e) {
				throw new BusinessException("602","Given employee is null please check it"+e.getMessage());
		}catch(Exception  e) {
			throw new BusinessException("603","Something went wrong in ServLayer"+e.getMessage());
	}
	}
	public List<Employee> getAllEmployees(){
		List<Employee> empList =null;
		try {
				empList = crudRepo.findAll();
			//return empList;
		}catch(Exception e) {
			throw new BusinessException("605","Something went wrong in ServLayer while saving emp"+e.getMessage());	
		}if(empList.isEmpty())
			throw new BusinessException("604","Hey list is completely empty");
		return empList;
	}

}
