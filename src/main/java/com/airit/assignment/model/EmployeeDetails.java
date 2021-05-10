package com.airit.assignment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "employee_details", uniqueConstraints = @UniqueConstraint(columnNames = { "username" }))
public class EmployeeDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1940478058099768545L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "employee_designation")
	private String employeeDesignation;

	@Column(name = "employee_salary")
	private String employeeSalary;

	@Column(name = "employee_birthday")
	private String employeeBirthday;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "username")
	private String username;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "employee_blood_group")
	private String employeeBloodGroup;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(String employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmployeeBloodGroup() {
		return employeeBloodGroup;
	}

	public void setEmployeeBloodGroup(String employeeBloodGroup) {
		this.employeeBloodGroup = employeeBloodGroup;
	}

	public String getEmployeeBirthday() {
		return employeeBirthday;
	}

	public void setEmployeeBirthday(String employeeBirthday) {
		this.employeeBirthday = employeeBirthday;
	}

	public EmployeeDetails(String firstName, String middleName, String lastName, String employeeDesignation,
			String employeeSalary, String employeeBirthday, String contactNumber, String username, String emailAddress,
			String employeeBloodGroup) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.employeeDesignation = employeeDesignation;
		this.employeeSalary = employeeSalary;
		this.employeeBirthday = employeeBirthday;
		this.contactNumber = contactNumber;
		this.username = username;
		this.emailAddress = emailAddress;
		this.employeeBloodGroup = employeeBloodGroup;
	}

	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", employeeDesignation=" + employeeDesignation + ", employeeSalary="
				+ employeeSalary + ", employeeBirthday=" + employeeBirthday + ", contactNumber=" + contactNumber
				+ ", username=" + username + ", emailAddress=" + emailAddress + ", employeeBloodGroup="
				+ employeeBloodGroup + "]";
	}

}
