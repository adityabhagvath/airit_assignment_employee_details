package com.airit.assignment.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.airit.assignment.service.EmployeeDetailsService;

@Controller
@RequestMapping("/")
public class EmployeeDetailsController {

	@Autowired
	EmployeeDetailsService employeeDetailsService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String getIndexPage(HttpServletRequest request) {
		System.out.println("Context Path is...." + request.getContextPath());
		return "index";
	}

	@RequestMapping(value = { "/addNewEmployee" }, method = RequestMethod.POST)
	public String addNewEmployee(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName,
			@RequestParam("lastName") String lastName, @RequestParam("userName") String userName,
			@RequestParam("employeeBirthday") String employeeBirthday,
			@RequestParam("employeeBloodGroup") String employeeBloodGroup,
			@RequestParam("emailAddress") String emailAddress, @RequestParam("contactNumber") String contactNumber,
			@RequestParam("employeeDesignation") String employeeDesignation,
			@RequestParam("employeeSalary") String employeeSalary) {
		System.out.println("The values from the front end::::" + firstName + " ..." + middleName + " ..." + lastName
				+ " ..." + userName + " ..." + employeeBirthday + " ..." + employeeBloodGroup + " ..." + emailAddress
				+ " ..." + employeeDesignation + " ..." + employeeSalary);
		String res = null;
		try {
			res = employeeDetailsService.addNewEmployee(firstName, middleName, lastName, userName, employeeBirthday,
					employeeBloodGroup, emailAddress, contactNumber, employeeDesignation, employeeSalary);
			System.out.println("The value of result is..." + res);
			if (res.equalsIgnoreCase("success")) {
				model.addAttribute("add", "success");
			} else if (res.equalsIgnoreCase("failed")) {
				model.addAttribute("add", "failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "index";
	}

	@RequestMapping(value = { "/getEmployeeList" }, method = RequestMethod.POST)
	public String getEmployeeList(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		JSONArray array = new JSONArray();
		try {
			out = response.getWriter();
			array = employeeDetailsService.getEmployeeList();
			System.out.println("The value of result is..." + array);
			out.println(array);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			out.close();
		}
		return "index";
	}

	@RequestMapping(value = { "/deleteEmployeeDetails" }, method = RequestMethod.POST)
	public String deleteEmployeeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Delete Employee...");
		String res = null;
		PrintWriter out = null;
		String username = request.getParameter("username");
		System.out.println("Username is..." + username);
		try {
			out = response.getWriter();
			res = employeeDetailsService.deleteEmployeeDetails(username);
			System.out.println("The value of result is..." + res);
			out.println(res);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			out.close();
		}
		return "index";
	}

	@RequestMapping(value = { "/updateEmployeeDetailsForUser" }, method = RequestMethod.POST)
	public String updateEmployeeDetailsForUser(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("Update Employee...");
		String res = null;
		PrintWriter out = null;
		String username = request.getParameter("username");
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String employeeBirthday = request.getParameter("employeeBirthday");
		String employeeSalary = request.getParameter("employeeSalary");
		String employeeBloodGroup = request.getParameter("employeeBloodGroup");
		String emailAddress = request.getParameter("emailAddress");
		String contactNumber = request.getParameter("contactNumber");
		String employeeDesignation = request.getParameter("employeeDesignation");
		System.out.println("Username is..." + username);
		try {
			out = response.getWriter();
			res = employeeDetailsService.updateEmployeeDetailsForUser(username, firstName, middleName, lastName,
					employeeBirthday, employeeSalary, employeeBloodGroup, emailAddress, contactNumber,
					employeeDesignation);
			System.out.println("The value of result is..." + res);
			out.println(res);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			out.close();
		}
		return "index";
	}
}
