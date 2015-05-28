package com.com.asb.ponnbi.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

public class EmployeeDaoPowerMockTest {
	
	private EmployeeDao employeeDao;
	@Before
	public void setUp() {
		
	}
	
	
	@Test
	public final void testGetTotalPowerMock() {
		employeeDao = PowerMockito.mock(EmployeeDao.class);
		PowerMockito.when(employeeDao.getTotal()).thenReturn(10);
		int i=employeeDao.getTotal();
		assertEquals(i,10);
	}
	
	@Test
	public final void testIsConnection() {
		employeeDao = PowerMockito.mock(EmployeeDaoImpl.class);
		assertEquals(false,employeeDao.isConnection("test"));
		EmployeeDaoImpl employeeDao1 = PowerMockito.spy(new EmployeeDaoImpl());
		assertEquals(true,employeeDao1.isConnection("test"));
	}
	@Test
	@Ignore
	public final void testGetTotal() {
		employeeDao=new EmployeeDaoImpl();
		int i=employeeDao.getTotal();
		assertEquals(i,10);
	}
	@Test
	@Ignore
	public final void testAddEmployee() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	@Ignore
	public final void testSaveEmployee() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	@Ignore
	public final void testUpdateEmploye() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	@Ignore
	public final void testGetCount() {
		fail("Not yet implemented"); // TODO
	}

}
