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
import com.com.asb.ponnbi.dao.EmployeeDaoImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeServicePartialImpl.class)
public class EmployeeServicePowermockPartialImplTest {

	@Test
	public final void testGetTotalEmployee() throws Exception {
		//
		EmployeeDaoImpl employeeDao = PowerMockito.mock(EmployeeDaoImpl.class);
		PowerMockito.whenNew(EmployeeDaoImpl.class).withNoArguments().thenReturn(employeeDao);
		PowerMockito.when(employeeDao.getTotal()).thenReturn(10);
		EmployeeService service = new EmployeeServicePartialImpl();

		int total = service.getTotalEmployee();
		assertEquals(10, total);
	}

	@Test
	public final void testCreateEmployee() throws Exception {
		EmployeeDaoImpl employeeDao = PowerMockito.mock(EmployeeDaoImpl.class);
		PowerMockito.whenNew(EmployeeDaoImpl.class).withNoArguments().thenReturn(employeeDao);
		Employee employee = new Employee();
		EmployeeService service = new EmployeeServicePartialImpl();
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
