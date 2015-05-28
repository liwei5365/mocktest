package com.com.asb.ponnbi.dao;

import com.com.asb.ponnbi.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public int getTotal() {
		throw new UnsupportedOperationException();
	}

	public void addEmployee(Employee employee) {
		throw new UnsupportedOperationException();
	}

	public void saveEmployee(Employee employee) {
		throw new UnsupportedOperationException();
	}

	public void updateEmploye(Employee employee) {
		throw new UnsupportedOperationException();
	}

	public long getCount(Employee employee) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isConnection(String ... test) {
		// TODO Auto-generated method stub
		if(test.length>0){
			return true;
		}
		return false;
	}
}