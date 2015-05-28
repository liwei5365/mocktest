package com.com.asb.ponnbi.service;

import com.com.asb.ponnbi.bean.Employee;
import com.com.asb.ponnbi.dao.EmployeeDao;
import com.com.asb.ponnbi.dao.EmployeeDaoImpl;
import com.com.asb.ponnbi.util.EmployeeUtils;

public class EmployeeServicePartialImpl implements EmployeeService {

	public EmployeeServicePartialImpl() {
		super();
	}

	public EmployeeServicePartialImpl(EmployeeDao employeeDao) {
	}

	public int getTotalEmployee() {
		EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
		return employeeDao.getTotal();
	}

	public void createEmployee(Employee employee) {
		EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
		employeeDao.addEmployee(employee);
	}

	public void saveOrUpdate(Employee employee) {

		final EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
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
