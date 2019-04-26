package org.gwl.mockito_poc;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class StubbingTest {

	@Mock
	Set<String> mockList;

//	@Test
//	public void testConsecutive() {
//
//		// Stubbing consecutive calls
//		when(mockList.add("String1")).thenReturn(true).thenThrow(new RuntimeException("Duplicate Not Allowed"));
//
//		// First call
//		boolean result = mockList.add("String1");
//		System.out.println(result);
//
//		// Second call with same string
//		boolean resultDuplicate = mockList.add("String1");
//		System.out.println(resultDuplicate);
//	}

	@Test
	public void testStubbingWithCallback() {

		when(mockList.add(anyString())).thenAnswer(new Answer<Boolean>() {
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				Object[] strArr = invocation.getArguments();
				for (Object object : strArr) {
					String string = (String) object;
					if (string.equals("Even")) {
						return true;
					} else if (string.equals("Odd")) {
						return false;
					}
				}
				return false;
			}
		});
		
		System.out.println(mockList.add("Even"));
		System.out.println(mockList.add("Odd"));
		System.out.println(mockList.add("Even"));
	}
}
