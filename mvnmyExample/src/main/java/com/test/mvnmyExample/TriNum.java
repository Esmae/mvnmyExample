package com.test.mvnmyExample;

/**
 * Initialises array & sums numbers uses static methods
 */

public class TriNum {

	public static int[] popArray(int size) {
		// initialising array
		int[] myArray = new int[size];
		for (int i = 0; i < size; i++) {
			myArray[i] = i;
		}
		return myArray;
	}

	public static int cumCount(int[] theArray) {
		// Cumulative sum of numbers in array
		int size = theArray.length;
		int count = 0;
		for (int i = 0; i < size; i++) {
			count = count + theArray[i];
		}
		return count;
	}

}
