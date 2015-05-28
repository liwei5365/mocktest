package com.com.asb.ponnbi.service;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.com.asb.ponnbi.bean.Employee;
import com.com.asb.ponnbi.util.EmployeeUtils;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeUtils.class)
public class EmployeeServicePowermockStaticImplTest {

	@Test
	public final void testGetTotalEmployee() {

		PowerMockito.mockStatic(EmployeeUtils.class);

		PowerMockito.when(EmployeeUtils.getEmployeeCount()).thenReturn(10);
		EmployeeService employeeService = new EmployeeServiceStaticImpl();
		int count = employeeService.getTotalEmployee();
		assertEquals(10, count);
	}

	@Test
	public final void testCreateEmployee() {
		PowerMockito.mockStatic(EmployeeUtils.class);
		
		Employee employee = new Employee();
		PowerMockito.doNothing().when(EmployeeUtils.class);
		EmployeeService employeeService = new EmployeeServiceStaticImpl();
		employeeService.createEmployee(employee);
		PowerMockito.verifyStatic();
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
