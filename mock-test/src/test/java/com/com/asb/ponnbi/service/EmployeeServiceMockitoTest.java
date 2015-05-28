package com.com.asb.ponnbi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import com.com.asb.ponnbi.bean.Employee;
import com.com.asb.ponnbi.dao.EmployeeDao;
import com.com.asb.ponnbi.dao.EmployeeDaoImpl;

public class EmployeeServiceMockitoTest {
	
	@Test
	public final void testGetTotalEmployee() {
		EmployeeDao employeeDao = Mockito.mock(EmployeeDaoImpl.class);
		Mockito.when(employeeDao.getTotal()).thenReturn(10);
		EmployeeService service = new EmployeeServiceImpl(employeeDao);
		int total = service.getTotalEmployee();
		assertEquals(10, total);
	}

	@Test
	public final void testCreateEmployee() {
		EmployeeDao employeeDao = Mockito.mock(EmployeeDao.class);
		Employee employee = new Employee();
		Mockito.doNothing().when(employeeDao).addEmployee(employee);
		EmployeeService service = new EmployeeServiceImpl(employeeDao);
		service.createEmployee(employee);
		// verify the method invocation.
		Mockito.verify(employeeDao).addEmployee(employee);
	}

	@Ignore
	@Test
	public final void testSaveOrUpdate() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public final void testFindEmailByUserName() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	@Test
	public final void testExist() {
		fail("Not yet implemented"); // TODO
	}

}
