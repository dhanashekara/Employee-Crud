package com.emp.crud.dto;


public class EmployeeDTO {

	private long empId;
	private String empName;
	private String empEmail;
	private String empAddress;
	private String empContact;

	//private EmployeeDTO employeeDTO;

	/*
	 * public EmployeeDTO getEmployeeDTO() { return employeeDTO; }
	 * 
	 * public void setEmployeeDTO(EmployeeDTO employeeDTO) { this.employeeDTO =
	 * employeeDTO; }
	 */
	

	public long getEmpId() {
		return empId;
	}

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(long empId, String empName, String empEmail, String empAddress, String empContact) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empAddress = empAddress;
		this.empContact = empContact;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpContact() {
		return empContact;
	}

	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}
}
