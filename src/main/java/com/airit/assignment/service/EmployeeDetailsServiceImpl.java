package com.airit.assignment.service;

import org.springframework.transaction.annotation.Transactional;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airit.assignment.dao.EmployeeDetailsDao;

@Service("employeeDetailsService")
@Transactional
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	@Autowired
	EmployeeDetailsDao employeeDetailsDao;

	@Override
	public String addNewEmployee(String firstName, String middleName, String lastName, String userName,
			String employeeBirthday, String employeeBloodGroup, String emailAddress, String contactNumber,
			String employeeDesignation, String employeeSalary) {
		// TODO Auto-generated method stub
		return employeeDetailsDao.addNewEmployee(firstName, middleName, lastName, userName, employeeBirthday,
				employeeBloodGroup, emailAddress, contactNumber, employeeDesignation, employeeSalary);
	}

	@Override
	public JSONArray getEmployeeList() {
		// TODO Auto-generated method stub
		return employeeDetailsDao.getEmployeeList();
	}
	
	@Override
	public String deleteEmployeeDetails(String username) {
		// TODO Auto-generated method stub
		return employeeDetailsDao.deleteEmployeeDetails(username);
	}

	@Override
	public String updateEmployeeDetailsForUser(String username, String firstName, String middleName, String lastName,
			String employeeBirthday, String employeeSalary, String employeeBloodGroup, String emailAddress,
			String contactNumber, String employeeDesignation) {
		// TODO Auto-generated method stub
		return employeeDetailsDao.updateEmployeeDetailsForUser(username, firstName, middleName, lastName,
				employeeBirthday, employeeSalary, employeeBloodGroup, emailAddress, contactNumber,
				employeeDesignation);
	}
}
