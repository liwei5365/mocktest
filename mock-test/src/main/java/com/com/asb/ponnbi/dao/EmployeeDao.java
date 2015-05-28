package com.com.asb.ponnbi.dao;

import com.com.asb.ponnbi.bean.Employee;

public interface EmployeeDao {

	public int getTotal();

	public void addEmployee(Employee employee);

	public void saveEmployee(Employee employee);

	public void updateEmploye(Employee employee);

	public long getCount(Employee employee);
	
	public boolean isConnection(String ... test);
}
