package com.com.asb.ponnbi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.com.asb.ponnbi.bean.Employee;
import com.com.asb.ponnbi.dao.EmployeeDaoConstructorImpl;
import com.com.asb.ponnbi.dao.EmployeeDaoConstructorImpl.Dialect;
import com.com.asb.ponnbi.dao.EmployeeDaoImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeServicePartialConstructorImpl.class)
public class EmployeeServicePowermockPartialConstructionsImplTest {

	@Test
	public final void testGetTotalEmployee() throws Exception {
		//
		EmployeeDaoConstructorImpl employeeDao = PowerMockito.mock(EmployeeDaoConstructorImpl.class);
		PowerMockito.whenNew(EmployeeDaoConstructorImpl.class).withArguments(false,Dialect.MYSQL).thenReturn(employeeDao);
		PowerMockito.when(employeeDao.getTotal()).thenReturn(10);
		EmployeeService service = new EmployeeServicePartialConstructorImpl();

		int total = service.getTotalEmployee();
		assertEquals(10, total);
	}

	@Test
	public final void testCreateEmployee() throws Exception {
		EmployeeDaoConstructorImpl employeeDao = PowerMockito.mock(EmployeeDaoConstructorImpl.class);
		PowerMockito.whenNew(EmployeeDaoConstructorImpl.class).withArguments(false,Dialect.MYSQL).thenReturn(employeeDao);
		Employee employee = new Employee();
		EmployeeService service = new EmployeeServicePartialConstructorImpl();
		service.createEmployee(employee);
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
