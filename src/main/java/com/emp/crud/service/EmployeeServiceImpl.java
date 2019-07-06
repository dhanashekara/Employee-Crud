package com.emp.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.emp.crud.dto.EmployeeDTO;
import com.emp.crud.exception.ApplicationException;
import com.emp.crud.model.Employee;
import com.emp.crud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<EmployeeDTO> getEmpList() {

		List<Employee> empList  = new ArrayList<Employee>();

		empList = employeeRepository.findAll();
		List<EmployeeDTO> empListDTO = new ArrayList<EmployeeDTO>();

		//modelMapper.map(empList, empListDTO);
		//empListDTO.addAll(empList);
		empList.forEach(emp -> empListDTO.add(modelMapper.map(emp, EmployeeDTO.class)));

		return empListDTO;
	}

	public EmployeeDTO getEmpById(long id) {
		//try {
		EmployeeDTO  empDTO = new EmployeeDTO();
		Employee emp = new Employee();

		emp = employeeRepository.findByEmpId(id);
		empDTO =  modelMapper.map(emp, EmployeeDTO.class);
		return empDTO;

		/*} catch (Exception e) {
			throw new ApplicationException("Employee does not exist with the given id");
		}*/
	}

	@Override
	public String updateEmpDetails(EmployeeDTO emp) {

		// Employee empEntity = modelMapper.map(emp,Employee.class);

		Optional op = employeeRepository.findById(emp.getEmpId());
		if(!op.isPresent())
		{
			return "Employee with id " + emp.getEmpId() + " Doesn't exist";
		} else {
		//	op.get();
			Employee updatedEmp = employeeRepository.findById(emp.getEmpId()).get();

			if (emp.getEmpAddress() != null && !emp.getEmpAddress().isEmpty())
				updatedEmp.setEmpAddress(emp.getEmpAddress());
			if (emp.getEmpContact() != null && !emp.getEmpContact().isEmpty())
				updatedEmp.setEmpContact(emp.getEmpContact());
			if (emp.getEmpEmail() != null && !emp.getEmpEmail().isEmpty())
				updatedEmp.setEmpEmail(emp.getEmpEmail());
			if (emp.getEmpName() != null && !emp.getEmpName().isEmpty())
				updatedEmp.setEmpName(emp.getEmpName());

			if (employeeRepository.save(updatedEmp) != null)
				return "employee details updated successfully";
			else
				return "There is some error internally !! Plz try agiain later";
		}

	}

	@Override
	public String deleteEmpById(long id) {

		if ("Optional.empty".contains("" + employeeRepository.findById(id))) {
			return "Employee with id " + id + " Doesn't exist";
		} else {
			employeeRepository.deleteById(id);
			return "Employee deleted successfully";
		}

	}

	@Override
	public String createEmp(EmployeeDTO emp) {

		Employee entityEmp = modelMapper.map(emp, Employee.class);

		//	 Employee empEntity = employeeRepository.save(entityEmp);

		//	 EmployeeDTO empDTO = modelMapper.map(empEntity,EmployeeDTO.class);

		if (employeeRepository.save(entityEmp) != null) {
			return "Employee Created";
		} else
			return "Some thing went wrong Plz try again";
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
