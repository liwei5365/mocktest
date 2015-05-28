package com.com.asb.ponnbi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.com.asb.ponnbi.dao.EmployeeDao;
import com.com.asb.ponnbi.dao.EmployeeDaoFinalImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeDaoFinalImpl.class)
public class EmployeeServiceImplFinalTest {
	
	@Test
	public final void testGetTotalEmployee() {
		EmployeeDao employeeDao = PowerMockito.mock(EmployeeDaoFinalImpl.class);
		PowerMockito.when(employeeDao.getTotal()).thenReturn(10);
		EmployeeService service = new EmployeeServiceImpl(employeeDao);
		int total = service.getTotalEmployee();
		assertEquals(10, total);
	}
	@Ignore
	@Test
	public final void testCreateEmployee() {
		fail("Not yet implemented"); // TODO
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
