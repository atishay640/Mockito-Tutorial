package org.gwl.mockito_poc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class CalulatorTest {

	/**
	 * Without using Mockito
	 */
	@Test
	public void testAdd() {
		Calulator calulator = new Calulator();
		int sum = calulator.add(10, 20);
		assertEquals(30, sum);
	}

	/**
	 * With Mockito
	 */
	@Test
	public void testAddWithMock() {
		// Mocking
		Calulator calulator = mock(Calulator.class);

		// Stubbing 
		when(calulator.add(10, 20)).thenReturn(30);
		
		int sum = calulator.add(10, 20);
		assertEquals(30, sum);
	}
	
	/**
	 * With Mock, Stubbing, Verify
	 */
	@Test
	public void testAddWithMockStubVerify() {
		// Mocking
		Calulator calulator = mock(Calulator.class);

		// Stubbing 
		when(calulator.add(10, 20)).thenReturn(30);
		
		int sum = calulator.add(10, 20);
		assertEquals(30, sum);
		
		// Verification 
		verify(calulator).add(10, 20);
		
		// Verification of non stubbing case
		// verify(calulator).blank();
	}
}
