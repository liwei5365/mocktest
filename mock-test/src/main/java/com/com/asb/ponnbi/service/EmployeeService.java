package com.com.asb.ponnbi.service;

import com.com.asb.ponnbi.bean.Employee;

public interface EmployeeService {

	public int getTotalEmployee();

	public void createEmployee(Employee employee);

	public void saveOrUpdate(Employee employee);

	public String findEmailByUserName(String userName);

	public boolean exist(String userName);

}
