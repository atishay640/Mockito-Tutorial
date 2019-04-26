package org.gwl.mockito_poc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;

public class MockitoVerificationTest {

	@Test
	public void testList() {
		List< String> mockList = mock(ArrayList.class);
		mockList.add("JMock");
		mockList.add("EasyMock");
		mockList.add("Mockito");
		
		mockList.add("PowerMock");
		mockList.add("PowerMock");
		mockList.clear();

		
		//1. verification of a single call.
		verify(mockList).add("JMock");
		// or
		verify(mockList, VerificationModeFactory.times(1)).add("JMock");
		
		//2. exact number of invocations verification
		verify(mockList, VerificationModeFactory.times(2)).add("PowerMock");
		
		// verification of never.
		verify(mockList, never()).add("TestNG");

		//3. Multiple mocks that must be used in a particular order
		List<String> firstMock = mock(List.class);
		List<String> secondMock = mock(List.class);
		 
		//using mocks
		firstMock.add("was called first");
		secondMock.add("was called second");
		 
		//create inOrder object passing any mocks that need to be verified in order
		InOrder inOrder = Mockito.inOrder(firstMock, secondMock);
		 
		//following will make sure that firstMock was called before secondMock
		inOrder.verify(firstMock).add("was called first");
		inOrder.verify(secondMock).add("was called second");
		
	}
}
