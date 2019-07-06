package com.emp.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.crud.dto.EmployeeDTO;
import com.emp.crud.exception.ApplicationException;
import com.emp.crud.model.Employee;

@Service
public interface EmployeeService {

	public List<EmployeeDTO> getEmpList();

	public EmployeeDTO getEmpById(long id) ;

	public String updateEmpDetails(EmployeeDTO emp);

	public String deleteEmpById(long id);

	public String createEmp(EmployeeDTO emp);
}
