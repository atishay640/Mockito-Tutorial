package org.gwl.mockito_poc;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StubbingFamilyMethodsTest {

	/**
	 * Mocking
	 */
	@Mock
	List<String> mockList;

	/**
	 * Throw exception when a void method invoked
	 */
	@Test
	public void testVoidMethodAndThrowException() {
		// Stubbing
		doThrow(new RuntimeException("Clearing List may cause data loss.")).when(mockList).clear();
		when(mockList.add(anyString())).thenReturn((anyBoolean()));

		//
		System.out.println(mockList.add("Data"));
		mockList.clear();
	}

	@Test
	public void testVoidMethodAndDoNothing() {
		// Stubbing
		doNothing().when(mockList).clear();
		when(mockList.add(anyString())).thenReturn(true);// (anyBoolean());

		//
		System.out.println(mockList.add("Data"));
		mockList.clear();
	}
}
