package org.gwl.mockito_poc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

//@RunWith(MockitoJUnitRunner.class)
public class MockAnnotation {

	/**
	 * Mocking
	 */
	@Mock
	Calulator calulator;

	@Mock
	List<String> mockList;

	/**
	 * init mock object
	 */
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * With @Mock
	 */
	@Test
	public void testAddWithMockAnnotation() {

		// Stubbing
		when(calulator.add(10, 20)).thenReturn(30);

		int sum = calulator.add(10, 20);
		assertEquals(30, sum);

		// Verification
		verify(calulator).add(10, 20);
	}

	/**
	 * With @Mock
	 */
	@Test
	public void testListWithMockAnnotation() {
		when(mockList.add("Galaxy BTC")).thenReturn(true);

		System.out.println(mockList.add("Galaxy BTC"));
		verify(mockList).add("Galaxy BTC");
	}
}
