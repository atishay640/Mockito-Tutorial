package org.gwl.mockito_poc;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ArgumentMatcherTest {

	@Test
	public void testMatchers() {
		// Mocking
		List<String> mockList = mock(List.class);

		// stubbing using built-in anyInt() argument matcher
		when(mockList.get(anyInt())).thenReturn("Galaxy");

		System.out.println(mockList.get(0));
		System.out.println(mockList.get(10));

		reset(mockList);
		
		// stubbing using built-in eq() argument matcher
		when(mockList.get(eq(0))).thenReturn("Galaxy");

		System.out.println(mockList.get(0));
		System.out.println(mockList.get(10));

	}
}
