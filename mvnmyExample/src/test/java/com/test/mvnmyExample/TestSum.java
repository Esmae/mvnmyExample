package com.test.mvnmyExample;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests TriNum
 */

public class TestSum {

	@Test
	public void testCumCount() {
		testCumCount(200);
	}

	private void testCumCount(int sizeOfArray) {
		if (sizeOfArray <= 0) { // array size must be positive
			System.out.println("Invalid Number: Enter a value greater than zero");
		}

		int[] theArray = IntTriNum.popArray(sizeOfArray);// initialising the array

		int cumCountNum = IntTriNum.cumCount(theArray);// performing a cumulative
													// sum of numbers in array

		Assert.assertEquals(sizeOfArray * (sizeOfArray - 1) / 2, cumCountNum);

	}

}
