package com.com.asb.ponnbi.service;

import com.com.asb.ponnbi.bean.Employee;
import com.com.asb.ponnbi.dao.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService{

	public EmployeeServiceImpl() {
		super();
	}

	private EmployeeDao employeeDao;

	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public int getTotalEmployee() {
		return employeeDao.getTotal();
	}

	public void createEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	public void saveOrUpdate(Employee employee) {

		long count = employeeDao.getCount(employee);
		if (count > 0)
			employeeDao.updateEmploye(employee);
		else
			employeeDao.saveEmployee(employee);
	}

	public String findEmailByUserName(String userName) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public boolean exist(String userName) {
		checkExist(userName);
		return true;
	}

	private void checkExist(String userName) {
		throw new UnsupportedOperationException();
	}
}
