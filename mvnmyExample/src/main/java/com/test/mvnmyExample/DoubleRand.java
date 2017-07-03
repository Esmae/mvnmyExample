package com.test.mvnmyExample;

import java.util.Random;

public class DoubleRand {

	/**
	 * Initialises array & sums numbers uses static methods The array consists
	 * of randomly generated doubles
	 */

	public static double[] popArray(int size) {
		// initialising array
		double[] myArray = new double[size];
		// creating the random number generator
		Random randGenerator = new Random(11);

		for (int i = 0; i < size; i++) {
			// will produce pseudo random doubles
			myArray[i] = randGenerator.nextDouble();
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
