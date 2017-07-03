package com.test.mvnmyExample;

import java.util.Random;

public class IntRand {

	/**
	 * Initialises array & sums numbers uses static methods The array consists
	 * of randomly generated ints
	 */

	public static int[] popArray(int size) {
		// initialising array
		int[] myArray = new int[size];
		// creating the random number generator
		Random randGenerator = new Random(11);

		for (int i = 0; i < size; i++) {
			// will produce pseudo random ints
			myArray[i] = randGenerator.nextInt();
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
