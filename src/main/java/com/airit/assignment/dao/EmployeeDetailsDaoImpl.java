package com.airit.assignment.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.airit.assignment.model.EmployeeDetails;

@Repository("employeeDetailsDao")
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class EmployeeDetailsDaoImpl extends AbstractDao<Integer, EmployeeDetails> implements EmployeeDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public String addNewEmployee(String firstName, String middleName, String lastName, String userName,
			String employeeBirthday, String employeeBloodGroup, String emailAddress, String contactNumber,
			String employeeDesignation, String employeeSalary) {
		// TODO Auto-generated method stub
		int res = 0;
		Transaction beginTransaction = null;
		try {
			beginTransaction = sessionFactory.getCurrentSession().beginTransaction();
			List<EmployeeDetails> list = sessionFactory.getCurrentSession()
					.createQuery("FROM EmployeeDetails WHERE username='" + userName + "'").list();
			if (list.isEmpty()) {
				res = (int) sessionFactory.getCurrentSession()
						.save(new EmployeeDetails(firstName, middleName, lastName, employeeDesignation, employeeSalary,
								employeeBirthday, contactNumber, userName, emailAddress, employeeBloodGroup));
			}
			beginTransaction.commit();
			System.out.println("The value of inserted tuple is...." + res);
		} catch (Exception e) {
			// TODO: handle exception
			beginTransaction.rollback();
			e.printStackTrace();
		}
		if (res > 0) {
			System.out.println("success....");
			return "success";
		} else {
			System.out.println("failed....");
			return "failed";
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public JSONArray getEmployeeList() {
		// TODO Auto-generated method stub
		JSONArray array = new JSONArray();
		JSONArray array1 = null;
		try {
			List<EmployeeDetails> list = sessionFactory.getCurrentSession().createQuery("FROM EmployeeDetails").list();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				EmployeeDetails employeeDetails = (EmployeeDetails) iterator.next();
				array1 = new JSONArray();
				array1.put("<button class='btn btn--radius-2 btn--blue' onclick='getUpdateDetails(\""
						+ employeeDetails.getUsername() + "\",\"" + employeeDetails.getFirstName() + "\",\""
						+ employeeDetails.getMiddleName() + "\",\"" + employeeDetails.getLastName() + "\",\""
						+ employeeDetails.getEmployeeBirthday() + "\",\"" + employeeDetails.getEmployeeSalary()
						+ "\",\"" + employeeDetails.getEmployeeBloodGroup() + "\",\""
						+ employeeDetails.getEmailAddress() + "\",\"" + employeeDetails.getContactNumber() + "\",\""
						+ employeeDetails.getEmployeeDesignation() + "\");'><i class='fa fa-edit'></i></button>");
				array1.put("<button class='btn btn--radius-2 btn--red' onClick='deleteEmployeeDetails(\""
						+ employeeDetails.getUsername() + "\");'><i class='fa fa-trash'></i></button>");
				array1.put(employeeDetails.getFirstName() + " " + employeeDetails.getMiddleName() + " "
						+ employeeDetails.getLastName());
				array1.put(employeeDetails.getEmployeeBirthday());
				array1.put(employeeDetails.getEmployeeSalary());
				array1.put(employeeDetails.getEmployeeBloodGroup());
				array1.put(employeeDetails.getEmailAddress());
				array1.put(employeeDetails.getContactNumber());
				array1.put(employeeDetails.getEmployeeDesignation());
				array.put(array1);
			}
			System.out.println("Array values..." + array);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return array;
	}

	@Override
	public String deleteEmployeeDetails(String username) {
		// TODO Auto-generated method stub
		System.out.println("Inside DAO and username is...." + username);
		int executeUpdate = 0;
		Transaction beginTransaction = null;
		try {
			beginTransaction = sessionFactory.getCurrentSession().beginTransaction();
			executeUpdate = sessionFactory.getCurrentSession()
					.createQuery("DELETE FROM EmployeeDetails WHERE username='" + username + "'").executeUpdate();
			beginTransaction.commit();
			System.out.println("The value of inserted tuple is...." + executeUpdate);
		} catch (Exception e) {
			// TODO: handle exception
			beginTransaction.rollback();
			e.printStackTrace();
		}
		if (executeUpdate > 0) {
			System.out.println("success....");
			return "success";
		} else {
			System.out.println("failed....");
			return "failed";
		}
	}

	@Override
	public String updateEmployeeDetailsForUser(String username, String firstName, String middleName, String lastName,
			String employeeBirthday, String employeeSalary, String employeeBloodGroup, String emailAddress,
			String contactNumber, String employeeDesignation) {
		// TODO Auto-generated method stub
		int executeUpdate = 0;
		Transaction beginTransaction = null;
		try {
			beginTransaction = sessionFactory.getCurrentSession().beginTransaction();
			executeUpdate = sessionFactory.getCurrentSession()
					.createQuery("UPDATE EmployeeDetails SET first_name='" + firstName + "', middle_name='" + middleName
							+ "', last_name='" + lastName + "', employee_designation='" + employeeDesignation
							+ "', employee_salary='" + employeeSalary + "', employee_birthday='" + employeeBirthday
							+ "', contact_number='" + contactNumber + "', email_address='" + emailAddress
							+ "', employee_blood_group='" + employeeBloodGroup + "' WHERE username='" + username + "'")
					.executeUpdate();
			beginTransaction.commit();
			System.out.println("The value of inserted tuple is...." + executeUpdate);
		} catch (Exception e) {
			// TODO: handle exception
			beginTransaction.rollback();
			e.printStackTrace();
		}
		if (executeUpdate > 0) {
			System.out.println("success....");
			return "success";
		} else {
			System.out.println("failed....");
			return "failed";
		}
	}
}