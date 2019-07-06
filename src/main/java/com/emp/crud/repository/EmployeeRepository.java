package com.emp.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.crud.model.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

	public Employee findByEmpId(long id);

}
