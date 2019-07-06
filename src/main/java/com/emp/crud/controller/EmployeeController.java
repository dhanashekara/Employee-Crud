package com.emp.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.crud.dto.EmployeeDTO;
import com.emp.crud.exception.ApplicationException;
import com.emp.crud.model.Employee;
import com.emp.crud.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDTO>> getList() {
		List<EmployeeDTO> empList = employeeService.getEmpList();
		return new ResponseEntity<List<EmployeeDTO>>(empList,HttpStatus.OK);
	}

	@PostMapping("/createEmployee")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employee) {

		return new ResponseEntity<String>(employeeService.createEmp(employee),HttpStatus.OK);
	}

	@GetMapping("/employeeById/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "id") long id) throws ApplicationException {

		EmployeeDTO emp = employeeService.getEmpById(id);
		 if(emp!=null) {
		 return new ResponseEntity<EmployeeDTO>(emp,HttpStatus.OK);
		 }else {
			 return new ResponseEntity<EmployeeDTO>(emp,HttpStatus.BAD_REQUEST);	 
		 }

	}

	@PutMapping("/updateEmployee")
	public String updateEmpDetails(@RequestBody EmployeeDTO emp) {
		return employeeService.updateEmpDetails(emp);
	}

	@DeleteMapping("/deleteEmployeeById{id}")
	public String deleteEmpById(@PathVariable long id) {

		return employeeService.deleteEmpById(id);
	}

}
