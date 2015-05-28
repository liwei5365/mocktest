package com.com.asb.ponnbi.service;

import com.com.asb.ponnbi.bean.Employee;
import com.com.asb.ponnbi.dao.EmployeeDao;
import com.com.asb.ponnbi.dao.EmployeeDaoImpl;
import com.com.asb.ponnbi.util.EmployeeUtils;

public class EmployeeServiceStaticImpl implements EmployeeService {

	public EmployeeServiceStaticImpl() {
		super();
	}

	public EmployeeServiceStaticImpl(EmployeeDao employeeDao) {
		
	}

	public int getTotalEmployee() {
		return EmployeeUtils.getEmployeeCount();
	}

	public void createEmployee(Employee employee) {
		EmployeeUtils.persistenceEmployee(employee);
	}

	public void saveOrUpdate(Employee employee) {
		EmployeeUtils.saveOrUpdate(employee);
	}

	public String findEmailByUserName(String userName) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public boolean exist(String userName) {
		throw new UnsupportedOperationException();
	}
}
