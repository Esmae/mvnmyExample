package com.test.mvnmyExample;
/**
 * Initialises array & sums numbers
 * uses static methods
 */

public class TriNum {

	public static void main(String[] args) {
		System.out.println(popArrayCount(11));
	}

	private static int popArrayCount(int size) {
		//initialising array
		int[] myArray = new int[size];
		for(int i=0;i<size;i++){
			myArray[i]=i;
		}
		//cumaltive sum of numbers in array
		int count = 0;
		for(int i=0;i<size;i++){
			count = count + myArray[i];
		}
		return count;
	}

}
