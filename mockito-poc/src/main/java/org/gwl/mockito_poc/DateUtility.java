package org.gwl.mockito_poc;

import java.util.Date;

public class DateUtility {

	/**
	 * This method gets the current date and time.
	 * 
	 * @return date
	 */
	public static Date getCurrentDateTime() {
		return new Date();
	}

	private int privateApi(int x, int y) {
		System.out.println("DateUtility.privateApi()" + " sum: " + x + y);
		return x + y;
	}

	public void publicApi() {
		int sum =privateApi(10, 20);
		System.out.println("DateUtility.publicApi()" + " sum = "+ sum);
	}
}
