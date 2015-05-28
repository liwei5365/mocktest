package com.com.asb.ponnbi.ctrol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.com.asb.ponnbi.service.EmployeeServiceImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeController.class)
public class EmployeeControllerTest {

	@Test
	public final void testGetEmailByArgumentMatcher() throws Exception {
		EmployeeServiceImpl employeeService = PowerMockito.mock(EmployeeServiceImpl.class);
		PowerMockito.when(employeeService.findEmailByUserName(Mockito.argThat(new ArgumentMatcher<String>() {
			@Override
			public boolean matches(Object argument) {
				String arg = (String) argument;
				if (arg.startsWith("lw")) {
					return true;
				} else {
					// return false;
					throw new RuntimeException();
				}
			}
		}))).thenReturn("Wei.AV.Li@alcatel-sbell.com.cn");

		PowerMockito.whenNew(EmployeeServiceImpl.class).withAnyArguments().thenReturn(employeeService);
		EmployeeController controller = new EmployeeController();
		String email = controller.getEmail("lw");
		assertEquals("Wei.AV.Li@alcatel-sbell.com.cn", email);
		try {
			controller.getEmail("dd");
		} catch (Exception e) {
			assertTrue(e instanceof RuntimeException);
		}
	}

	@Test
	public void testGetEmailByAnswer() throws Exception {
		EmployeeServiceImpl employeeService = PowerMockito.mock(EmployeeServiceImpl.class);
		PowerMockito.when(employeeService.findEmailByUserName(Mockito.anyString())).then(new Answer<String>() {
			@Override
			public String answer(InvocationOnMock invocation) throws Throwable {
				String argument = (String) invocation.getArguments()[0];
				if ("lw".equals(argument))
					return "Wei.AV.Li@alcatel-sbell.com.cn";
				else if ("lwei".equals(argument))
					return "Wei.U.Li@alcatel-sbell.com.cn";
				throw new RuntimeException();
			}
		});

		PowerMockito.whenNew(EmployeeServiceImpl.class).withNoArguments().thenReturn(employeeService);
		EmployeeController controller = new EmployeeController();
		String email = controller.getEmail("lw");
		assertEquals("Wei.AV.Li@alcatel-sbell.com.cn", email);
		email = controller.getEmail("lwei");
		assertEquals("Wei.U.Li@alcatel-sbell.com.cn", email);
		try {
			controller.getEmail("dd");
		} catch (Exception e) {
			assertTrue(e instanceof RuntimeException);
		}
	}

}
