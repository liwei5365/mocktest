package com.com.asb.ponnbi.ctrol;

import com.com.asb.ponnbi.service.EmployeeService;
import com.com.asb.ponnbi.service.EmployeeServiceImpl;

public class EmployeeController {
	public String getEmail(final String userName) {
		EmployeeService employeeService = new EmployeeServiceImpl();
		String email = employeeService.findEmailByUserName(userName);
		return email;
	}
}
