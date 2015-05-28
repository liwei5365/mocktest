package com.com.asb.ponnbi.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class EmployeeDaoMockitoTest {
	
	private EmployeeDao employeeDao;
	@Before
	public void setUp() {
		
	}
	
	@Test
	public final void testGetTotalMockito() {
		employeeDao = org.mockito.Mockito.mock(EmployeeDao.class);
		org.mockito.Mockito.when(employeeDao.getTotal()).thenReturn(10);
		int i=employeeDao.getTotal();
		assertEquals(i,10);
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
