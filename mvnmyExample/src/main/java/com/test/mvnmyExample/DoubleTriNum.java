package com.test.mvnmyExample;

public class DoubleTriNum {

	/**
	 * Initialises array & sums numbers uses static methods The array consists
	 * of doubles in order 0.0,1.0,2.0,3.0...
	 */

	public static double[] popArray(int size) {
		// initialising array
		double[] myArray = new double[size];
		for (int i = 0; i < size; i++) {
			myArray[i] = (double) i;
		}
		return myArray;
	}

	public static double cumCount(double[] theArray) {
		// Cumulative sum of numbers in array
		int size = theArray.length;
		double count = 0;
		for (int i = 0; i < size; i++) {
			count = count + theArray[i];
		}
		return count;
	}

}
