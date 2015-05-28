package com.com.asb.ponnbi.service;

import com.com.asb.ponnbi.bean.Employee;
import com.com.asb.ponnbi.dao.EmployeeDao;
import com.com.asb.ponnbi.dao.EmployeeDaoConstructorImpl;
import com.com.asb.ponnbi.dao.EmployeeDaoConstructorImpl.Dialect;
import com.com.asb.ponnbi.dao.EmployeeDaoImpl;

public class EmployeeServicePartialConstructorImpl implements EmployeeService {

	public EmployeeServicePartialConstructorImpl() {
		super();
	}

	public EmployeeServicePartialConstructorImpl(EmployeeDao employeeDao) {
	}

	public int getTotalEmployee() {
		EmployeeDao employeeDao = new EmployeeDaoConstructorImpl(false,Dialect.MYSQL);
		return employeeDao.getTotal();
	}

	public void createEmployee(Employee employee) {
		EmployeeDao employeeDao = new EmployeeDaoConstructorImpl(false,Dialect.MYSQL);
		employeeDao.addEmployee(employee);
	}

	public void saveOrUpdate(Employee employee) {

		final EmployeeDao employeeDao = new EmployeeDaoConstructorImpl(false,Dialect.MYSQL);
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
		throw new UnsupportedOperationException();
	}

}
