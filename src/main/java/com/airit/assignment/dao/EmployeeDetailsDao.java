package com.airit.assignment.dao;

import org.json.JSONArray;

public interface EmployeeDetailsDao {

	String addNewEmployee(String firstName, String middleName, String lastName, String userName,
			String employeeBirthday, String employeeBloodGroup, String emailAddress, String contactNumber,
			String employeeDesignation, String employeeSalary);

	JSONArray getEmployeeList();

	String deleteEmployeeDetails(String username);

	String updateEmployeeDetailsForUser(String username, String firstName, String middleName, String lastName,
			String employeeBirthday, String employeeSalary, String employeeBloodGroup, String emailAddress,
			String contactNumber, String employeeDesignation);
	
}
