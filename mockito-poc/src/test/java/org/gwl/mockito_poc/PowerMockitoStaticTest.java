package org.gwl.mockito_poc;

import static org.mockito.Mockito.times;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class) // 1: Added PowerMockito runner.
@PrepareForTest(DateUtility.class) // 2: Preparing Class Under test 
public class PowerMockitoStaticTest {

	@Test
	public void testStaticMethod() {
		// 3:  PowerMockito creating mock of class to invoke static method
		PowerMockito.mockStatic(DateUtility.class); 

		// 4: Stubbing 
		Mockito.when(DateUtility.getCurrentDateTime()).thenCallRealMethod();

		Date dateResult = DateUtility.getCurrentDateTime();
		System.out.println(dateResult);
		// 5: Verification
		PowerMockito.verifyStatic(DateUtility.class , times(1));
		DateUtility.getCurrentDateTime();
		
	}
}
