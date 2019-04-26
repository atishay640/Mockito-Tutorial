package org.gwl.mockito_poc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SpyingTest {

	@Test
	public void testSpy() {
		List<String> list = new LinkedList<String>();
		List<String> spy = Mockito.spy(list);
		spy.add("One");
		spy.add("Two");
		System.out.println(spy.size()); // 2
	
		// Stubbing  (Optional)
		when(spy.size()).thenReturn(200);
		System.out.println(spy.size()); // 200
		
		// verify (Optional)
		verify(spy, times(2)).size();
	}
}
