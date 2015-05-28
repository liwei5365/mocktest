package com.com.asb.ponnbi.service;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.com.asb.ponnbi.bean.Employee;
import com.com.asb.ponnbi.dao.EmployeeDao;
import com.com.asb.ponnbi.dao.EmployeeDaoFinalImpl;
import com.com.asb.ponnbi.dao.EmployeeDaoImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest({EmployeeServiceImpl.class,EmployeeDaoFinalImpl.class})
public class EmployeeServicePowermockTest {

	@Test
	public final void testGetTotalEmployee() {
		EmployeeDao employeeDao = PowerMockito.mock(EmployeeDaoImpl.class);
		PowerMockito.when(employeeDao.getTotal()).thenReturn(10);
		EmployeeService service = new EmployeeServiceImpl(employeeDao);
		int total = service.getTotalEmployee();
		assertEquals(10, total);
	}
	
	@Test
	public final void testGetTotalEmployeeFinal() {
		EmployeeDao employeeDao = PowerMockito.mock(EmployeeDaoFinalImpl.class);
		PowerMockito.when(employeeDao.getTotal()).thenReturn(10);
		EmployeeService service = new EmployeeServiceImpl(employeeDao);
		int total = service.getTotalEmployee();
		assertEquals(10, total);
	}
	@Test
	public final void testCreateEmployee() {
		EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
		Employee employee = new Employee();
		PowerMockito.doNothing().when(employeeDao).addEmployee(employee);
		EmployeeService service = new EmployeeServiceImpl(employeeDao);
		service.createEmployee(employee);
		// verify the method invocation.
		Mockito.verify(employeeDao).addEmployee(employee);
	}
	@Ignore
	@Test
	public final void testSaveOrUpdate() throws Exception {

		Employee employee = new Employee();
		//
		EmployeeDaoImpl employeeDao1 = PowerMockito.mock(EmployeeDaoImpl.class);
		PowerMockito.whenNew(EmployeeDaoImpl.class).withNoArguments().thenReturn(employeeDao1);
		PowerMockito.when(employeeDao1.getCount(employee)).thenReturn(0L);
		EmployeeService employeeService1 = new EmployeeServiceImpl(employeeDao1);
		employeeService1.saveOrUpdate(employee);
		Mockito.verify(employeeDao1).saveEmployee(employee);
		Mockito.verify(employeeDao1, Mockito.never()).updateEmploye(employee);
		//
		EmployeeDaoImpl employeeDao2 = PowerMockito.mock(EmployeeDaoImpl.class);
		PowerMockito.whenNew(EmployeeDaoImpl.class).withNoArguments().thenReturn(employeeDao2);
		PowerMockito.when(employeeDao2.getCount(employee)).thenReturn(1L);
		EmployeeService employeeService2 = new EmployeeServiceImpl(employeeDao2);
		employeeService2.saveOrUpdate(employee);
		Mockito.verify(employeeDao2).updateEmploye(employee);
		Mockito.verify(employeeDao2,Mockito.never()).saveEmployee(employee);
		
	}

	@Ignore
	@Test
	public final void testFindEmailByUserName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testExist() throws Exception {
		//感觉有带你违反TDD的思想
		EmployeeService employeeService = PowerMockito.spy(new EmployeeServiceImpl());
		PowerMockito.doNothing().when(employeeService, "checkExist","lw");
		boolean result = employeeService.exist("lw");
		assertTrue(result);
		PowerMockito.verifyPrivate(employeeService).invoke("checkExist","lw");
		
	}

}
